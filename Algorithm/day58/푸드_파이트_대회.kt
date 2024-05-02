package Algorithm.day58

class 푸드_파이트_대회 {
    fun solution(food: IntArray): String {
        var answer = ""
        var sb: StringBuilder = StringBuilder()
        food.forEachIndexed{ index, i -> if (index != 0) for (i in 1..i / 2) sb.append(index) }
        return answer.plus(sb).plus(0).plus(sb.reverse())
    }
}