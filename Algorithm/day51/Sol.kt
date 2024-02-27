package Algorithm.day51

class Sol {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        var answer = arr.filter { it % divisor == 0 }
        if(answer.isEmpty()) return intArrayOf(-1)
        return answer.sorted().toIntArray()
    }
}