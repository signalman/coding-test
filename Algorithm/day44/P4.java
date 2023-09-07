package Algorithm.day44;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4 {

    static int T, W;
    static int[] trees;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        trees = new int[T];

        for(int i=0; i<T; i++){
            trees[i] = Integer.parseInt(br.readLine()) - 1;
        }

        dp = new int[T+5][W+5][2];
        if(trees[0] == 0) {
            dp[0][0][0] = 1;
        } else{
            dp[0][1][1] = 1;
        }

        for(int i=0; i<T; i++){
            for(int j=0; j<=W; j++){
                if(trees[i] == 0){
                    dp[i + 1][j + 1][0] = Integer.max(dp[i][j + 1][0] + 1, dp[i][j][1]);
                    dp[i + 1][j + 1][1] = Integer.max(dp[i][j][0], dp[i][j + 1][1]);
                }
                else{//1나무에 떨어진다.
                    dp[i + 1][j + 1][1] = Integer.max(dp[i][j + 1][1] + 1, dp[i][j][0]);
                    dp[i+1][j+1][0] = Integer.max(dp[i][j+1][0], dp[i][j][1]);
                }
            }
        }

        int ans = 0;
        for(int i=0; i<T; i++){
            for(int j=0; j<=W; j++){
                for(int k = 0; k < 2; k++){
                    ans = Math.max(ans, dp[i][j][k]);
                }
            }
        }
        System.out.println(ans);
    }
}
