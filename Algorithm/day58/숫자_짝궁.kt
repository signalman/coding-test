package Algorithm.day58

import java.lang.Integer.min

class 숫자_짝궁 {
    fun solution(X: String, Y: String): String {
        var answer: String = ""

        var map1 = mutableMapOf<Char, Int>()
        var map2 = mutableMapOf<Char, Int>()

        X.toCharArray().forEachIndexed{
            index, c -> if(map1[c] == null) map1.put(c, 1)
                        else map1[c] = map1[c]!! + 1
        }
        Y.toCharArray().forEachIndexed{
            index, c -> if(map2[c] == null) map2.put(c, 1)
                        else map2[c] = map2[c]!! + 1
        }

        var array : Array<Int> = Array(10){ 0}

        map1.forEach { t, u -> if(map2.containsKey(t)) {array[t.code] = min(map1[t]!!, map2[t]!!)} }

        print(array)


        return answer
    }
}