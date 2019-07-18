package flavor.pie.kludge

import com.flowpowered.math.imaginary.Complexd
import com.flowpowered.math.imaginary.Complexf
import com.flowpowered.math.imaginary.Imaginaryd
import com.flowpowered.math.imaginary.Imaginaryf
import com.flowpowered.math.imaginary.Quaterniond
import com.flowpowered.math.imaginary.Quaternionf
import com.flowpowered.math.matrix.Matrix2d
import com.flowpowered.math.matrix.Matrix2f
import com.flowpowered.math.matrix.Matrix3d
import com.flowpowered.math.matrix.Matrix3f
import com.flowpowered.math.matrix.Matrix4d
import com.flowpowered.math.matrix.Matrix4f
import com.flowpowered.math.matrix.MatrixNd
import com.flowpowered.math.matrix.MatrixNf
import com.flowpowered.math.matrix.Matrixd
import com.flowpowered.math.matrix.Matrixf
import com.flowpowered.math.vector.Vector2d
import com.flowpowered.math.vector.Vector2f
import com.flowpowered.math.vector.Vector2i
import com.flowpowered.math.vector.Vector2l
import com.flowpowered.math.vector.Vector3d
import com.flowpowered.math.vector.Vector3f
import com.flowpowered.math.vector.Vector3i
import com.flowpowered.math.vector.Vector3l
import com.flowpowered.math.vector.Vector4d
import com.flowpowered.math.vector.Vector4f
import com.flowpowered.math.vector.Vector4i
import com.flowpowered.math.vector.Vector4l
import com.flowpowered.math.vector.VectorNd
import com.flowpowered.math.vector.VectorNf
import com.flowpowered.math.vector.VectorNi
import com.flowpowered.math.vector.VectorNl
import com.flowpowered.math.vector.Vectord
import com.flowpowered.math.vector.Vectorf
import com.flowpowered.math.vector.Vectori
import com.flowpowered.math.vector.Vectorl
import org.spongepowered.api.entity.Transform
import org.spongepowered.api.world.extent.Extent
import kotlin.math.asin
import kotlin.math.atan
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

/**
 * @see Complexd.sub
 */
operator fun Complexd.minus(c: Complexd): Complexd = sub(c)

/**
 * @see Complexd.mul
 */
operator fun Complexd.times(c: Complexd): Complexd = mul(c)

/**
 * @see Complexd.mul
 */
operator fun Complexd.times(a: Double): Complexd = mul(a)

/**
 * @see Complexd.mul
 */
operator fun Complexd.times(a: Float): Complexd = mul(a)

/**
 * @see Complexd.mul
 */
operator fun Complexd.unaryMinus(): Complexd = mul(-1.0)

/**
 * @see Complexd.add
 */
operator fun Complexd.plus(c: Complexd): Complexd = add(c)

/**
 * @see Complexf.sub
 */
operator fun Complexf.minus(c: Complexf): Complexf = sub(c)

/**
 * @see Complexf.mul
 */
operator fun Complexf.times(c: Complexf): Complexf = mul(c)

/**
 * @see Complexf.mul
 */
operator fun Complexf.times(a: Double): Complexf = mul(a)

/**
 * @see Complexf.mul
 */
operator fun Complexf.times(a: Float): Complexf = mul(a)

/**
 * Negates this [Complexf].
 */
operator fun Complexf.unaryMinus(): Complexf = Complexf(-x, -y)

/**
 * @see Complexf.add
 */
operator fun Complexf.plus(c: Complexf): Complexf = add(c)

/**
 * @see Imaginaryd.mul
 */
operator fun Imaginaryd.times(a: Double): Imaginaryd = mul(a)

/**
 * Multiplies this [Imaginaryd] by -1.
 * @see Imaginaryd.mul
 */
operator fun Imaginaryd.unaryMinus(): Imaginaryd = mul(-1.0)

/**
 * @see Imaginaryf.mul
 */
operator fun Imaginaryf.times(a: Float): Imaginaryf = mul(a)

/**
 * Multiplies this [Imaginaryf] by -1.
 * @see Imaginaryf.mul
 */
operator fun Imaginaryf.unaryMinus(): Imaginaryf = mul(-1.0f)

/**
 * @see Matrix2d.sub
 */
operator fun Matrix2d.minus(m: Matrix2d): Matrix2d = sub(m)

/**
 * @see Matrix2d.mul
 */
operator fun Matrix2d.times(m: Matrix2d): Matrix2d = mul(m)

/**
 * @see Matrix2d.mul
 */
operator fun Matrix2d.times(a: Float): Matrix2d = mul(a)

/**
 * @see Matrix2d.mul
 */
operator fun Matrix2d.times(a: Double): Matrix2d = mul(a)

/**
 * Multiplies this [Matrix2d] by -1.
 * @see Matrix2d.mul
 */
operator fun Matrix2d.unaryMinus(): Matrix2d = mul(-1.0)

/**
 * @see Matrix2d.add
 */
operator fun Matrix2d.plus(m: Matrix2d): Matrix2d = add(m)


/**
 * @see Matrix2f.sub
 */
operator fun Matrix2f.minus(m: Matrix2f): Matrix2f = sub(m)

/**
 * @see Matrix2f.mul
 */
operator fun Matrix2f.times(m: Matrix2f): Matrix2f = mul(m)

/**
 * @see Matrix2f.mul
 */
operator fun Matrix2f.times(a: Float): Matrix2f = mul(a)

/**
 * @see Matrix2f.mul
 */
operator fun Matrix2f.times(a: Double): Matrix2f = mul(a)

/**
 * Multiplies this [Matrix2f] by -1.
 * @see Matrix2f.mul
 */
operator fun Matrix2f.unaryMinus(): Matrix2f = mul(-1.0)

/**
 * @see Matrix2f.add
 */
operator fun Matrix2f.plus(m: Matrix2f): Matrix2f = add(m)

/**
 * @see Matrix3d.sub
 */
operator fun Matrix3d.minus(m: Matrix3d): Matrix3d = sub(m)

/**
 * @see Matrix3d.mul
 */
operator fun Matrix3d.times(m: Matrix3d): Matrix3d = mul(m)

/**
 * @see Matrix3d.mul
 */
operator fun Matrix3d.times(a: Float): Matrix3d = mul(a)

/**
 * @see Matrix3d.mul
 */
operator fun Matrix3d.times(a: Double): Matrix3d = mul(a)

/**
 * Multiplies this [Matrix3d] by -1.
 * @see Matrix3d.mul
 */
operator fun Matrix3d.unaryMinus(): Matrix3d = mul(-1.0)

/**
 * @see Matrix3d.add
 */
operator fun Matrix3d.plus(m: Matrix3d): Matrix3d = add(m)

/**
 * @see Matrix3f.sub
 */
operator fun Matrix3f.minus(m: Matrix3f): Matrix3f = sub(m)

/**
 * @see Matrix3f.mul
 */
operator fun Matrix3f.times(m: Matrix3f): Matrix3f = mul(m)

/**
 * @see Matrix3f.mul
 */
operator fun Matrix3f.times(a: Float): Matrix3f = mul(a)

/**
 * @see Matrix3f.mul
 */
operator fun Matrix3f.times(a: Double): Matrix3f = mul(a)

/**
 * Multiplies this [Matrix3f] by -1.
 * @see Matrix3f.mul
 */
operator fun Matrix3f.unaryMinus(): Matrix3f = mul(-1.0)

/**
 * @see Matrix3f.add
 */
operator fun Matrix3f.plus(m: Matrix3f): Matrix3f = add(m)


/**
 * @see Matrix4d.sub
 */
operator fun Matrix4d.minus(m: Matrix4d): Matrix4d = sub(m)

/**
 * @see Matrix4d.mul
 */
operator fun Matrix4d.times(m: Matrix4d): Matrix4d = mul(m)

/**
 * @see Matrix4d.mul
 */
operator fun Matrix4d.times(a: Float): Matrix4d = mul(a)

/**
 * @see Matrix4d.mul
 */
operator fun Matrix4d.times(a: Double): Matrix4d = mul(a)

/**
 * Multiplies this [Matrix4d] by -1.
 * @see Matrix4d.mul
 */
operator fun Matrix4d.unaryMinus(): Matrix4d = mul(-1.0)

/**
 * @see Matrix4d.add
 */
operator fun Matrix4d.plus(m: Matrix4d): Matrix4d = add(m)


/**
 * @see Matrix4f.sub
 */
operator fun Matrix4f.minus(m: Matrix4f): Matrix4f = sub(m)

/**
 * @see Matrix4f.mul
 */
operator fun Matrix4f.times(m: Matrix4f): Matrix4f = mul(m)

/**
 * @see Matrix4f.mul
 */
operator fun Matrix4f.times(a: Float): Matrix4f = mul(a)

/**
 * @see Matrix4f.mul
 */
operator fun Matrix4f.times(a: Double): Matrix4f = mul(a)

/**
 * Multiplies this [Matrix4f] by -1.
 * @see Matrix4f.mul
 */
operator fun Matrix4f.unaryMinus(): Matrix4f = mul(-1.0)

/**
 * @see Matrix4f.add
 */
operator fun Matrix4f.plus(m: Matrix4f): Matrix4f = add(m)

operator fun Matrixd.times(a: Double): Matrixd = mul(a)
operator fun Matrixd.unaryMinus(): Matrixd = mul(-1.0)

operator fun Matrixf.times(a: Float): Matrixf = mul(a)
operator fun Matrixf.unaryMinus(): Matrixf = mul(-1.0f)


/**
 * @see MatrixNd.mul
 */
operator fun MatrixNd.times(a: Double): MatrixNd = mul(a)

/**
 * @see MatrixNd.mul
 */
operator fun MatrixNd.times(a: Float): MatrixNd = mul(a)

/**
 * @see MatrixNd.mul
 */
operator fun MatrixNd.times(m: MatrixNd): MatrixNd = mul(m)

/**
 * @see MatrixNd.sub
 */
operator fun MatrixNd.minus(m: MatrixNd): MatrixNd = sub(m)

/**
 * Multiplies this [MatrixNd] by -1.
 * @see MatrixNd.mul
 */
operator fun MatrixNd.unaryMinus(): MatrixNd = mul(-1.0)

/**
 * @see MatrixNd.add
 */
operator fun MatrixNd.plus(m: MatrixNd): MatrixNd = add(m)

/**
 * @see MatrixNf.mul
 */
operator fun MatrixNf.times(a: Double): MatrixNf = mul(a)

/**
 * @see MatrixNf.mul
 */
operator fun MatrixNf.times(a: Float): MatrixNf = mul(a)

/**
 * @see MatrixNf.mul
 */
operator fun MatrixNf.times(m: MatrixNf): MatrixNf = mul(m)

/**
 * @see MatrixNf.sub
 */
operator fun MatrixNf.minus(m: MatrixNf): MatrixNf = sub(m)

/**
 * Multiplies this [MatrixNf] by -1.
 * @see MatrixNf.mul
 */
operator fun MatrixNf.unaryMinus(): MatrixNf = mul(-1.0)

/**
 * @see MatrixNf.add
 */
operator fun MatrixNf.plus(m: MatrixNf): MatrixNf = add(m)


/**
 * @see Quaterniond.mul
 */
operator fun Quaterniond.times(a: Double): Quaterniond = mul(a)

/**
 * @see Quaterniond.mul
 */
operator fun Quaterniond.times(a: Float): Quaterniond = mul(a)

/**
 * @see Quaterniond.mul
 */
operator fun Quaterniond.times(m: Quaterniond): Quaterniond = mul(m)

/**
 * @see Quaterniond.sub
 */
operator fun Quaterniond.minus(m: Quaterniond): Quaterniond = sub(m)

/**
 * Multiplies this [Quaterniond] by -1.
 * @see Quaterniond.mul
 */
operator fun Quaterniond.unaryMinus(): Quaterniond = mul(-1.0)

/**
 * @see Quaterniond.add
 */
operator fun Quaterniond.plus(m: Quaterniond): Quaterniond = add(m)

/**
 * @see Quaternionf.mul
 */
operator fun Quaternionf.times(a: Double): Quaternionf = mul(a)

/**
 * @see Quaternionf.mul
 */
operator fun Quaternionf.times(a: Float): Quaternionf = mul(a)

/**
 * @see Quaternionf.mul
 */
operator fun Quaternionf.times(m: Quaternionf): Quaternionf = mul(m)

/**
 * @see Quaternionf.sub
 */
operator fun Quaternionf.minus(m: Quaternionf): Quaternionf = sub(m)

/**
 * Multiplies this [Quaternionf] by -1.
 * @see Quaternionf.mul
 */
operator fun Quaternionf.unaryMinus(): Quaternionf = mul(-1.0)

/**
 * @see Quaternionf.add
 */
operator fun Quaternionf.plus(m: Quaternionf): Quaternionf = add(m)


/**
 * @see Vector2d.mul
 */
operator fun Vector2d.times(a: Double): Vector2d = mul(a)

/**
 * @see Vector2d.mul
 */
operator fun Vector2d.times(a: Float): Vector2d = mul(a)

/**
 * @see Vector2d.mul
 */
operator fun Vector2d.times(m: Vector2d): Vector2d = mul(m)

/**
 * @see Vector2d.sub
 */
operator fun Vector2d.minus(m: Vector2d): Vector2d = sub(m)

/**
 * Multiplies this [Vector2d] by -1.
 * @see Vector2d.mul
 */
operator fun Vector2d.unaryMinus(): Vector2d = negate()

/**
 * @see Vector2d.add
 */
operator fun Vector2d.plus(v: Vector2d): Vector2d = add(v)


/**
 * @see Vector2f.mul
 */
operator fun Vector2f.times(a: Double): Vector2f = mul(a)

/**
 * @see Vector2f.mul
 */
operator fun Vector2f.times(a: Float): Vector2f = mul(a)

/**
 * @see Vector2f.mul
 */
operator fun Vector2f.times(m: Vector2f): Vector2f = mul(m)

/**
 * @see Vector2f.sub
 */
operator fun Vector2f.minus(m: Vector2f): Vector2f = sub(m)

/**
 * Multiplies this [Vector2f] by -1.
 * @see Vector2f.mul
 */
operator fun Vector2f.unaryMinus(): Vector2f = negate()

/**
 * @see Vector2f.add
 */
operator fun Vector2f.plus(v: Vector2f): Vector2f = add(v)


/**
 * @see Vector2i.mul
 */
operator fun Vector2i.times(a: Double): Vector2i = mul(a)

/**
 * @see Vector2i.mul
 */
operator fun Vector2i.times(a: Int): Vector2i = mul(a)

/**
 * @see Vector2i.mul
 */
operator fun Vector2i.times(m: Vector2i): Vector2i = mul(m)

/**
 * @see Vector2i.sub
 */
operator fun Vector2i.minus(m: Vector2i): Vector2i = sub(m)

/**
 * Multiplies this [Vector2i] by -1.
 * @see Vector2i.mul
 */
operator fun Vector2i.unaryMinus(): Vector2i = negate()

/**
 * @see Vector2i.add
 */
operator fun Vector2i.plus(v: Vector2i): Vector2i = add(v)


/**
 * @see Vector2l.mul
 */
operator fun Vector2l.times(a: Double): Vector2l = mul(a)

/**
 * @see Vector2l.mul
 */
operator fun Vector2l.times(a: Long): Vector2l = mul(a)

/**
 * @see Vector2l.mul
 */
operator fun Vector2l.times(m: Vector2l): Vector2l = mul(m)

/**
 * @see Vector2l.sub
 */
operator fun Vector2l.minus(m: Vector2l): Vector2l = sub(m)

/**
 * Multiplies this [Vector2l] by -1.
 * @see Vector2l.mul
 */
operator fun Vector2l.unaryMinus(): Vector2l = negate()

/**
 * @see Vector2l.add
 */
operator fun Vector2l.plus(v: Vector2l): Vector2l = add(v)


/**
 * @see Vector3d.mul
 */
operator fun Vector3d.times(a: Double): Vector3d = mul(a)

/**
 * @see Vector3d.mul
 */
operator fun Vector3d.times(a: Float): Vector3d = mul(a)

/**
 * @see Vector3d.mul
 */
operator fun Vector3d.times(m: Vector3d): Vector3d = mul(m)

/**
 * @see Vector3d.sub
 */
operator fun Vector3d.minus(m: Vector3d): Vector3d = sub(m)

/**
 * Multiplies this [Vector3d] by -1.
 * @see Vector3d.mul
 */
operator fun Vector3d.unaryMinus(): Vector3d = negate()

/**
 * @see Vector3d.add
 */
operator fun Vector3d.plus(v: Vector3d): Vector3d = add(v)


/**
 * @see Vector3f.mul
 */
operator fun Vector3f.times(a: Double): Vector3f = mul(a)

/**
 * @see Vector3f.mul
 */
operator fun Vector3f.times(a: Float): Vector3f = mul(a)

/**
 * @see Vector3f.mul
 */
operator fun Vector3f.times(m: Vector3f): Vector3f = mul(m)

/**
 * @see Vector3f.sub
 */
operator fun Vector3f.minus(m: Vector3f): Vector3f = sub(m)

/**
 * Multiplies this [Vector3f] by -1.
 * @see Vector3f.mul
 */
operator fun Vector3f.unaryMinus(): Vector3f = negate()

/**
 * @see Vector3f.add
 */
operator fun Vector3f.plus(v: Vector3f): Vector3f = add(v)


/**
 * @see Vector3i.mul
 */
operator fun Vector3i.times(a: Double): Vector3i = mul(a)

/**
 * @see Vector3i.mul
 */
operator fun Vector3i.times(a: Int): Vector3i = mul(a)

/**
 * @see Vector3i.mul
 */
operator fun Vector3i.times(m: Vector3i): Vector3i = mul(m)

/**
 * @see Vector3i.sub
 */
operator fun Vector3i.minus(m: Vector3i): Vector3i = sub(m)

/**
 * Multiplies this [Vector3i] by -1.
 * @see Vector3i.mul
 */
operator fun Vector3i.unaryMinus(): Vector3i = negate()

/**
 * @see Vector3i.add
 */
operator fun Vector3i.plus(v: Vector3i): Vector3i = add(v)


/**
 * @see Vector3l.mul
 */
operator fun Vector3l.times(a: Double): Vector3l = mul(a)

/**
 * @see Vector3l.mul
 */
operator fun Vector3l.times(a: Long): Vector3l = mul(a)

/**
 * @see Vector3l.mul
 */
operator fun Vector3l.times(m: Vector3l): Vector3l = mul(m)

/**
 * @see Vector3l.sub
 */
operator fun Vector3l.minus(m: Vector3l): Vector3l = sub(m)

/**
 * Multiplies this [Vector3l] by -1.
 * @see Vector3l.mul
 */
operator fun Vector3l.unaryMinus(): Vector3l = negate()

/**
 * @see Vector3l.add
 */
operator fun Vector3l.plus(v: Vector3l): Vector3l = add(v)


/**
 * @see Vector4d.mul
 */
operator fun Vector4d.times(a: Double): Vector4d = mul(a)

/**
 * @see Vector4d.mul
 */
operator fun Vector4d.times(a: Float): Vector4d = mul(a)

/**
 * @see Vector4d.mul
 */
operator fun Vector4d.times(m: Vector4d): Vector4d = mul(m)

/**
 * @see Vector4d.sub
 */
operator fun Vector4d.minus(m: Vector4d): Vector4d = sub(m)

/**
 * Multiplies this [Vector4d] by -1.
 * @see Vector4d.mul
 */
operator fun Vector4d.unaryMinus(): Vector4d = negate()

/**
 * @see Vector4d.add
 */
operator fun Vector4d.plus(v: Vector4d): Vector4d = add(v)


/**
 * @see Vector4f.mul
 */
operator fun Vector4f.times(a: Double): Vector4f = mul(a)

/**
 * @see Vector4f.mul
 */
operator fun Vector4f.times(a: Float): Vector4f = mul(a)

/**
 * @see Vector4f.mul
 */
operator fun Vector4f.times(m: Vector4f): Vector4f = mul(m)

/**
 * @see Vector4f.sub
 */
operator fun Vector4f.minus(m: Vector4f): Vector4f = sub(m)

/**
 * Multiplies this [Vector4f] by -1.
 * @see Vector4f.mul
 */
operator fun Vector4f.unaryMinus(): Vector4f = negate()

/**
 * @see Vector4f.add
 */
operator fun Vector4f.plus(v: Vector4f): Vector4f = add(v)


/**
 * @see Vector4i.mul
 */
operator fun Vector4i.times(a: Double): Vector4i = mul(a)

/**
 * @see Vector4i.mul
 */
operator fun Vector4i.times(a: Int): Vector4i = mul(a)

/**
 * @see Vector4i.mul
 */
operator fun Vector4i.times(m: Vector4i): Vector4i = mul(m)

/**
 * @see Vector4i.sub
 */
operator fun Vector4i.minus(m: Vector4i): Vector4i = sub(m)

/**
 * Multiplies this [Vector4i] by -1.
 * @see Vector4i.mul
 */
operator fun Vector4i.unaryMinus(): Vector4i = mul(-1)

/**
 * @see Vector4i.add
 */
operator fun Vector4i.plus(v: Vector4i): Vector4i = add(v)


/**
 * @see Vector4l.mul
 */
operator fun Vector4l.times(a: Double): Vector4l = mul(a)

/**
 * @see Vector4l.mul
 */
operator fun Vector4l.times(a: Long): Vector4l = mul(a)

/**
 * @see Vector4l.mul
 */
operator fun Vector4l.times(m: Vector4l): Vector4l = mul(m)

/**
 * @see Vector4l.sub
 */
operator fun Vector4l.minus(m: Vector4l): Vector4l = sub(m)

/**
 * Multiplies this [Vector4l] by -1.
 * @see Vector4l.mul
 */
operator fun Vector4l.unaryMinus(): Vector4l = mul(-1L)

/**
 * @see Vector4l.add
 */
operator fun Vector4l.plus(v: Vector4l): Vector4l = add(v)


/**
 * @see VectorNd.mul
 */
operator fun VectorNd.times(a: Double): VectorNd = mul(a)

/**
 * @see VectorNd.mul
 */
operator fun VectorNd.times(a: Float): VectorNd = mul(a)

/**
 * @see VectorNd.mul
 */
operator fun VectorNd.times(m: VectorNd): VectorNd = mul(m)

/**
 * @see VectorNd.sub
 */
operator fun VectorNd.minus(m: VectorNd): VectorNd = sub(m)

/**
 * Multiplies this [VectorNd] by -1.
 * @see VectorNd.mul
 */
operator fun VectorNd.unaryMinus(): VectorNd = mul(-1.0)

/**
 * @see VectorNd.add
 */
operator fun VectorNd.plus(v: VectorNd): VectorNd = add(v)


/**
 * @see VectorNf.mul
 */
operator fun VectorNf.times(a: Double): VectorNf = mul(a)

/**
 * @see VectorNf.mul
 */
operator fun VectorNf.times(a: Float): VectorNf = mul(a)

/**
 * @see VectorNf.mul
 */
operator fun VectorNf.times(m: VectorNf): VectorNf = mul(m)

/**
 * @see VectorNf.sub
 */
operator fun VectorNf.minus(m: VectorNf): VectorNf = sub(m)

/**
 * Multiplies this [VectorNf] by -1.
 * @see VectorNf.mul
 */
operator fun VectorNf.unaryMinus(): VectorNf = mul(-1.0)

/**
 * @see VectorNf.add
 */
operator fun VectorNf.plus(v: VectorNf): VectorNf = add(v)


/**
 * @see VectorNi.mul
 */
operator fun VectorNi.times(a: Double): VectorNi = mul(a)

/**
 * @see VectorNi.mul
 */
operator fun VectorNi.times(a: Int): VectorNi = mul(a)

/**
 * @see VectorNi.mul
 */
operator fun VectorNi.times(m: VectorNi): VectorNi = mul(m)

/**
 * @see VectorNi.sub
 */
operator fun VectorNi.minus(m: VectorNi): VectorNi = sub(m)

/**
 * Multiplies this [VectorNi] by -1.
 * @see VectorNi.mul
 */
operator fun VectorNi.unaryMinus(): VectorNi = mul(-1)

/**
 * @see VectorNi.add
 */
operator fun VectorNi.plus(v: VectorNi): VectorNi = add(v)


/**
 * @see VectorNl.mul
 */
operator fun VectorNl.times(a: Double): VectorNl = mul(a)

/**
 * @see VectorNl.mul
 */
operator fun VectorNl.times(a: Long): VectorNl = mul(a)

/**
 * @see VectorNl.mul
 */
operator fun VectorNl.times(m: VectorNl): VectorNl = mul(m)

/**
 * @see VectorNl.sub
 */
operator fun VectorNl.minus(m: VectorNl): VectorNl = sub(m)

/**
 * Multiplies this [VectorNl] by -1.
 * @see VectorNl.mul
 */
operator fun VectorNl.unaryMinus(): VectorNl = mul(-1L)

/**
 * @see VectorNl.add
 */
operator fun VectorNl.plus(v: VectorNl): VectorNl = add(v)

/**
 * @see Vectord.mul
 */
operator fun Vectord.times(a: Double): Vectord = mul(a)
/**
 * Multiplies this [Vectord] by -1.
 * @see Vectord.mul
 */
operator fun Vectord.unaryMinus(): Vectord = negate()

/**
 * @see Vectorf.mul
 */
operator fun Vectorf.times(a: Float): Vectorf = mul(a)
/**
 * Multiplies this [Vectorf] by -1.
 * @see Vectorf.mul
 */
operator fun Vectorf.unaryMinus(): Vectorf = negate()

/**
 * @see Vectori.mul
 */
operator fun Vectori.times(a: Int): Vectori = mul(a)
/**
 * Multiplies this [Vectori] by -1.
 * @see Vectori.mul
 */
operator fun Vectori.unaryMinus(): Vectori = negate()

/**
 * @see Vectorl.mul
 */
operator fun Vectorl.times(a: Long): Vectorl = mul(a)
/**
 * Multiplies this [Vectorl] by -1.
 * @see Vectorl.mul
 */
operator fun Vectorl.unaryMinus(): Vectorl = negate()

/**
 * Converts a Euler angle vector to a direction vector.
 */
fun Vector3d.eulerToDirection(): Vector3d {
    val cosx = cos(Math.toRadians(x))
    return Vector3d(sin(Math.toRadians(y)) * cosx, cos(Math.toRadians(y)) * cosx, sin(Math.toRadians(x)))
}

/**
 * Converts a direction vector to a Euler angle vector.
 */
fun Vector3d.directionToEuler(): Vector3d {
    return Vector3d(Math.toDegrees(asin(z)), Math.toDegrees(atan2(y, x)), 0.0)
}

/**
 * Converts a direction vector and up vector to a Euler angle vector.
 */
fun Vector3d.directionToEuler(up: Vector3d): Vector3d {
    val w = Vector3d(-y, x, 0.0)
    val u = w.cross(this)
    return Vector3d(Math.toDegrees(asin(z)), Math.toDegrees(atan2(y, x)), Math.toDegrees(atan2(w.dot(up) / w.length(), u.dot(up) / u.length())))
}

/**
 * Gets the direction vector of this transform.
 */
val Transform<*>.direction: Vector3d get() {
    val y = -sin(Math.toRadians(pitch))
    val xz = cos(Math.toRadians(pitch))
    val x = -xz * sin(Math.toRadians(yaw))
    val z = xz * cos(Math.toRadians(yaw))
    return Vector3d(x, y, z)
}

/**
 * Creates a copy of this transform and sets the direction as a direction
 * vector.
 */
fun <T: Extent> Transform<T>.setDirection(direction: Vector3d): Transform<T> {
    val pi2 = Math.PI * 2
    val x = direction.x
    val z = direction.z
    if (x == 0.0 && z == 0.0) {
        return setRotation(Vector3d(if (direction.y > 0) -90.0 else 90.0, rotation.y, rotation.z))
    }
    val theta = atan2(-x, z)
    val yaw = Math.toDegrees((theta + pi2) % pi2)

    val xz = sqrt((x * x) + (z * z))
    val pitch = Math.toDegrees(atan(-direction.y / xz))
    return setRotation(Vector3d(pitch, yaw, rotation.z))
}

operator fun Vector2d.component1(): Double = x
operator fun Vector2d.component2(): Double = y
operator fun Vector2f.component1(): Float = x
operator fun Vector2f.component2(): Float = y
operator fun Vector2l.component1(): Long = x
operator fun Vector2l.component2(): Long = y
operator fun Vector2i.component1(): Int = x
operator fun Vector2i.component2(): Int = y

operator fun Vector3d.component1(): Double = x
operator fun Vector3d.component2(): Double = y
operator fun Vector3d.component3(): Double = z
operator fun Vector3f.component1(): Float = x
operator fun Vector3f.component2(): Float = y
operator fun Vector3f.component3(): Float = z
operator fun Vector3l.component1(): Long = x
operator fun Vector3l.component2(): Long = y
operator fun Vector3l.component3(): Long = z
operator fun Vector3i.component1(): Int = x
operator fun Vector3i.component2(): Int = y
operator fun Vector3i.component3(): Int = z

operator fun Vector4d.component1(): Double = x
operator fun Vector4d.component2(): Double = y
operator fun Vector4d.component3(): Double = z
operator fun Vector4d.component4(): Double = w
operator fun Vector4f.component1(): Float = x
operator fun Vector4f.component2(): Float = y
operator fun Vector4f.component3(): Float = z
operator fun Vector4f.component4(): Float = w
operator fun Vector4l.component1(): Long = x
operator fun Vector4l.component2(): Long = y
operator fun Vector4l.component3(): Long = z
operator fun Vector4l.component4(): Long = w
operator fun Vector4i.component1(): Int = x
operator fun Vector4i.component2(): Int = y
operator fun Vector4i.component3(): Int = z
operator fun Vector4i.component4(): Int = w

operator fun Complexd.component1(): Double = x
operator fun Complexd.component2(): Double = y
operator fun Complexf.component1(): Float = x
operator fun Complexf.component2(): Float = y

operator fun Quaterniond.component1(): Double = x
operator fun Quaterniond.component2(): Double = y
operator fun Quaterniond.component3(): Double = z
operator fun Quaterniond.component4(): Double = w
operator fun Quaternionf.component1(): Float = x
operator fun Quaternionf.component2(): Float = y
operator fun Quaternionf.component3(): Float = z
operator fun Quaternionf.component4(): Float = w

operator fun Matrix2d.component1(): Vector2d = getRow(0)
operator fun Matrix2d.component2(): Vector2d = getRow(1)
operator fun Matrix2f.component1(): Vector2f = getRow(0)
operator fun Matrix2f.component2(): Vector2f = getRow(1)

operator fun Matrix3d.component1(): Vector3d = getRow(0)
operator fun Matrix3d.component2(): Vector3d = getRow(1)
operator fun Matrix3d.component3(): Vector3d = getRow(2)
operator fun Matrix3f.component1(): Vector3f = getRow(0)
operator fun Matrix3f.component2(): Vector3f = getRow(1)
operator fun Matrix3f.component3(): Vector3f = getRow(2)

operator fun Matrix4d.component1(): Vector4d = getRow(0)
operator fun Matrix4d.component2(): Vector4d = getRow(1)
operator fun Matrix4d.component3(): Vector4d = getRow(2)
operator fun Matrix4d.component4(): Vector4d = getRow(3)
operator fun Matrix4f.component1(): Vector4f = getRow(0)
operator fun Matrix4f.component2(): Vector4f = getRow(1)
operator fun Matrix4f.component3(): Vector4f = getRow(2)
operator fun Matrix4f.component4(): Vector4f = getRow(3)
