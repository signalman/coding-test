package Algorithm.day57

import org.w3c.dom.css.Rect

fun main(){
    println("hello")
    println(sum(2, 3))
    val x = 5
    val y: Int = 5;
    val r: Rectangle = Rectangle(1.1, 2.3)
    var s1 = ""

    s1 += "hel"
    println(s1)

    var items = listOf("apple", "hello", "banana")
    items.filter{it.startsWith('a')}
        .sortedBy { it }
        .map{it.uppercase()}

    when {
        "apple" in items -> print("사과가있음")
        "hello" in items -> print("인사를 함")
    }


    if(x !in 1..6)
        print("fint")
    for(x in 10 downTo 1 step 2){
        print(x)
    }

}

class Rectangle(val height: Double, val length: Double){
    val param = (height + length) / 2
}

fun maxOf(a: Int, b: Int) = if(a > b) a else b

fun sum(a: Int, b: Int) = a + b
fun sum1(a: Int, b: Int): Int{
    return a + b
}