package Algorithm.day59

import java.lang.Integer.min
//keymap : ["ABACD", "BCEFD"]
//target : ["ABCD", "DG", "AABB"]
//ans : [9, -1, 4]
class 대충만든자판 {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        var answer: MutableList<Int> = mutableListOf()
        var map: MutableMap<Char, Int> = mutableMapOf()

        for (key in keymap) {
            key.forEachIndexed{
                index, c -> if(map.containsKey(c)){
                    map[c] = min(index + 1, map[c]!!)
            } else{
                map.put(c, index + 1)
            }
            }
        }

        targets.forEach {
            var tmp = 0
            var flag = false
            it.forEach { c ->
                if (!map.containsKey(c)) {
                    answer.add(-1)
                    flag = true
                    return@forEach
                }
                tmp += map[c]!!
            }
            if(!flag) answer.add(tmp)
        }
        return answer.toIntArray()
    }
}