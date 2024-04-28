package Algorithm.day57


fun solution(n: Int, m: Int): IntArray {
    var answer = mutableListOf<Int>()
    val gcd = gcd(n, m)
    val lcm = n / gcd * m / gcd * gcd
    answer.add(gcd)
    answer.add(lcm)
    return answer.toIntArray()
}
fun gcd(n: Int, m: Int): Int {
    var gcd = 1
    for(i in 2 .. n)
        if(n % i == 0 && m % i == 0) gcd = i
    return gcd
}

fun solution(s: String): String {
    var answer = ""
    val split = s.split(" ")
    for (s1 in split) {
        s1.indices.forEach {
        }
    }
    return answer
}