package Algorithm.day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2 {
    static int N, M;
    static int[] arr;
    static int[] ret;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ret = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int idx) {
        if (idx >= M) {
            for(int i=0; i<M; i++){
                sb.append(ret[i] + " ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            ret[idx] = arr[i];
            dfs(idx + 1);
        }
    }
}