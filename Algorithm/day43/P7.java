package Algorithm.day43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P7 {

    static int T, W;
    static int[] tree;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        tree = new int[T+1];
        for(int i=1; i<=T; i++){
            tree[i] = Integer.parseInt(br.readLine()) - 1;
        }

        dp = new int[T + 5][W + 5][2];
        //dp[i][j][0] = i번째 자두를 안 먹었고 j만큼 움직였을 때 먹은 총 자두
        //dp[i][j][1] = i번재 자두를 먹었고 j만큼 움직였을 때 먹은 총 자두
//        if(tree[0] == 0) {
//            dp[0][0][0] = 1;
//            dp[0][1][1] = 1;
//        }
//        if(tree[1] == 0){
//            dp[1][0][0] = 1;
//        }

        for (int i = 1; i <= T; i++) {
            for (int j = 1; j <= W + 1; j++) {
                if (tree[i] == 0) {

                    dp[i][j][0] = Math.max(dp[i - 1][j - 1][1], dp[i - 1][j][0]) + 1;
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0]);
                } else {
                    if(i == 1 && j == 1) continue;
                    dp[i][j][1] = Math.max(dp[i - 1][j - 1][0], dp[i - 1][j][1]) + 1;
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1]);
                }
            }
        }


        int ans = 0;
        for (int w = 0; w <= W + 1; w++) {
            for (int e = 0; e < 2; e++) {
                ans = Math.max(ans, dp[T][w][e]);
            }
        }
        System.out.println(ans);
    }
}
