package Algorithm.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1 {
    static int[] ret;
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ret = new int[M];
        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int idx) {
        if(idx >= M){
            for(int i=0; i<ret.length; i++){
                sb.append(ret[i] + " ");
            }
            sb.append('\n');
            return;
        }

        for(int i=1; i<=N; i++){
            ret[idx] = i;
            dfs(idx + 1);
        }
    }
}
