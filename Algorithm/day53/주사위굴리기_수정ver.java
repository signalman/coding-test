package Algorithm.day53;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 주사위굴리기_수정ver {

    int tc = -1;
    int[] answer;
    int[][] dice;

    public int[] solution(int[][] dice) {
        boolean[] isSelected = new boolean[dice.length];
        this.dice = dice;
        combination(0, 0, isSelected);
        return answer;
    }
    public void combination(int cur, int count, boolean[] isSelected){
        if(cur == isSelected.length){
            if(count == isSelected.length / 2){
                //처리로직
                List<Integer> sumsA = getAllSums(dice, isSelected, true);
                List<Integer> sumsB = getAllSums(dice, isSelected, false);

                Collections.sort(sumsB);
                for(int i=0; i<sumsA.size(); i++){
                    
                    //이분탐색
                    int st = 0;
                    int en = sumsB.size() - 1;
                    while(st < en){
                        int mid = (st + en) / 2;

                        if(sumsB.get(mid) < sumsA.get(i)){
                            st = mid;
                        }
                        else en = mid - 1;
                    }

                    if(tc < st + 1){
                        tc = st + 1;
                        int[] arr = new int[10];
                        int count1 = 0;
                        for (int index = 0; index < isSelected.length; index++) {
                            if (isSelected[index]) {
                                int i1 = index + 1;
                                if (arr.length == count1)
                                    arr = Arrays.copyOf(arr, count1 * 2);
                                arr[count1++] = i1;
                            }
                        }
                        arr = Arrays.copyOfRange(arr, 0, count1);
                        answer = arr;
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

    List<Integer> getAllSums(int[][] dice, boolean[] isSelected, boolean type){

        List<Integer> ret = new ArrayList<>();
        int N = isSelected.length / 2;
        List<List<Integer>> allCases = new ArrayList<>(); //ex: [[00011], [00012], ... [66666]]
        List<Integer> tmpArray = new ArrayList<>();
        bruteForce(0, N, tmpArray, allCases);
        int sum = 0;

        for (List<Integer> allCase : allCases) {
            int index = 0;
            for(int i=0; i<isSelected.length; i++){
                if(isSelected[i] == type){
                    sum += dice[i][allCase.get(index++)];
                }
            }
            ret.add(sum);
        }
        return ret;
    }
    void bruteForce(int cur, int N, List<Integer> tmpArray, List<List<Integer>> allCases){
        if(cur == N){
            allCases.add(tmpArray);
            return;
        }
        for(int i=0; i<6; i++){
            tmpArray.add(i);
            bruteForce(cur + 1, N, tmpArray, allCases);
            tmpArray.remove(tmpArray.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> an = new ArrayList<>();
        s(an);
        System.out.println(an.size());
    }
    public static void s(List<List<Integer>> l){
        l.add(List.of(1, 2));
        l.add(List.of(2, 3));
    }
}
