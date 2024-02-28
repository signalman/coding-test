package Algorithm.day52

class Main {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        var nameToRank = hashMapOf<String, Int>()
        players.forEachIndexed { index, player -> nameToRank[player] = index }
        callings.forEach {
            player -> var idx = nameToRank[player]!!
            var switchedPlayer = players[idx - 1]

            //원래 배열 자리바꾸기
            players[idx] = switchedPlayer
            players[idx - 1] = player

            //Map update
            nameToRank[player] = nameToRank[player]!! - 1
            nameToRank[switchedPlayer] = nameToRank[switchedPlayer]!! + 1
        }
        return players
    }

}