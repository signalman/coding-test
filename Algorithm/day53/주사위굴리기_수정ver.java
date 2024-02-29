package Algorithm.day53;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 주사위굴리기_수정ver {

    int total = -1;
    int[] answer;
    int[][] dice;

    public int[] solution(int[][] dice) {
        boolean[] isSelected = new boolean[dice.length];
        this.dice = dice;
        answer = new int[dice.length / 2];
        combination(0, 0, isSelected);
        return answer;
    }
    public void combination(int cur, int count, boolean[] isSelected){
        if(cur == isSelected.length){
            if(count == isSelected.length / 2){
                //처리로직
                List<Integer> sumsA = getAllSums(isSelected, true);
                List<Integer> sumsB = getAllSums(isSelected, false);

                Collections.sort(sumsB);
                int cnt = 0;

                for(int i=0; i<sumsA.size(); i++){

                    //이분탐색
                    int st = 0;
                    int en = sumsB.size() - 1;
                    while(st < en){
                        int mid = (st + en + 1) / 2;

                        if(sumsB.get(mid) < sumsA.get(i)){
                            st = mid;
                        }
                        else en = mid - 1;
                    }
                    cnt += st + 1;
                }
                if(total < cnt){
                    total = cnt;
                    // answer = IntStream.range(0, isSelected.length).filter(index -> isSelected[index]).map(index -> index + 1).toArray();
                    int index = 0;
                    for(int j=0; j<isSelected.length; j++){
                        if(isSelected[j])
                            answer[index++] = j+1;
                    }
                }
            }
            return;
        }

        isSelected[cur] = true;
        combination(cur + 1, count + 1, isSelected);
        isSelected[cur] = false;
        combination(cur + 1, count, isSelected);
    }

    List<Integer> getAllSums(boolean[] isSelected, boolean type) {
        List<Integer> ret = new ArrayList<>();
        int N = isSelected.length / 2;
        List<Integer> combination = new ArrayList<>();
        generateCombinations(0, N, combination, ret, isSelected, type);
        return ret;
    }

    void generateCombinations(int cur, int N, List<Integer> combination, List<Integer> ret, boolean[] isSelected, boolean type) {
        if (cur == N) {
            int sum = 0, index = 0;
            for (int i = 0; i < isSelected.length; i++) {
                if (isSelected[i] == type) {
                    sum += dice[i][combination.get(index++)];
                }
            }
            ret.add(sum);
            return;
        }

        for (int i = 0; i < 6; i++) {
            combination.add(i);
            generateCombinations(cur + 1, N, combination, ret, isSelected, type);
            combination.remove(combination.size() - 1);
        }
    }
}
