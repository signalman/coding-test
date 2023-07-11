package Algorithm.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P3 {
    static int N, M;
    static int[] arr;
    static boolean[] vis;
    static int[] ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        for(int i=0; i<N; i++){
            arr[i] = i;
        }
        vis = new boolean[N+1];
        Arrays.fill(vis, false);
        ret = new int[M];
        dfs(0, 1);
    }

    private static void dfs(int idx, int offset) {
        if(idx == M){
            for (int i : ret) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for(int i=offset; i<=N; i++){
            //선택할 경우
            vis[i] = true;
            ret[idx] = i ;
            dfs(idx + 1, i + 1);
            vis[i] = false;
        }
    }
}
