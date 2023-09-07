package Algorithm.day43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P4 {

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        long st = 0;
        long en = K;

        while(st < en){
            long cnt = 0;
            long mid = (int) ((st + en) / 2);
            for(int i = 1; i <= N; i++){
                cnt += Math.min(mid / i, N);
            }
            if(cnt >= K) en = mid;
            else st = mid + 1;
        }
        System.out.println(st);
    }
}
