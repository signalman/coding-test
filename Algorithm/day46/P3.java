package Algorithm.day46;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3 {

    static int n, m;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        solve(0, 0, 0, numbers);
        System.out.println(ans);
    }
    static void solve(int cur, int depth, int ret, int[] numbers){
//        if(cur >= n) return;
        if(depth == 3){
            if(ret <= m) ans = Math.max(ans, ret);
            return;
        }
        for(int i = cur; i < n; i++){
            solve(i + 1, depth + 1, ret + numbers[i], numbers);
        }
    }
}
