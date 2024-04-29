package Algorithm.day57

var answer: Int = 0
fun solution(number: IntArray): Int {
    combination(number, 0, mutableListOf())

    return answer
}
fun combination(number: IntArray, idx: Int, tmp: MutableList<Int>){

    if(idx >= number.size && tmp.size == 3) {
        if(tmp.sum() == 0) answer++
        return
    }
    tmp.add(number[idx])
    combination(number, idx + 1, tmp)
    tmp.removeLast()
    combination(number, idx + 1, tmp)
}