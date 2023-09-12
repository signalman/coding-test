package Algorithm.day44;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class P8 {

    static int n, k;
    static int[] cards;
    static int[] chosen;
    static boolean[] visit;
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        cards = new int[n];
        chosen = new int[k];
        visit = new boolean[n];
        for(int i=0; i<n; i++){
            cards[i] = Integer.parseInt(br.readLine());
        }
        set = new HashSet<>();

        solve(0, 0);
        System.out.println(set.size());
    }

    private static void solve(int cur, int size) {
        if(size == k) {
            StringBuilder tmp = new StringBuilder("");
            for (int num : chosen) {
                tmp.append(num);
//                System.out.println("num = " + num);
            }
//            System.out.println();
            set.add(Integer.parseInt(String.valueOf(tmp)));
            return;
        }

        for(int i=0; i<n; i++){
            if(visit[i]) continue;
            chosen[cur] = cards[i];
            visit[i] = true;
            solve((cur + 1) % n, size + 1);
            visit[i] = false;
        }
    }
}
