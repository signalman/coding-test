package Algorithm.day54;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main4 {

    /*
     * n/2 가져갔을 때, 굴린다.
     * A가 가져갔을 때 가장 많이 이기는 경우의 수의 주사위
     * */
    static Map<List<Integer>, Integer> map = new HashMap<>();
    public int[] solution(int[][] dice) {

        combination(dice, 0, new ArrayList<>());

        List<Integer> key = map.entrySet()
                               .stream()
                               .max(Entry.comparingByValue())
                               .get()
                               .getKey();

        return key.stream().mapToInt(i -> i + 1).toArray();
    }

    public void combination(int[][] dice, int cur, List<Integer> A){

        //반을 획득
        if(A.size() == dice.length / 2){
            List<Integer> B = IntStream.range(0, dice.length).boxed().collect(Collectors.toList());
            B.removeAll(A);

            //A와 B 나누어 졌으므로 경우의 수 계산
            calc(A, B, dice); //Map에 업데이트
            return;
        }
        if(cur == dice.length) return;
        A.add(cur);
        combination(dice, cur + 1, A);
        A.remove(A.size() - 1);
        combination(dice, cur + 1, A);
    }
    public void calc(List<Integer> A, List<Integer> B, int[][] dice){

        List<Integer> sumOfA = new ArrayList<>(), sumOfB = new ArrayList<>();
        sumOf(A, dice, 0, 0, sumOfA);
        sumOf(B, dice, 0, 0, sumOfB);

        Collections.sort(sumOfA);
        Collections.sort(sumOfB);

        //B 요소 중 A보다 작은 것 중 가장 큰것.

        int count = 0;
        for(int i=0; i<sumOfA.size(); i++){
            int st = 0;
            int en = sumOfB.size() - 1;

            while(st < en){

                int mid = (st + en) / 2;
                //조건 만족 x
                if(sumOfB.get(mid) >= sumOfA.get(i)){
                    en = mid - 1;
                } else{
                    st = mid;
                }
            }
            count += st + 1;
        }
        map.put(new ArrayList<>(A), count);
    }

    public void sumOf(List<Integer> type, int[][] dice, int cur, int tmp, List<Integer> sum){

        if(cur == type.size()){
            sum.add(tmp);
            return;
        }
        //주사위
        for(int i=0; i<6; i++){
            sumOf(type, dice, cur + 1, tmp + dice[type.get(cur)][i], sum);
        }
    }

}
