package Algorithm.day51

fun main() {

}
fun solution(n: Int): Int {
    var answer = 0

    for(i in 1..n/2){
        if(n % i == 0) answer += i
    }
    (1..n).filter { n % it == 0 }.sum()

    return answer
}