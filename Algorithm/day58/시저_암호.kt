package Algorithm.day58

class 시저_암호 {
    fun solution(s: String, n: Int): String = s.map { c ->
        when (c) {
            ' ' -> c
            else -> {
                val base = if(c.isUpperCase()) 'A' else 'a'
                ((c - base + n) % 26 + base.code).toChar()
            }
        }
    }.joinToString("")
}