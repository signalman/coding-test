package Algorithm.day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P1 {
    static int N, M;
    static int[] arr;
    static int[] ret;
    static boolean[] vis;
    static Set<List<Integer>> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        ret = new int[M];
        vis = new boolean[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);

        for (List<Integer> list : set) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

    }

    static void dfs(int idx) {
        if (idx >= M) {
            List<Integer> collect = Arrays.stream(ret).boxed().collect(Collectors.toList());
            set.add(collect);
            return;
        }
        if (idx == 0) {
            for(int i=0; i<N; i++){
                ret[idx] = arr[i];
                vis[i] = true;
                dfs(idx + 1);
                vis[i] = false;
            }
        }
        else{
            for(int i=0; i<N; i++){
                if (ret[idx - 1] <= arr[i] && !vis[i]) {
                    ret[idx] = arr[i];
                    vis[i] = true;
                    dfs(idx + 1);
                    vis[i] = false;
                }
            }
        }
    }

}
