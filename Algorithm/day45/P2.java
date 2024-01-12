package Algorithm.day45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//dp[2] = 1 , dp[3] = 1;  dp[5] = 2 dp[7] = 1, dp[11] = 1
//
public class P2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int ans = solve(n);
        System.out.println(ans);
    }

    static int solve(int n){
        
        //소수 저장
        List<Integer> primeList = findPrime(n);

        //누적합
        long[] sum = new long[primeList.size()];
        for(int i=0; i<sum.length; i++){
            if(i == 0) sum[i] = primeList.get(i);
            else sum[i] = sum[i-1] + primeList.get(i);
        }
//        for (int i : sum) {
//            System.out.println(i);
//        }

        //이분 탐색
        int ans= 0;
        if(Arrays.binarySearch(sum, n) >= 0) ans++;
        for(int i=0; i<sum.length; i++){
            long tmp = sum[i];
            int index = Arrays.binarySearch(sum, i, sum.length, n + tmp);
            if(index > 0) ans++;
        }
        return ans;
    }

    static List<Integer> findPrime(int n){
        List<Integer> ret = new ArrayList<>();
        boolean[] check = new boolean[n + 1];
        for(int i=2; i<=n; i++){
            if(check[i]) continue;
            ret.add(i);
            for(int j= i * 2; j <= n; j+=i){
                check[j] = true;
            }
        }
        return ret;
    }
}
