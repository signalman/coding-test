package Algorithm.day59

import java.lang.Integer.min
//keymap : ["ABACD", "BCEFD"]
//target : ["ABCD", "DG", "AABB"]
//ans : [9, -1, 4]

//key = ["ABACD", "BCEFD"]
//target = ["DG"]
//ans =[ -1]

//keymap = ["ABC"], targets = ["DA"]
//result -> [-1]
class 대충만든자판 {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        val map = keymap.flatMap { it.withIndex() }
            .groupBy { it.value }
            .mapValues { (_, indexes) -> indexes.minOf { it.index + 1 } }

        return targets.map { target ->
            target.sumOf { c -> map[c] ?: return@map -1 }.takeIf { target.all { c -> c in map } } ?: -1
        }.toIntArray()
    }
}