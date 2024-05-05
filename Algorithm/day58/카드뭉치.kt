package Algorithm.day58

class 카드뭉치 {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {

        var p1 = 0
        var p2 = 0
        var idx = 0

        while (idx < goal.size) {

            if(p1 < cards1.size && cards1[p1] == goal[idx++]){
                idx++
                p1++
                continue
            }
            if (p2 < cards2.size && cards2[p2] == goal[idx++]) {
                idx++
                p2++
                continue
            }
            return "No"
        }
        return "Yes"
    }
}