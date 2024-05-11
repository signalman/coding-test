package Algorithm.day59

class 문자열나누기 {
    fun solution(s: String): Int {
        var answer: Int = 0

        var index = 0
        while (index < s.length) {
            answer++
            var init = s[index]
            var c1 = 1
            var c2 = 0
            while(c1 != c2){
                index++
                if(index >= s.length) break
                if(s[index] != init) c2++
                else c1++
            }
            index++
        }

        return answer
    }
}