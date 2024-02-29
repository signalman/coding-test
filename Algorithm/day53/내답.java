package Algorithm.day53;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 내답 {
    static List<Integer> sumA;
    static List<Integer> sumB;
    static int count = -1;
    static int[] ans;

    public int[] solution(int[][] dice) {

        int N = dice.length;
        ans = new int[N/2];

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        combination(0, N, dice, a, b);
        return ans;
    }


    //현재 index, 길이, 주사위, 선택된 a 인덱스, 선택된 b 인덱스
    void combination(int cur, int N, int[][] dice, List<Integer> a, List<Integer> b){
        if(cur == N){
            if(a.size() == N/2 && b.size() == N/2) {
                sumA = new ArrayList<>();
                sumB = new ArrayList<>();

                //A
                // 0 ~ 6으로 N/2개 조합만들기
                int[] getNumbersA = new int[N / 2];
                rollDice(0, N / 2, getNumbersA, dice, a, false);

                //B
                //0~6으로 N/2개 조합만들기
                int[] getNumbersB = new int[N / 2];
                rollDice(0, N / 2, getNumbersB, dice, b, true);

                Collections.sort(sumA);
                Collections.sort(sumB);

                int tmpCount = 0;
                for (int i = 0; i < sumA.size(); i++) {
                    int st = 0;
                    int en = sumB.size() - 1;

                    while(st < en) {
                        int mid = (st + en + 1) / 2; // mid 계산 수정
                        // 조건에 만족
                        if(sumB.get(mid) < sumA.get(i)) {
                            st = mid; // st 업데이트 수정
                        }
                        // 조건에 만족하지 않음
                        else {
                            en = mid - 1;
                        }
                    }
                    tmpCount += st + 1;
                }
                if (count < tmpCount) {
                    count = tmpCount;
                    for (int i = 0; i < N / 2; i++) {
                        ans[i] = a.get(i) + 1;
                    }
                }

            }
            return;
        }

        a.add(cur);
        combination(cur + 1, N, dice, a, b);
        a.remove(a.size()- 1);
        b.add(cur);
        combination(cur + 1, N, dice, a, b);
        b.remove(b.size() - 1);
    }


    void rollDice(int cur, int N, int[] getNumbers, int[][] dice, List<Integer> a, boolean flag){

        if(cur == N){
            int sum = 0;

            for(int i=0; i<N; i++){
                sum += dice[a.get(i)][getNumbers[i]];
            }
            if(flag) sumB.add(sum);
            else sumA.add(sum);
            return;
        }

        for(int i=0; i<6; i++){
            getNumbers[cur] = i;
            rollDice(cur + 1, N, getNumbers, dice, a, flag);
        }
    }
}
