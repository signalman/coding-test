package Algorithm.day42;

import com.sun.tools.jconsole.JConsoleContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 퇴사2 {

    static int N;
    static int[] T, P;
    static int[] dp; //dp[0][1] dp[0][0]
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];
        dp = new int[N+2];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int mx = -1;
        for(int i=0; i<N; i++){
            if (mx < dp[i]) {
                mx = dp[i];
            }
            if(i + T[i] < N + 1)
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
        }
        System.out.println(dp[N]);
    }
}
