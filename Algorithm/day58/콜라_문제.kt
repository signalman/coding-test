package Algorithm.day58

class 콜라_문제 {
    fun solution(a: Int, b: Int, n: Int): Int {
        var answer: Int = 0
        var tmp = n
        while(tmp < a){
            var added = tmp / a * b
            answer += added
            tmp = added + tmp % a
        }

        return answer
    }
}