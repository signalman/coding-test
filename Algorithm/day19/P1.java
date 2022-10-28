package Algorithm.day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P1 {
    static int N, M;
    static int[] arr;
    static int[] ret;
    static Set<List<Integer>> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        ret = new int[M];
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
            List<Integer> list = Arrays.stream(ret).boxed().collect(Collectors.toList());
            set.add(list);
            return;
        }
        if (idx == 0) {
            for(int i=0; i<N; i++){
                ret[idx] = arr[i];
                dfs(idx + 1);
            }
        }
        else{
            for(int i=0; i<N; i++){
                if (arr[i] >= ret[idx - 1]) {
                    ret[idx] = arr[i];
                    dfs(idx + 1);
                }
            }
        }
    }


}
