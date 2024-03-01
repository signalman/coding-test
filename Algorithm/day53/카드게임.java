package Algorithm.day53;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 카드게임 {

    public int solution(int coin, int[] cards) {
        int n = cards.length;
        List<Integer> hands = IntStream.range(0, n / 3)
                                       .mapToObj(i -> cards[i])
                                       .collect(Collectors.toList());
        List<Integer> candidate = new ArrayList<>();
        int index = n / 3;
        int round = 1;

        while(index < n){

            //후보군에 넣기
            candidate.add(cards[index]);
            candidate.add(cards[index + 1]);

            //손패로만 해결
            if(canContinueWithPair(hands, n)){
                round++;
                index += 2;
                continue;
            }

            //한개로 해결
            if(coin >= 1 && canContinueWithSingle(hands, candidate, n)){
                round++;
                index += 2;
                coin -= 1;
                continue;
            }
            //두개 다 필요
            if(coin >= 2 && canContinueWithPair(candidate, n)){
                round++;
                index += 2;
                coin -= 2;
                continue;
            }
            //게임 종료
            break;
        }
        return round;
    }

    private boolean canContinueWithSingle(List<Integer> hands, List<Integer> candidate, int n) {

        for(int i=0; i<hands.size(); i++){
            for(int j=0; j<candidate.size(); j++){
                if(hands.get(i) + candidate.get(j) == n + 1){
                    hands.remove(i);
                    candidate.remove(j);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean canContinueWithPair(List<Integer> cards, int n) {

        for(int i=0; i<cards.size(); i++){
            for(int j=i+1; j<cards.size(); j++){
                if(cards.get(i) + cards.get(j) == n + 1){
                    cards.remove(j);
                    cards.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

}
