package Algorithm.day57

class 문자열_내림차순으로_배치하기 {
    fun solution(s: String): String {
        return s.toCharArray().sortedArrayDescending().joinToString("")
    }
}