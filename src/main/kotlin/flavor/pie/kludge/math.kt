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

operator fun Complexd.minus(c: Complexd): Complexd = sub(c)
operator fun Complexd.times(c: Complexd): Complexd = mul(c)
operator fun Complexd.times(a: Double): Complexd = mul(a)
operator fun Complexd.times(a: Float): Complexd = mul(a)
operator fun Complexd.unaryMinus(): Complexd = mul(-1.0)
operator fun Complexd.plus(c: Complexd): Complexd = add(c)

operator fun Complexf.minus(c: Complexf): Complexf = sub(c)
operator fun Complexf.times(c: Complexf): Complexf = mul(c)
operator fun Complexf.times(a: Double): Complexf = mul(a)
operator fun Complexf.times(a: Float): Complexf = mul(a)
operator fun Complexf.unaryMinus(): Complexf = Complexf(-x, -y)
operator fun Complexf.plus(c: Complexf): Complexf = add(c)

operator fun Imaginaryd.times(a: Double): Imaginaryd = mul(a)
operator fun Imaginaryd.unaryMinus(): Imaginaryd = mul(-1.0)

operator fun Imaginaryf.times(a: Float): Imaginaryf = mul(a)
operator fun Imaginaryf.unaryMinus(): Imaginaryf = mul(-1.0f)

operator fun Matrix2d.minus(m: Matrix2d): Matrix2d = sub(m)
operator fun Matrix2d.times(m: Matrix2d): Matrix2d = mul(m)
operator fun Matrix2d.times(a: Float): Matrix2d = mul(a)
operator fun Matrix2d.times(a: Double): Matrix2d = mul(a)
operator fun Matrix2d.unaryMinus(): Matrix2d = mul(-1.0)
operator fun Matrix2d.plus(m: Matrix2d): Matrix2d = add(m)

operator fun Matrix2f.minus(m: Matrix2f): Matrix2f = sub(m)
operator fun Matrix2f.times(m: Matrix2f): Matrix2f = mul(m)
operator fun Matrix2f.times(a: Float): Matrix2f = mul(a)
operator fun Matrix2f.times(a: Double): Matrix2f = mul(a)
operator fun Matrix2f.unaryMinus(): Matrix2f = mul(-1.0)
operator fun Matrix2f.plus(m: Matrix2f): Matrix2f = add(m)

operator fun Matrix3d.minus(m: Matrix3d): Matrix3d = sub(m)
operator fun Matrix3d.times(m: Matrix3d): Matrix3d = mul(m)
operator fun Matrix3d.times(a: Float): Matrix3d = mul(a)
operator fun Matrix3d.times(a: Double): Matrix3d = mul(a)
operator fun Matrix3d.unaryMinus(): Matrix3d = mul(-1.0)
operator fun Matrix3d.plus(m: Matrix3d): Matrix3d = add(m)


operator fun Matrix3f.minus(m: Matrix3f): Matrix3f = sub(m)
operator fun Matrix3f.times(m: Matrix3f): Matrix3f = mul(m)
operator fun Matrix3f.times(a: Float): Matrix3f = mul(a)
operator fun Matrix3f.times(a: Double): Matrix3f = mul(a)
operator fun Matrix3f.unaryMinus(): Matrix3f = mul(-1.0)
operator fun Matrix3f.plus(m: Matrix3f): Matrix3f = add(m)

operator fun Matrix4d.minus(m: Matrix4d): Matrix4d = sub(m)
operator fun Matrix4d.times(m: Matrix4d): Matrix4d = mul(m)
operator fun Matrix4d.times(a: Float): Matrix4d = mul(a)
operator fun Matrix4d.times(a: Double): Matrix4d = mul(a)
operator fun Matrix4d.unaryMinus(): Matrix4d = mul(-1.0)
operator fun Matrix4d.plus(m: Matrix4d): Matrix4d = add(m)

operator fun Matrix4f.minus(m: Matrix4f): Matrix4f = sub(m)
operator fun Matrix4f.times(m: Matrix4f): Matrix4f = mul(m)
operator fun Matrix4f.times(a: Float): Matrix4f = mul(a)
operator fun Matrix4f.times(a: Double): Matrix4f = mul(a)
operator fun Matrix4f.unaryMinus(): Matrix4f = mul(-1.0)
operator fun Matrix4f.plus(m: Matrix4f): Matrix4f = add(m)

operator fun Matrixd.times(a: Double): Matrixd = mul(a)
operator fun Matrixd.unaryMinus(): Matrixd = mul(-1.0)

operator fun Matrixf.times(a: Float): Matrixf = mul(a)
operator fun Matrixf.unaryMinus(): Matrixf = mul(-1.0f)

operator fun MatrixNd.times(a: Double): MatrixNd = mul(a)
operator fun MatrixNd.times(a: Float): MatrixNd = mul(a)
operator fun MatrixNd.times(m: MatrixNd): MatrixNd = mul(m)
operator fun MatrixNd.minus(m: MatrixNd): MatrixNd = sub(m)
operator fun MatrixNd.unaryMinus(): MatrixNd = mul(-1.0)
operator fun MatrixNd.plus(m: MatrixNd): MatrixNd = add(m)

operator fun MatrixNf.times(a: Double): MatrixNf = mul(a)
operator fun MatrixNf.times(a: Float): MatrixNf = mul(a)
operator fun MatrixNf.times(m: MatrixNf): MatrixNf = mul(m)
operator fun MatrixNf.minus(m: MatrixNf): MatrixNf = sub(m)
operator fun MatrixNf.unaryMinus(): MatrixNf = mul(-1.0)
operator fun MatrixNf.plus(m: MatrixNf): MatrixNf = add(m)

operator fun Quaterniond.times(a: Double): Quaterniond = mul(a)
operator fun Quaterniond.times(a: Float): Quaterniond = mul(a)
operator fun Quaterniond.times(m: Quaterniond): Quaterniond = mul(m)
operator fun Quaterniond.minus(m: Quaterniond): Quaterniond = sub(m)
operator fun Quaterniond.unaryMinus(): Quaterniond = mul(-1.0)
operator fun Quaterniond.plus(m: Quaterniond): Quaterniond = add(m)

operator fun Quaternionf.times(a: Double): Quaternionf = mul(a)
operator fun Quaternionf.times(a: Float): Quaternionf = mul(a)
operator fun Quaternionf.times(m: Quaternionf): Quaternionf = mul(m)
operator fun Quaternionf.minus(m: Quaternionf): Quaternionf = sub(m)
operator fun Quaternionf.unaryMinus(): Quaternionf = mul(-1.0)
operator fun Quaternionf.plus(m: Quaternionf): Quaternionf = add(m)

operator fun Vector2d.times(a: Double): Vector2d = mul(a)
operator fun Vector2d.times(a: Float): Vector2d = mul(a)
operator fun Vector2d.times(m: Vector2d): Vector2d = mul(m)
operator fun Vector2d.minus(m: Vector2d): Vector2d = sub(m)
operator fun Vector2d.unaryMinus(): Vector2d = negate()
operator fun Vector2d.plus(v: Vector2d): Vector2d = add(v)

operator fun Vector2f.times(a: Double): Vector2f = mul(a)
operator fun Vector2f.times(a: Float): Vector2f = mul(a)
operator fun Vector2f.times(m: Vector2f): Vector2f = mul(m)
operator fun Vector2f.minus(m: Vector2f): Vector2f = sub(m)
operator fun Vector2f.unaryMinus(): Vector2f = negate()
operator fun Vector2f.plus(v: Vector2f): Vector2f = add(v)

operator fun Vector2i.times(a: Double): Vector2i = mul(a)
operator fun Vector2i.times(a: Int): Vector2i = mul(a)
operator fun Vector2i.times(m: Vector2i): Vector2i = mul(m)
operator fun Vector2i.minus(m: Vector2i): Vector2i = sub(m)
operator fun Vector2i.unaryMinus(): Vector2i = negate()
operator fun Vector2i.plus(v: Vector2i): Vector2i = add(v)

operator fun Vector2l.times(a: Double): Vector2l = mul(a)
operator fun Vector2l.times(a: Long): Vector2l = mul(a)
operator fun Vector2l.times(m: Vector2l): Vector2l = mul(m)
operator fun Vector2l.minus(m: Vector2l): Vector2l = sub(m)
operator fun Vector2l.unaryMinus(): Vector2l = negate()
operator fun Vector2l.plus(v: Vector2l): Vector2l = add(v)

operator fun Vector3d.times(a: Double): Vector3d = mul(a)
operator fun Vector3d.times(a: Float): Vector3d = mul(a)
operator fun Vector3d.times(m: Vector3d): Vector3d = mul(m)
operator fun Vector3d.minus(m: Vector3d): Vector3d = sub(m)
operator fun Vector3d.unaryMinus(): Vector3d = negate()
operator fun Vector3d.plus(v: Vector3d): Vector3d = add(v)

operator fun Vector3f.times(a: Double): Vector3f = mul(a)
operator fun Vector3f.times(a: Float): Vector3f = mul(a)
operator fun Vector3f.times(m: Vector3f): Vector3f = mul(m)
operator fun Vector3f.minus(m: Vector3f): Vector3f = sub(m)
operator fun Vector3f.unaryMinus(): Vector3f = negate()
operator fun Vector3f.plus(v: Vector3f): Vector3f = add(v)

operator fun Vector3i.times(a: Double): Vector3i = mul(a)
operator fun Vector3i.times(a: Int): Vector3i = mul(a)
operator fun Vector3i.times(m: Vector3i): Vector3i = mul(m)
operator fun Vector3i.minus(m: Vector3i): Vector3i = sub(m)
operator fun Vector3i.unaryMinus(): Vector3i = negate()
operator fun Vector3i.plus(v: Vector3i): Vector3i = add(v)

operator fun Vector3l.times(a: Double): Vector3l = mul(a)
operator fun Vector3l.times(a: Long): Vector3l = mul(a)
operator fun Vector3l.times(m: Vector3l): Vector3l = mul(m)
operator fun Vector3l.minus(m: Vector3l): Vector3l = sub(m)
operator fun Vector3l.unaryMinus(): Vector3l = negate()
operator fun Vector3l.plus(v: Vector3l): Vector3l = add(v)

operator fun Vector4d.times(a: Double): Vector4d = mul(a)
operator fun Vector4d.times(a: Float): Vector4d = mul(a)
operator fun Vector4d.times(m: Vector4d): Vector4d = mul(m)
operator fun Vector4d.minus(m: Vector4d): Vector4d = sub(m)
operator fun Vector4d.unaryMinus(): Vector4d = negate()
operator fun Vector4d.plus(v: Vector4d): Vector4d = add(v)

operator fun Vector4f.times(a: Double): Vector4f = mul(a)
operator fun Vector4f.times(a: Float): Vector4f = mul(a)
operator fun Vector4f.times(m: Vector4f): Vector4f = mul(m)
operator fun Vector4f.minus(m: Vector4f): Vector4f = sub(m)
operator fun Vector4f.unaryMinus(): Vector4f = negate()
operator fun Vector4f.plus(v: Vector4f): Vector4f = add(v)

operator fun Vector4i.times(a: Double): Vector4i = mul(a)
operator fun Vector4i.times(a: Int): Vector4i = mul(a)
operator fun Vector4i.times(m: Vector4i): Vector4i = mul(m)
operator fun Vector4i.minus(m: Vector4i): Vector4i = sub(m)
operator fun Vector4i.unaryMinus(): Vector4i = mul(-1)

operator fun Vector4l.times(a: Double): Vector4l = mul(a)
operator fun Vector4l.times(a: Long): Vector4l = mul(a)
operator fun Vector4l.times(m: Vector4l): Vector4l = mul(m)
operator fun Vector4l.minus(m: Vector4l): Vector4l = sub(m)
operator fun Vector4l.unaryMinus(): Vector4l = mul(-1L)

operator fun VectorNd.times(a: Double): VectorNd = mul(a)
operator fun VectorNd.times(a: Float): VectorNd = mul(a)
operator fun VectorNd.times(m: VectorNd): VectorNd = mul(m)
operator fun VectorNd.minus(m: VectorNd): VectorNd = sub(m)
operator fun VectorNd.unaryMinus(): VectorNd = mul(-1.0)

operator fun VectorNf.times(a: Double): VectorNf = mul(a)
operator fun VectorNf.times(a: Float): VectorNf = mul(a)
operator fun VectorNf.times(m: VectorNf): VectorNf = mul(m)
operator fun VectorNf.minus(m: VectorNf): VectorNf = sub(m)
operator fun VectorNf.unaryMinus(): VectorNf = mul(-1.0)

operator fun VectorNi.times(a: Double): VectorNi = mul(a)
operator fun VectorNi.times(a: Int): VectorNi = mul(a)
operator fun VectorNi.times(m: VectorNi): VectorNi = mul(m)
operator fun VectorNi.minus(m: VectorNi): VectorNi = sub(m)
operator fun VectorNi.unaryMinus(): VectorNi = mul(-1)

operator fun VectorNl.times(a: Double): VectorNl = mul(a)
operator fun VectorNl.times(a: Long): VectorNl = mul(a)
operator fun VectorNl.times(m: VectorNl): VectorNl = mul(m)
operator fun VectorNl.minus(m: VectorNl): VectorNl = sub(m)
operator fun VectorNl.unaryMinus(): VectorNl = mul(-1L)

operator fun Vectord.times(a: Double): Vectord = mul(a)
operator fun Vectord.unaryMinus(): Vectord = negate()

operator fun Vectorf.times(a: Float): Vectorf = mul(a)
operator fun Vectorf.unaryMinus(): Vectorf = negate()

operator fun Vectori.times(a: Int): Vectori = mul(a)
operator fun Vectori.unaryMinus(): Vectori = negate()

operator fun Vectorl.times(a: Long): Vectorl = mul(a)
operator fun Vectorl.unaryMinus(): Vectorl = negate()

fun Vector3d.eulerToDirection(): Vector3d {
    val cosx = Math.cos(Math.toRadians(x))
    return Vector3d(Math.sin(Math.toRadians(y)) * cosx, Math.cos(Math.toRadians(y)) * cosx, Math.sin(Math.toRadians(x)))
}

fun Vector3d.directionToEuler(): Vector3d {
    return Vector3d(Math.toDegrees(Math.asin(z)), Math.toDegrees(Math.atan2(y, x)), 0.0)
}

fun Vector3d.directionToEuler(up: Vector3d): Vector3d {
    val w = Vector3d(-y, x, 0.0)
    val u = w.cross(this)
    return Vector3d(Math.toDegrees(Math.asin(z)), Math.toDegrees(Math.atan2(y, x)), Math.toDegrees(Math.atan2(w.dot(up) / w.length(), u.dot(up) / u.length())))
}

val Transform<*>.direction: Vector3d get() {
    val y = -Math.sin(Math.toRadians(pitch))
    val xz = Math.cos(Math.toRadians(pitch))
    val x = -xz * Math.sin(Math.toRadians(yaw))
    val z = xz * Math.cos(Math.toRadians(yaw))
    return Vector3d(x, y, z)
}

fun <T: Extent> Transform<T>.setDirection(direction: Vector3d): Transform<T> {
    val pi2 = Math.PI * 2
    val x = direction.x
    val z = direction.z
    if (x == 0.0 && z == 0.0) {
        return setRotation(Vector3d(if (direction.y > 0) -90.0 else 90.0, rotation.y, rotation.z))
    }
    val theta = Math.atan2(-x, z)
    val yaw = Math.toDegrees((theta + pi2) % pi2)

    val xz = Math.sqrt((x * x) + (z * z))
    val pitch = Math.toDegrees(Math.atan(-direction.y / xz))
    return setRotation(Vector3d(pitch, yaw, rotation.z))
}