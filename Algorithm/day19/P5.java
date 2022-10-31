package Algorithm.day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P5 {
    static int L, C;
    static char[] arr;
    static StringBuilder sb = new StringBuilder();
    static char[] ret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        ret = new char[L];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++){
            Character c = st.nextToken().charAt(0);
            arr[i] = c;
        }
        Arrays.sort(arr);
        dfs(0, 0, 0); //길이 자음 모음
        System.out.print(sb);

    }

    static void dfs(int idx, int ja, int mo) {
        if (idx >= L) {
            if (ja >= 2 && mo >= 1) {
                for(int i=0; i<L; i++){
                    sb.append(ret[i]);
                }
                sb.append('\n');
            }
            return;
        }
        if (idx == 0) {
            for (int i = 0; i < C; i++) {
                put(idx, ja, mo, i);
            }
        }
        else{
            for(int i=0; i<C; i++){
                if (arr[i] > ret[idx - 1]) {
                    put(idx, ja, mo, i);
                }
            }
        }
    }

    private static void put(int idx, int ja, int mo, int i) {
        ret[idx] = arr[i];
        if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] =='u'){
            dfs(idx + 1, ja, mo + 1);
        }
        else{
            dfs(idx + 1, ja + 1, mo);
        }
    }
}
