package Algorithm.day58

import java.util.PriorityQueue
import kotlin.math.min

class 명예의전당 {
    fun solution(k: Int, score: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        var minHeap = PriorityQueue<Int>()

        score.forEach {
            minHeap.add(it)
            if(minHeap.size > k) {
                minHeap.poll()
            }
            answer.add(minHeap.peek())
        }
        return answer.toIntArray()
    }
}