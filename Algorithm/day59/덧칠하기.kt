package Algorithm.day59

class 덧칠하기 {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer = 0

        var tile = section[0]
        for (elem in section) {
            if(tile > elem) continue
            tile = elem
            answer++
            tile += m
        }
        return answer
    }
}