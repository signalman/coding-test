package Algorithm.day59

class 문자열나누기 {
    fun solution(s: String): Int {
        var count = 0
        var index = 0

        while (index < s.length) {
            count++
            val firstChar = s[index]
            var sameCount = 1
            var diffCount = 0

            for (i in (index + 1) until s.length) {
                if (s[i] == firstChar) sameCount++ else diffCount++
                index = i
                if (sameCount == diffCount) break
            }
            index++
        }
        return count
    }
}