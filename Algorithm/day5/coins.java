import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class coins {

    static int[] coins, dp;
    static int T, N, goal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            coins = new int[N];
            for(int i=0; i<N; i++){
                coins[i] = Integer.parseInt(st.nextToken());
            }
            goal = Integer.parseInt(br.readLine());
            dp[0] = 1;
            for(int i=1; i<=goal; i++){
                for(int j=0; j<coins.length; j++){
                    dp[i] += dp[i-coins[j]];
                }
            }



        }
    }
}
