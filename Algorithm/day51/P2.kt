package Algorithm.day51

import kotlin.math.round
import kotlin.math.sqrt

class P2 {
    fun solution(x: Int, n: Int): LongArray {
        var answer = mutableListOf<Long>()
        for(i in 1..n)
            answer.add(x * i.toLong())
        var name = "he"
        return answer.toLongArray()
    }

}

fun main() {
    var n = 3
    val sqrt = sqrt(n.toDouble())
    println(sqrt)
}
fun solution(n: Long): Long {
    var sqrt = sqrt(n.toDouble())
    if(sqrt != round(sqrt)) return -1
    return ((sqrt + 1) * (sqrt + 1)).toLong()
}