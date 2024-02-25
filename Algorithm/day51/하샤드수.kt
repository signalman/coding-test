package Algorithm.day51

class 하샤드수 {
    fun solution(x: Int): Boolean{
        var sum = 0
        x.toString().toCharArray().forEach { sum += it.digitToInt() }
        return x % sum == 0
    }
}