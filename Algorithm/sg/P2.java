package Algorithm.sg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P2 {

    static int N, S;
    static int[] arr;
    static List<Integer> left, right;
    static void dfs1(int idx, int size, int sum){
        if(idx == size){
            left.add(sum);
            return;
        }
        dfs1(idx, size, sum);
        dfs1(idx, size, sum+arr[idx]);
    }
    static void dfs2(int idx, int size, int sum){
        if(idx == size){
            right.add(sum);
            return;
        }
        dfs2(idx, size, sum);
        dfs2(idx, size, sum+arr[idx]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        left = new ArrayList<>();
        right = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs1(0, N/2, 0);
        dfs2(N/2, N, 0);

        Collections.sort(right);


    }
}
