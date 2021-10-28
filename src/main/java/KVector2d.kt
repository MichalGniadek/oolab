import kotlin.math.max
import kotlin.math.min

data class KVector2d(val x: Int, val y: Int) {
    override fun toString(): String = "($x,$y)";
    fun precedes(other: KVector2d) = x <= other.x && y <= other.y;
    fun follows(other: KVector2d) = other.precedes(this);
    fun upperRight(other: KVector2d): KVector2d = KVector2d(max(x, other.x), max(y, other.y));
    fun lowerLeft(other: KVector2d): KVector2d = KVector2d(min(x, other.x), min(y, other.y));
    operator fun plus(other: KVector2d): KVector2d = KVector2d(x + other.x, y + other.y);
    operator fun minus(other: KVector2d): KVector2d = KVector2d(x - other.x, y - other.y);
    operator fun unaryMinus(): KVector2d = KVector2d(-x, -y);
}
