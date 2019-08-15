package flavor.pie.kludge

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.BeanProperty
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.KeyDeserializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.deser.ContextualDeserializer
import com.fasterxml.jackson.databind.deser.ContextualKeyDeserializer
import com.fasterxml.jackson.databind.module.SimpleModule
import com.flowpowered.math.imaginary.Complexd
import com.flowpowered.math.vector.Vector3d
import com.flowpowered.math.vector.Vector3i
import com.uchuhimo.konf.Config
import com.uchuhimo.konf.source.Loader
import com.uchuhimo.konf.source.Writer
import org.spongepowered.api.CatalogType
import org.spongepowered.api.data.DataContainer
import org.spongepowered.api.data.DataQuery
import org.spongepowered.api.data.DataSerializable
import org.spongepowered.api.data.DataView
import org.spongepowered.api.data.persistence.DataFormats
import org.spongepowered.api.data.persistence.DataTranslators
import org.spongepowered.api.text.Text
import org.spongepowered.api.text.serializer.TextSerializers
import org.spongepowered.api.world.schematic.Schematic
import java.util.UUID

fun Loader.asset(plugin: Any, name: String): Config = AssetManager.getAsset(plugin, name).unwrap()?.let {
    this.config.withSource(this.provider.fromUrl(it.url))
} ?: this.config

fun Loader.asset(name: String): Config = this.asset(plugin, name)

fun Loader.defaultConfig(plugin: Any, sharedRoot: Boolean = true): Config =
    this.file(
        if (sharedRoot) {
            ConfigManager.getSharedConfig(plugin)
        } else {
            ConfigManager.getPluginConfig(plugin)
        }.configPath.toFile()
    )

fun Loader.defaultConfig(sharedRoot: Boolean = true): Config = this.defaultConfig(plugin, sharedRoot)

fun Loader.watchDefaultConfig(plugin: Any, sharedRoot: Boolean = true): Config =
    this.watchFile(
        if (sharedRoot) {
            ConfigManager.getSharedConfig(plugin)
        } else {
            ConfigManager.getPluginConfig(plugin)
        }.configPath.toFile()
    )

fun Loader.watchDefaultConfig(sharedRoot: Boolean = true): Config = this.watchDefaultConfig(plugin, sharedRoot)

fun Writer.toDefaultConfig(plugin: Any, sharedRoot: Boolean = true) {
    this.toFile(
        if (sharedRoot) {
            ConfigManager.getSharedConfig(plugin)
        } else {
            ConfigManager.getPluginConfig(plugin)
        }.configPath.toFile()
    )
}

fun Writer.toDefaultConfig(sharedRoot: Boolean = true) = this.toDefaultConfig(plugin, sharedRoot)

fun Config.addSpongeTypes(): Config {
    this.mapper.registerModules(SpongeModule)
    return this
}

private object SpongeModule : SimpleModule() {

    init {
        addSerializer(DataSerializable::class.java, DataSerializableSerializer)
        addDeserializer(DataSerializable::class.java, DataSerializableDeserializer)
        addSerializer(CatalogType::class.java, CatalogTypeSerializer)
        addDeserializer(CatalogType::class.java, CatalogTypeDeserializer)
        addSerializer(DataView::class.java, DataViewSerializer)
        addDeserializer(DataView::class.java, DataViewDeserializer)
        addSerializer(DataContainer::class.java, DataContainerSerializer)
        addDeserializer(DataContainer::class.java, DataContainerDeserializer)
        addKeySerializer(CatalogType::class.java, CatalogTypeSerializer)
        addKeyDeserializer(CatalogType::class.java, CatalogTypeKeyDeserializer)
        addSerializer(UUID::class.java, UUIDSerializer)
        addDeserializer(UUID::class.java, UUIDDeserializer)
        addKeySerializer(UUID::class.java, UUIDSerializer)
        addKeyDeserializer(UUID::class.java, UUIDKeyDeserializer)
        addSerializer(Complexd::class.java, ComplexdSerializer)
        addDeserializer(Complexd::class.java, ComplexdDeserializer)
        addSerializer(Vector3i::class.java, Vector3iSerializer)
        addDeserializer(Vector3i::class.java, Vector3iDeserializer)
        addSerializer(Vector3d::class.java, Vector3dSerializer)
        addDeserializer(Vector3d::class.java, Vector3dDeserializer)
        addSerializer(Text::class.java, TextSerializer)
        addDeserializer(Text::class.java, TextDeserializer)
    }

}

private object DataSerializableSerializer : JsonSerializer<DataSerializable>() {

    override fun serialize(value: DataSerializable, gen: JsonGenerator, serializers: SerializerProvider) {
        DataViewSerializer.serialize(value.toContainer(), gen, serializers)
    }

}

private class DataSerializableDeserializer(val clazz: Class<*>) : JsonDeserializer<DataSerializable>() {

    companion object : ContextualDeserializer, JsonDeserializer<DataSerializable>() {

        override fun deserialize(p: JsonParser, ctxt: DeserializationContext): DataSerializable {
            throw JsonMappingException(p, "No context specified")
        }

        override fun createContextual(ctxt: DeserializationContext, property: BeanProperty): JsonDeserializer<*> {
            return DataSerializableDeserializer(ctxt.contextualType.rawClass)
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): DataSerializable {
        val data = DataContainerDeserializer.deserialize(p, ctxt)
        return DataManager.deserialize(clazz as Class<DataSerializable>, data).unwrap()
            ?: throw JsonParseException(p, "Invalid ${clazz.simpleName} structure")
    }

}

private object DataViewSerializer : JsonSerializer<DataView>() {

    override fun serialize(value: DataView, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeStartObject(value)
        for (key in value.getKeys(false)) {
            val item = value.get(key).unwrap()
            gen.writeFieldName(key.toString())
            gen.writeAny(item, serializers)
        }
        gen.writeEndObject()
    }

}

private object DataContainerSerializer : JsonSerializer<DataContainer>() {

    override fun serialize(value: DataContainer, gen: JsonGenerator, serializers: SerializerProvider) {
        DataViewSerializer.serialize(value, gen, serializers)
    }

}

private object DataContainerDeserializer : JsonDeserializer<DataContainer>() {

    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): DataContainer {
        if (p.currentToken == JsonToken.START_OBJECT) {
            p.nextToken()
        }
        val container = DataContainer.createNew()
        while (true) {
            when (p.nextToken()) {
                JsonToken.VALUE_EMBEDDED_OBJECT -> container.set(DataQuery.of(p.currentName), p.currentValue)
                JsonToken.VALUE_FALSE -> container.set(DataQuery.of(p.currentName), false)
                JsonToken.VALUE_TRUE -> container.set(DataQuery.of(p.currentName), true)
                JsonToken.VALUE_NUMBER_INT, JsonToken.VALUE_NUMBER_FLOAT ->
                    container.set(DataQuery.of(p.currentName), p.numberValue)
                JsonToken.VALUE_STRING -> container.set(DataQuery.of(p.currentName), p.text)
                JsonToken.START_OBJECT -> container.set(DataQuery.of(p.currentName), deserialize(p, ctxt))
                JsonToken.START_ARRAY -> {
                    fun readArray(): List<Any> {
                        val list = mutableListOf<Any>()
                        while (p.nextToken() != JsonToken.END_ARRAY) {
                            when (p.currentToken) {
                                JsonToken.VALUE_STRING -> list += p.text
                                JsonToken.VALUE_NUMBER_FLOAT, JsonToken.VALUE_NUMBER_INT -> list += p.numberValue
                                JsonToken.VALUE_TRUE -> list += true
                                JsonToken.VALUE_FALSE -> list += false
                                JsonToken.VALUE_NULL -> list += DataContainer.createNew()
                                JsonToken.VALUE_EMBEDDED_OBJECT -> list += p.currentValue
                                JsonToken.START_ARRAY -> readArray()
                                JsonToken.START_OBJECT -> deserialize(p, ctxt)
                                else -> {
                                }
                            }
                        }
                        return list
                    }
                    container.set(DataQuery.of(p.currentName), readArray())
                }
                JsonToken.END_OBJECT -> return container
                else -> {
                }
            }
            p.nextToken()
        }
    }

}

private object DataViewDeserializer : JsonDeserializer<DataView>() {

    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): DataView {
        return DataContainerDeserializer.deserialize(p, ctxt)
    }

}

fun JsonGenerator.writeAny(any: Any?, serializers: SerializerProvider) {
    when (any) {
        null -> writeNull()
        is DataView -> DataViewSerializer.serialize(any, this, serializers)
        is Boolean -> writeBoolean(any)
        is Short -> writeNumber(any)
        is Byte -> writeNumber(any.toInt())
        is Int -> writeNumber(any)
        is Float -> writeNumber(any)
        is Long -> writeNumber(any)
        is Double -> writeNumber(any)
        is String -> writeString(any)
        is BooleanArray -> {
            writeStartArray(any.size)
            for (item in any) {
                writeBoolean(item)
            }
            writeEndArray()
        }
        is ShortArray -> {
            writeStartArray(any.size)
            for (item in any) {
                writeNumber(item)
            }
            writeEndArray()
        }
        is ByteArray -> {
            writeStartArray(any.size)
            for (item in any) {
                writeNumber(item.toInt())
            }
            writeEndArray()
        }
        is IntArray -> writeArray(any, 0, any.size)
        is FloatArray -> {
            writeStartArray(any.size)
            for (item in any) {
                writeNumber(item)
            }
            writeEndArray()
        }
        is LongArray -> writeArray(any, 0, any.size)
        is DoubleArray -> writeArray(any, 0, any.size)
        is Array<*> -> {
            writeStartArray(any.size)
            for (item in any) {
                writeAny(item, serializers)
            }
            writeEndArray()
        }
        is List<*> -> {
            writeStartArray(any.size)
            for (item in any) {
                writeAny(item, serializers)
            }
            writeEndArray()
        }
        else -> writeString(any.toString())
    }

}

private object CatalogTypeSerializer : JsonSerializer<CatalogType>() {

    override fun serialize(value: CatalogType, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeString(value.id)
    }

}

private class CatalogTypeDeserializer(val clazz: Class<*>) : JsonDeserializer<CatalogType>() {

    companion object : JsonDeserializer<CatalogType>(), ContextualDeserializer {

        override fun deserialize(p: JsonParser, ctxt: DeserializationContext): CatalogType {
            throw JsonMappingException(p, "No context specified")
        }

        override fun createContextual(ctxt: DeserializationContext, property: BeanProperty): JsonDeserializer<*> {
            return CatalogTypeDeserializer(ctxt.contextualType.rawClass)
        }

    }

    @Suppress("UNCHECKED_CAST")
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): CatalogType {
        return GameRegistry.getType(clazz as Class<CatalogType>, p.nextTextValue()).unwrap()
            ?: throw JsonParseException(p, "No such ${clazz.simpleName} found")
    }

}

private class CatalogTypeKeyDeserializer(val clazz: Class<*>) : KeyDeserializer() {

    companion object : KeyDeserializer(), ContextualKeyDeserializer {

        override fun deserializeKey(key: String, ctxt: DeserializationContext): Any {
            throw UnsupportedOperationException("No context specified")
        }

        override fun createContextual(ctxt: DeserializationContext, property: BeanProperty): KeyDeserializer {
            return CatalogTypeKeyDeserializer(ctxt.contextualType.rawClass)
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun deserializeKey(key: String, ctxt: DeserializationContext): Any {
        return GameRegistry.getType(clazz as Class<CatalogType>, key)
    }

}

private object UUIDSerializer : JsonSerializer<UUID>() {

    override fun serialize(value: UUID, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeString(value.toString())
    }

}

private object UUIDDeserializer : JsonDeserializer<UUID>() {

    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): UUID {
        try {
            return UUID.fromString(p.valueAsString)
        } catch (e: IllegalArgumentException) {
            throw JsonParseException(p, "Invalid UUID", e)
        }
    }

}

private object UUIDKeyDeserializer : KeyDeserializer() {

    override fun deserializeKey(key: String, ctxt: DeserializationContext): Any {
        try {
            return UUID.fromString(key)
        } catch (e: IllegalArgumentException) {
            throw JsonParseException(ctxt.parser, "Invalid UUID", e)
        }
    }

}

private object SchematicSerializer : JsonSerializer<Schematic>() {
    override fun serialize(value: Schematic, gen: JsonGenerator, serializers: SerializerProvider) {
        val container = DataTranslators.SCHEMATIC.translate(value)
        DataContainerSerializer.serialize(container, gen, serializers)
    }
}

private object SchematicDeserializer : JsonDeserializer<Schematic>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Schematic {
        val container = DataContainerDeserializer.deserialize(p, ctxt)
        return DataTranslators.SCHEMATIC.translate(container)
    }
}

private object ComplexdSerializer : JsonSerializer<Complexd>() {
    override fun serialize(value: Complexd, gen: JsonGenerator, serializers: SerializerProvider) {
        val container = DataTranslators.COMPLEXD.translate(value)
        DataContainerSerializer.serialize(container, gen, serializers)
    }
}

private object ComplexdDeserializer : JsonDeserializer<Complexd>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Complexd {
        val container = DataContainerDeserializer.deserialize(p, ctxt)
        return DataTranslators.COMPLEXD.translate(container)
    }
}

private object Vector3iSerializer : JsonSerializer<Vector3i>() {
    override fun serialize(value: Vector3i, gen: JsonGenerator, serializers: SerializerProvider) {
        val container = DataTranslators.VECTOR_3_I.translate(value)
        DataContainerSerializer.serialize(container, gen, serializers)
    }
}

private object Vector3iDeserializer : JsonDeserializer<Vector3i>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Vector3i {
        val container = DataContainerDeserializer.deserialize(p, ctxt)
        return DataTranslators.VECTOR_3_I.translate(container)
    }
}
private object Vector3dSerializer : JsonSerializer<Vector3d>() {
    override fun serialize(value: Vector3d, gen: JsonGenerator, serializers: SerializerProvider) {
        val container = DataTranslators.VECTOR_3_D.translate(value)
        DataContainerSerializer.serialize(container, gen, serializers)
    }
}

private object Vector3dDeserializer : JsonDeserializer<Vector3d>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Vector3d {
        val container = DataContainerDeserializer.deserialize(p, ctxt)
        return DataTranslators.VECTOR_3_D.translate(container)
    }
}

private object TextSerializer : JsonSerializer<Text>() {
    override fun serialize(value: Text, gen: JsonGenerator, serializers: SerializerProvider) {
        val json = TextSerializers.JSON.serialize(value)
        val data = DataFormats.JSON.read(json)
        DataContainerSerializer.serialize(data, gen, serializers)
    }
}

private object TextDeserializer : JsonDeserializer<Text>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Text {
        val container = DataContainerDeserializer.deserialize(p, ctxt)
        val json = DataFormats.JSON.write(container)
        return TextSerializers.JSON.deserialize(json)
    }
}
