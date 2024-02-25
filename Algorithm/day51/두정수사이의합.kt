package Algorithm.day51

import kotlin.math.max
import kotlin.math.min

class 두정수사이의합 {
    fun solution(a: Int, b: Int): Long{
        var answer: Long = 0
        for(i in (min(a, b).. max(a, b))) answer += i.toLong()
        return answer
    }
}