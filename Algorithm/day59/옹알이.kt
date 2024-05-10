package Algorithm.day59

class 옹알이 {
    fun solution(babbling: Array<String>): Int {
        val words = listOf("aya", "ye", "woo", "ma")
        val invalidPatterns = listOf("ayaaya", "yeye", "woowoo", "mama")

        return babbling.count { babble ->
            if (invalidPatterns.any { it in babble }) return@count false
            var processed = babble
            words.forEach { word -> processed = processed.replace(word, " ") }
            processed.trim().isEmpty()
        }
    }
}