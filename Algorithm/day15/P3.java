package Algorithm.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P3 {
    static int N, M;
    static int arr[];
    static int ret[];
    static boolean vis[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ret = new int[M];
        vis = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int idx) {
        if(idx >= M){
            for(int i=0; i<M; i++){
                sb.append(ret[i] + " ");
            }
            sb.append('\n');
            return;
        }
        for(int i=0; i<N; i++){
            if(!vis[i]){
                vis[i] = true;
                ret[idx] = arr[i];
                dfs(idx + 1);
                vis[i] = false;
            }
        }
    }
}
