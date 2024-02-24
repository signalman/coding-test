package Algorithm.day51

class Solution {
    fun solution(n: Long): Long {
        return n.toString().toCharArray().sortedArrayDescending().concatToString().toLong()
    }
}

fun main() {
    var n = 118372L
    var p: Solution = Solution()
    println(p.solution(n))
}