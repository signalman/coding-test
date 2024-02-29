package Algorithm.day53;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 주사위굴리기1 {

    int c = -1;
    int[] answer;
    public int[] solution(int[][] dice) {
        combination(dice, 0, new ArrayList<>());
        return answer;
    }
    public void combination(int[][] dice, int cur, List<Integer> aDices){

        if(aDices.size() == dice.length / 2){
            List<Integer> bDices = new ArrayList<>();
            for(int i=0; i<dice.length; i++){
                if(!aDices.contains(i)) bDices.add(i);
            }
            //a가 이기는 경우의 수 반환

            List<Integer> sumA = new ArrayList<>();
            int[] getNumbersA = new int[aDices.size()];
            rollDice(0, dice.length / 2, getNumbersA, dice, aDices, sumA);

            //B가 가진 주사위로 나올 수 있는 합 list
            List<Integer> sumB = new ArrayList<>();
            int[] getNumbersB = new int[bDices.size()];
            rollDice(0, dice.length / 2, getNumbersB, dice, bDices, sumB);

            Collections.sort(sumA);
            Collections.sort(sumB);
            int count = 0;
            for(int i=0; i<sumA.size(); i++){
                int st = 0;
                int en = sumB.size() - 1;

                while(st < en){
                    int mid = (st + en + 1) / 2;
                    if(sumB.get(mid) < sumA.get(i)){
                        st = mid;
                    }
                    else en = mid - 1;
                }
                count += st + 1;
            }
            if(count > c){
                c = count;
                answer = aDices.stream()
                               .mapToInt(i -> i + 1)
                               .toArray();
            }

//            int count = rollDice(aDices, bDices, dice);
//            if(count > c){
//                c = count;
//                answer = aDices.stream().mapToInt(i -> i + 1).toArray();
//            }
            return;
        }

        for(int i = cur;  i < dice.length; i++){
            aDices.add(i);
            combination(dice, cur + 1, aDices);
            aDices.remove(aDices.size() - 1);
        }
    }

//    public int rollDice(List<Integer> aDices, List<Integer> bDices, int[][] dice){
//
//        //A가 가진 주사위로 나올 수 있는 합 list
//
//        return count;
//    }

    void rollDice(int cur, int N, int[] getNumbers, int[][] dice, List<Integer> a, List<Integer> sums){

        if(cur == N){
            int sum = 0;

            for(int i=0; i<N; i++){
                sum += dice[a.get(i)][getNumbers[i]];
            }
            sums.add(sum);
            return;
        }

        for(int i=0; i<6; i++){
            getNumbers[cur] = i;
            rollDice(cur + 1, N, getNumbers, dice, a, sums);
        }
    }
}
