package Algorithm.day51

import java.lang.Integer.max
import java.util.Scanner
import javax.security.sasl.AuthorizeCallback
import kotlin.random.Random


val num = 10

fun main() {
    val items = mutableListOf(1, 2, 3, 4, 5)
    print(items)
    val array = arrayOf(1, 2, 3)
    val size = array.size
    items.add(7)
    items.remove(3)
    items.removeAt(3)


    var name: String? = null
    var name2: String = "";
    if (name != null) {
        name2 = name
    }
    name?.let {
        name2 = name
    }
    val John = Person("존", 20)
    print(John.age)
}
fun sum(a: Int, b: Int, c: Int = 0) = a + b + c
class Person(
    val name: String,
    var age: Int
){
    var hobby = "축구"
    init {
        print("Init")
    }
    fun some(){
        hobby = "농구"
    }
}

fun func(callback: () -> Unit){
    print("HI")
    callback()
    print("BYE")
}