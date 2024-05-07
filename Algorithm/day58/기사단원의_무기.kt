package Algorithm.day58

class 기사단원의_무기 {
    fun solution(number: Int, limit: Int, power: Int): Int {
        var answer: Int = 0

        for (i in 1..number) {
            var c = divCount(i)
            if(c <= limit) answer += c
            else answer += power
        }
        return answer
    }
    fun divCount(number: Int) : Int{
        var count = 0
        for (i in 1..number) {
            if(number % i == 0) count++
        }
        return count
    }
}