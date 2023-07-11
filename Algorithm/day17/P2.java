package Algorithm.day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P2 {
    static int N,M;
    static int[] arr;
    static int[] ret;
    static boolean[] vis;
//    static LinkedHashSet<List<Integer>> ans= new LinkedHashSet<>();
    static ArrayList<List<Integer>> ans= new ArrayList<>();

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

        List<List<Integer>> collect = ans.stream().distinct().collect(Collectors.toList());


        for (List<Integer> an : collect) {
            for (Integer integer : an) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
    static void dfs(int idx) {
        if (idx >= M) {
            List<Integer> collect = Arrays.stream(ret).boxed().collect(Collectors.toList());
            ans.add(collect);
            return;
        }
        for(int i=0; i<N; i++){
            if(vis[i]) continue;
            ret[idx] = arr[i];
            vis[i] = true;
            dfs(idx + 1);
            vis[i] = false;
        }
    }
}
