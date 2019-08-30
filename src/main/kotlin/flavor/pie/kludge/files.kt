package flavor.pie.kludge

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStream
import java.io.OutputStream
import java.nio.channels.SeekableByteChannel
import java.nio.charset.Charset
import java.nio.file.CopyOption
import java.nio.file.DirectoryStream
import java.nio.file.FileStore
import java.nio.file.FileVisitOption
import java.nio.file.FileVisitor
import java.nio.file.Files
import java.nio.file.LinkOption
import java.nio.file.OpenOption
import java.nio.file.Path
import java.nio.file.attribute.BasicFileAttributes
import java.nio.file.attribute.FileAttribute
import java.nio.file.attribute.FileAttributeView
import java.nio.file.attribute.FileTime
import java.nio.file.attribute.PosixFilePermission
import java.nio.file.attribute.UserPrincipal
import java.util.function.BiPredicate
import kotlin.streams.asSequence

/**
 * @see Files.newInputStream
 */
fun Path.newInputStream(vararg options: OpenOption): InputStream = Files.newInputStream(this, *options)

/**
 * @see Files.newOutputStream
 */
fun Path.newOutputStream(vararg options: OpenOption): OutputStream = Files.newOutputStream(this, *options)

/**
 * @see Files.newByteChannel
 */
fun Path.newByteChannel(vararg options: OpenOption): SeekableByteChannel = Files.newByteChannel(this, *options)

/**
 * @see Files.newByteChannel
 */
fun Path.newByteChannel(options: Set<OpenOption>, vararg attributes: FileAttribute<*>): SeekableByteChannel =
    Files.newByteChannel(this, options, *attributes)

/**
 * @see Files.newDirectoryStream
 */
fun Path.newDirectoryStream(): DirectoryStream<Path> = Files.newDirectoryStream(this)

/**
 * @see Files.newDirectoryStream
 */
fun Path.newDirectoryStream(glob: String): DirectoryStream<Path> = Files.newDirectoryStream(this, glob)

/**
 * @see Files.newDirectoryStream
 */
fun Path.newDirectoryStream(filter: DirectoryStream.Filter<in Path>): DirectoryStream<Path> =
    Files.newDirectoryStream(this, filter)

/**
 * @see Files.createFile
 */
fun Path.createFile(vararg attrs: FileAttribute<*>): Path = Files.createFile(this, *attrs)

/**
 * @see Files.createDirectory
 */
fun Path.createDirectory(vararg attrs: FileAttribute<*>): Path = Files.createDirectory(this, *attrs)

/**
 * @see Files.createDirectories
 */
fun Path.createDirectories(vararg attrs: FileAttribute<*>): Path = Files.createDirectories(this, *attrs)

/**
 * @see Files.createTempFile
 */
fun Path.createTempFile(prefix: String, suffix: String, vararg attrs: FileAttribute<*>): Path =
    Files.createTempFile(this, prefix, suffix, *attrs)

/**
 * @see Files.createTempDirectory
 */
fun Path.createTempDirectory(prefix: String, vararg attrs: FileAttribute<*>): Path =
    Files.createTempDirectory(this, prefix, *attrs)

/**
 * @see Files.createSymbolicLink
 */
fun Path.createSymbolicLink(target: Path, vararg attrs: FileAttribute<*>): Path =
    Files.createSymbolicLink(this, target, *attrs)

/**
 * @see Files.createLink
 */
fun Path.createLink(existing: Path): Path = Files.createLink(this, existing)

/**
 * @see Files.delete
 */
fun Path.delete() = Files.delete(this)

/**
 * @see Files.deleteIfExists
 */
fun Path.deleteIfExists() = Files.deleteIfExists(this)

/**
 * @see Files.copy
 */
fun Path.copy(target: Path, vararg options: CopyOption): Path = Files.copy(this, target, *options)

/**
 * @see Files.move
 */
fun Path.move(target: Path, vararg options: CopyOption): Path = Files.copy(this, target, *options)

/**
 * @see Files.readSymbolicLink
 */
fun Path.readSymbolicLink(): Path = Files.readSymbolicLink(this)

/**
 * @see Files.getFileStore
 */
fun Path.getFileStore(): FileStore = Files.getFileStore(this)

/**
 * @see Files.isSameFile
 */
fun Path.isSameFile(path2: Path): Boolean = Files.isSameFile(this, path2)

/**
 * @see Files.isHidden
 */
fun Path.isHidden(): Boolean = Files.isHidden(this)

/**
 * @see Files.probeContentType
 */
fun Path.probeContentType(): String? = Files.probeContentType(this)

/**
 * @see Files.getFileAttributeView
 */
inline fun <reified V : FileAttributeView> Path.getFileAttributeView(vararg options: LinkOption): V? =
    Files.getFileAttributeView(this, V::class.java, *options)

/**
 * @see Files.readAttributes
 */
inline fun <reified A : BasicFileAttributes> Path.readAttributes(vararg options: LinkOption): A =
    Files.readAttributes(this, A::class.java, *options)

/**
 * @see Files.setAttribute
 */
fun Path.setAttribute(attribute: String, value: Any, vararg options: LinkOption): Path =
    Files.setAttribute(this, attribute, value, *options)

/**
 * @see Files.getAttribute
 */
fun Path.getAttribute(attribute: String, vararg options: LinkOption): Any =
    Files.getAttribute(this, attribute, *options)

/**
 * @see Files.readAttributes
 */
fun Path.readAttributes(attributes: String, vararg options: LinkOption): Map<String, Any> =
    Files.readAttributes(this, attributes, *options)

/**
 * @see Files.getPosixFilePermissions
 */
fun Path.getPosixFilePermissions(vararg options: LinkOption): Set<PosixFilePermission> =
    Files.getPosixFilePermissions(this, *options)

/**
 * @see Files.getPosixFilePermissions
 * @see Files.setPosixFilePermissions
 */
var Path.posixFilePermissions: Set<PosixFilePermission>
    get() = Files.getPosixFilePermissions(this)
    set(value) {
        Files.setPosixFilePermissions(this, value)
    }


/**
 * @see Files.getOwner
 */
fun Path.getOwner(vararg options: LinkOption): UserPrincipal = Files.getOwner(this, *options)

/**
 * @see Files.getOwner
 * @see Files.setOwner
 */
var Path.owner: UserPrincipal
    get() = Files.getOwner(this)
    set(value) {
        Files.setOwner(this, value)
    }

/**
 * @see Files.isSymbolicLink
 */
val Path.isSymbolicLink: Boolean get() = Files.isSymbolicLink(this)

/**
 * @see Files.isDirectory
 */
val Path.isDirectory: Boolean get() = Files.isDirectory(this)

/**
 * @see Files.isDirectory
 */
fun Path.isDirectory(vararg options: LinkOption): Boolean = Files.isDirectory(this, *options)

/**
 * @see Files.isRegularFile
 */
val Path.isRegularFile: Boolean get() = Files.isRegularFile(this)

/**
 * @see Files.isRegularFile
 */
fun Path.isRegularFile(vararg options: LinkOption): Boolean = Files.isRegularFile(this, *options)

/**
 * @see Files.getLastModifiedTime
 */
fun Path.getLastModifiedTime(vararg options: LinkOption): FileTime = Files.getLastModifiedTime(this, *options)

/**
 * @see Files.getLastModifiedTime
 * @see Files.setLastModifiedTime
 */
var Path.lastModifiedTime: FileTime
    get() = Files.getLastModifiedTime(this)
    set(value) {
        Files.setLastModifiedTime(this, value)
    }

/**
 * @see Files.size
 */
val Path.size: Long get() = Files.size(this)

/**
 * @see Files.exists
 */
fun Path.exists(vararg options: LinkOption): Boolean = Files.exists(this, *options)

/**
 * @see Files.exists
 */
val Path.exists: Boolean get() = Files.exists(this)

/**
 * @see Files.notExists
 */
fun Path.notExists(vararg options: LinkOption): Boolean = Files.notExists(this, *options)

/**
 * @see Files.notExists
 */
val Path.notExists: Boolean get() = Files.notExists(this)

/**
 * @see Files.isReadable
 */
val Path.isReadable: Boolean get() = Files.isReadable(this)

/**
 * @see Files.isWritable
 */
val Path.isWritable: Boolean get() = Files.isWritable(this)

/**
 * @see Files.isExecutable
 */
val Path.isExecutable: Boolean get() = Files.isExecutable(this)

/**
 * @see Files.walkFileTree
 */
fun Path.walkFileTree(options: Set<FileVisitOption>, maxDepth: Int, visitor: FileVisitor<in Path>): Path =
    Files.walkFileTree(this, options, maxDepth, visitor)

/**
 * @see Files.walkFileTree
 */
fun Path.walkFileTree(visitor: FileVisitor<in Path>): Path = Files.walkFileTree(this, visitor)

/**
 * @see Files.newBufferedReader
 */
fun Path.newBufferedReader(cs: Charset): BufferedReader = Files.newBufferedReader(this, cs)

/**
 * @see Files.newBufferedReader
 */
fun Path.newBufferedReader(): BufferedReader = Files.newBufferedReader(this)

/**
 * @see Files.newBufferedWriter
 */
fun Path.newBufferedWriter(cs: Charset, vararg options: OpenOption): BufferedWriter =
    Files.newBufferedWriter(this, cs, *options)

/**
 * @see Files.newBufferedWriter
 */
fun Path.newBufferedWriter(vararg options: OpenOption): BufferedWriter = Files.newBufferedWriter(this, *options)

/**
 * @see Files.copy
 */
fun Path.copy(`in`: InputStream, vararg options: CopyOption): Long = Files.copy(`in`, this, *options)

/**
 * @see Files.copy
 */
fun Path.copy(out: OutputStream): Long = Files.copy(this, out)

/**
 * @see Files.readAllBytes
 */
fun Path.readAllBytes(): ByteArray = Files.readAllBytes(this)

/**
 * @see Files.readAllLines
 */
fun Path.readAllLines(): List<String> = Files.readAllLines(this)

/**
 * @see Files.readAllLines
 */
fun Path.readAllLines(cs: Charset): List<String> = Files.readAllLines(this, cs)

/**
 * @see Files.write
 */
fun Path.write(bytes: ByteArray, vararg options: OpenOption): Path = Files.write(this, bytes, *options)

/**
 * @see Files.write
 */
fun Path.write(lines: Iterable<CharSequence>, cs: Charset, vararg options: OpenOption): Path =
    Files.write(this, lines, cs, *options)

/**
 * @see Files.write
 */
fun Path.write(lines: Iterable<CharSequence>, vararg options: OpenOption): Path = Files.write(this, lines, *options)

/**
 * @see Files.list
 */
fun Path.list(): Sequence<Path> = Files.list(this).asSequence()

/**
 * @see Files.walk
 */
fun Path.walk(maxDepth: Int, vararg options: FileVisitOption): Sequence<Path> =
    Files.walk(this, maxDepth, *options).asSequence()

/**
 * @see Files.walk
 */
fun Path.walk(vararg options: FileVisitOption): Sequence<Path> = Files.walk(this, *options).asSequence()

/**
 * @see Files.find
 */
fun Path.find(
    maxDepth: Int,
    matcher: (Path, BasicFileAttributes) -> Boolean,
    vararg options: FileVisitOption
): Sequence<Path> = Files.find(this, maxDepth, BiPredicate(matcher), *options).asSequence()

/**
 * @see Files.lines
 */
fun Path.lines(cs: Charset): Sequence<String> = Files.lines(this, cs).asSequence()

/**
 * @see Files.lines
 */
fun Path.lines(): Sequence<String> = Files.lines(this).asSequence()
