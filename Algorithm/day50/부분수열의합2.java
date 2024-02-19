package Algorithm.day50;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 부분수열의합2 {

    static int answer;
    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        dfs(0, numbers, N/2, 0, 0);
        dfs(N/2, numbers, N, 0,1);

        Collections.sort(list1);
        Collections.sort(list2);

        for (int i = 0; i < list1.size(); i++) {
            int target = S - list1.get(i);
            int pos = Collections.binarySearch(list2, target);
            if(pos >= 0 && list1.get(i) != 0 && list2.get(pos) != 0) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static void dfs(int depth, int[] numbers, int n, int sum, int type){
        if(depth == n){
            if(type == 0) list1.add(sum);
            else list2.add(sum);
            return;
        }
        dfs(depth + 1, numbers, n, sum + numbers[depth], type);
        dfs(depth + 1, numbers, n, sum, type);

    }
}
