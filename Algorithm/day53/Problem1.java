package Algorithm.day53;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem1 {
    Set<Integer> dices = new HashSet<>();
    int c = -1;
    int[] answer;
    public int[] solution(int[][] dice) {

        for(int i=0; i<dice.length; i++){
            dices.add(i);
        }
        solve(dice, 0, new HashSet<>());

        return answer;
    }
    public void solve(int[][] dice, int cur, Set<Integer> aDices){

        if(aDices.size() == dice.length / 2){
            Set<Integer> bDices = new HashSet<>(dices);
            bDices.removeAll(aDices);
            //a가 이기는 경우의 수 반환
            int count = rollDice(aDices, bDices, dice);
            if(count > c){
                c = count;
                answer = aDices.stream().mapToInt(i -> i + 1).toArray();
            }
            return;
        }

        for(int i = cur;  i < dice.length; i++){
            aDices.add(i);
            solve(dice, cur + 1, aDices);
            aDices.remove(i);
        }
    }

    public int rollDice(Set<Integer> aDices, Set<Integer> bDices, int[][] dice){

        //A가 가진 주사위로 나올 수 있는 합 list
        List<Integer> sumA = new ArrayList<>();
        roll(aDices, sumA, dice);
        //B가 가진 주사위로 나올 수 있는 합 list
        List<Integer> sumB = new ArrayList<>();
        roll(bDices, sumB, dice);

        Collections.sort(sumA);
        Collections.sort(sumB);
        int count = 0;
        for(int i=0; i<sumA.size(); i++){
            int index = Collections.binarySearch(sumB, sumA.get(i));
            if(index >= 0) count += index;
            else count += ~index;
        }
        return count;
    }
    public void roll(Set<Integer> aDices, List<Integer> sumA, int[][] dice){
        //000 ~ 666
        List<Integer> collect = aDices.stream().collect(Collectors.toList());
        int len = aDices.size();
        for (int i = 0; i < Math.pow(6, len); i++) { // i = 12 -> 20
            int sum = 0;
            String hex = Integer.toString(i, 6);
            hex = "0".repeat(len - hex.length()) + hex;
            for(int j=0; j<len; j++){
                sum += dice[collect.get(j)][hex.charAt(j) - '0'];
            }
            sumA.add(sum);
        }
    }
}
