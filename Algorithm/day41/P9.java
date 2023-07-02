package Algorithm.day41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P9 {
    static int N;
    static List<long[]> array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        array = new ArrayList<>();

        long total = 0;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long town = Long.parseLong(st.nextToken());
            long pop = Long.parseLong(st.nextToken());
            array.add(new long[]{town, pop});
            total += array.get(i)[1];
        }

        Collections.sort(array, Comparator.comparingLong(o -> o[0]));

        long mid = 0;
        for(int i=0; i<N; i++){
            mid += array.get(i)[1];
            if(mid >= total - mid) {
                System.out.println(array.get(i)[0]);
                break;
            }
        }
    }
}
