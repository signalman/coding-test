package Algorithm.day57

class `직사각형 별찍기` {
    fun main(args: Array<String>) {
        val (a, b) = readLine()!!.split(' ').map(String::toInt)
        for(i in 1..b){
            for(j in 1..a){
                print("*")
            }
            println()
        }
    }
}