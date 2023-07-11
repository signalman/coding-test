package Algorithm.day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1 {
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
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        System.out.print(sb);

    }
    static void dfs(int idx){ //ret에 idx번째 수를 넣는다
        if (idx == M) {
            for(int i=0; i<M; i++){
                sb.append(ret[i] + " ");
            }
            sb.append('\n');
            return;
        }
        for(int i=0; i<N; i++){
            if(idx == 0){
                ret[idx] = arr[i];
                dfs(idx + 1);
            }
            else{
                if (ret[idx - 1] < arr[i]) {
                    ret[idx] = arr[i];
                    dfs(idx + 1);
                }
            }
        }


    }

}
