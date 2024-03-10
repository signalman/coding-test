package Algorithm.day54;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main1 {
    class Solution {
        final int INF = 987654321;
        public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
            int answer = INF;
            temperature+= 11;
            t1 += 11;
            t2 += 11;

            int[][] dp = new int[onboard.length][55]; // 0~ 50도
            for(int i=0; i<onboard.length; i++) Arrays.fill(dp[i], 0, 55, INF);
            dp[0][temperature] = 0;

            for(int i=1; i<onboard.length; i++){

                //실제 변화 범위
                int start = Math.min(temperature, t1), end = Math.max(temperature, t2);
                if(onboard[i] == 1) {
                    start = t1;
                    end = t2;
                }

                for(int j= start; j <= end; j++){

                    if(j - 1 < 0) continue;

                    //바깥온도와 목표온도가 같음 -> 무조건 에어컨 끄는게 이득
                    if(temperature == j){
                        dp[i][j] = Arrays.stream(new int[]{dp[i][j], dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1]}).min().getAsInt();
                    }
                    //바깥온도가 목표온도보다 높음
                    else if(temperature > j){
                        dp[i][j] = Arrays.stream(new int[]{dp[i][j], dp[i-1][j-1], dp[i-1][j+1] + a, dp[i-1][j] + b}).min().getAsInt();
                    }
                    //바깥온도가 목표온도보다 낮음
                    else{
                        dp[i][j] = Arrays.stream(new int[]{dp[i][j], dp[i-1][j+1], dp[i-1][j-1] + a, dp[i-1][j] + b}).min().getAsInt();
                    }
                }
            }
            return Arrays.stream(dp[onboard.length-1]).min().getAsInt();
        }

    }
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 175);
        map.put(2, 20);
        map.put(3, 85);

        int key = map.entrySet()
                                .stream()
                                .max(Map.Entry.comparingByValue())
                                .get()
                                .getKey();

        int asInt = Arrays.stream(new int[]{1, 2, 3, 4, 5})
                          .min()
                          .getAsInt();


    }

}
