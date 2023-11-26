package Algorithm.day1;

import java.util.*;

class Solution {
    public int[] solution(int[][] dice) {
        int n = dice.length;
        double[][] winProb = new double[n][n]; // 각 주사위 쌍의 승리 확률을 저장

        // 각 주사위 쌍에 대한 승리 확률 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    for (int faceI : dice[i]) {
                        for (int faceJ : dice[j]) {
                            if (faceI > faceJ) {
                                winProb[i][j]++;
                            }
                        }
                    }
                    winProb[i][j] /= 36.0; // 주사위 면은 6x6 조합이므로 36으로 나눔
                }
            }
        }

        // 가능한 모든 조합을 확인
        double maxWinProb = 0;
        int[] answer = new int[n / 2];
        for (int i = 0; i < (1 << n); i++) {
            if (Integer.bitCount(i) == n / 2) {
                List<Integer> a = new ArrayList<>();
                List<Integer> b = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) {
                        a.add(j);
                    } else {
                        b.add(j);
                    }
                }
                double winProbSum = 0;
                for (int ai : a) {
                    for (int bi : b) {
                        winProbSum += winProb[ai][bi];
                    }
                }
                if (winProbSum > maxWinProb) {
                    maxWinProb = winProbSum;
                    for (int j = 0; j < a.size(); j++) {
                        answer[j] = a.get(j) + 1;
                    }
                }
            }
        }

        Arrays.sort(answer);
        return answer;
    }
}
