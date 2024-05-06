package Algorithm.day58

import java.util.Arrays

class 과일장수 {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer: Int = 0
        score.sortDescending()
        var n = score.size / m * m
        val score = score.sliceArray(0 until n)
        for (i in m - 1 until score.size step m) {
            answer += score[i] * m
        }
        return answer
    }
}