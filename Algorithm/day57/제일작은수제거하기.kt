package Algorithm.day57

class 제일작은수제거하기 {
    fun solution(arr: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        var mn = arr.minOrNull()
        for (i in arr) {
            if(i != mn) answer.add(i)
        }
        if(answer.isEmpty()) return intArrayOf(-1)
        return answer.toIntArray()
    }
}