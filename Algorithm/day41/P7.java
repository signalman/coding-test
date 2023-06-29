package Algorithm.day41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P7 {

    static int N, K;
    static List<Integer> kids;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        kids = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            kids.add(Integer.valueOf(st.nextToken()));
        }

//        System.out.println(kids.toString());
        List<int[]> diff = new ArrayList<>();
        for(int i=1; i<N; i++){
            diff.add(new int[]{kids.get(i) - kids.get(i - 1), diff.size()});
        }
        Collections.sort(diff, (o1, o2) -> Integer.compare(o2[0], o1[0]));

//        for (int[] ints : diff) {
//            System.out.print(ints[0] + " " + ints[1] + "    ");
//        }

        //분기점
        boolean[] flag = new boolean[N];
        int count = 0;
        for (int[] ints : diff) {
            if(count == K-1) break;
            flag[ints[1]+1] = true;
            count++;
        }

//        for (boolean b : flag) {
//            System.out.println(b);
//        }
//        8 3
//        1 2 4 7 9 18 19 20

//9 3
//1 2 4 5 10 17 26 28 39

        int ans = 0;
        int mx, mn = kids.get(0);
        for(int i=0; i<N; i++){
            if(flag[i]){
                mx = kids.get(i-1);
                ans += (mx - mn);
                mn = kids.get(i);
            }
            else if(i == N-1 && flag[N-1] == false){
                mx = kids.get(N-1);
                ans += (mx - mn);
            }
        }

        System.out.println(ans);
    }
}
