package Algorithm.day35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class D2_14510_나무높이_신호인 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());
            int[] tree = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                tree[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(tree);
            int sumDiff = IntStream.range(0, N).map(i -> tree[N-1] - tree[i]).sum();
            int even = sumDiff / 2;
            int odd = sumDiff % 2;
            while(even > odd + 1){
                even--;
                odd+=2;
            }
            System.out.print("#" + tc+ " ");
            System.out.println(even >= odd ? even * 2 : odd * 2 - 1);
        }

    }
}
