package Algorithm.day59

class 옹알이 {
    fun solution(babbling: Array<String>): Int {
        var answer = 0
        var words: Array<String> = arrayOf("aya", "ye", "woo", "ma")

        for (babble in babbling) {
            if(babble.contains("ayaaya") || babble.contains("yeye") || babble.contains("woowoo") || babble.contains("mama")) continue
            var str = babble

            for(word in words){
                if(str.contains(word)){
                    str = str.replace(word, " ")
                }
            }
            str = str.replace(" ", "")
            if(str.isEmpty()) answer++
        }
        return answer
    }
}