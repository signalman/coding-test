package Algorithm.day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2 {
    static int k;
    static int[] arr;
    static int[] ret = new int[6];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] strings = br.readLine().split(" ");
            if(strings[0].equals("0")) break;
            k = Integer.parseInt(strings[0]);
            arr = new int[k];
            for(int i=1; i<=k; i++){
                arr[i - 1] = Integer.parseInt(strings[i]);
            }

            dfs(0);
            sb.append('\n');
        }

        System.out.print(sb);

    }

    static void dfs(int idx) {
        if (idx >= 6) {
            for (int i : ret) {
                sb.append(i + " ");
            }
            sb.append('\n');
            return;
        }

        if (idx == 0) {
            for(int i=0; i<k; i++){
                ret[idx] = arr[i];
                dfs(idx + 1);
            }
        }
        else{
            for(int i=0; i<k; i++){
                if(arr[i] > ret[idx-1]){
                    ret[idx] = arr[i];
                    dfs(idx + 1);
                }
            }
        }


    }
}
