package Algorithm.day59

import java.util.Stack

//1,2,3,1
class 햄버거만들기 {
    fun solution(ingredient: IntArray): Int {
        var answer: Int = 0
        var st: Stack<Pair<Int, Boolean>> = Stack()
        ingredient.forEach {
            if(it == 1){
                if(!st.isEmpty() && st.peek().first == 3 && st.peek().second) {
                    for (i in 1..3) st.pop()
                    answer++
                }
                else st.add(Pair(it, true))
            }
            else{
                if(!st.isEmpty() && st.peek().first == it - 1 && st.peek().second) st.add(Pair(it, true))
                else st.add(Pair(it, false))
            }
        }
        return answer
    }
}