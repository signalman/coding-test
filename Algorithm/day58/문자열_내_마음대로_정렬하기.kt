package Algorithm.day58

import java.util.Arrays

class 문자열_내_마음대로_정렬하기 {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        return strings.sortedWith(compareBy({it[n]}, {it})).toTypedArray()
    }
}
