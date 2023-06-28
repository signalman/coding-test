package Algorithm.day41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P6 {

    static int K, N;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        for(int i=0; i<K; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        long start = 1;
        long end = Integer.MAX_VALUE;

        while(start < end){
            long mid = (start + end) / 2 + 1;
            long ret = 0;
            for (Integer integer : list) {
                ret += integer / mid;
            }
            if(N <= ret){
                start = mid;
            } else{
                end = mid - 1;
            }
        }
        System.out.println(start);
//        System.out.println(end);
    }
}
