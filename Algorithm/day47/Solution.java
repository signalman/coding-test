package Algorithm.day47;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    static final int EXP1 = 31;
    static final int EXP2 = 43;

    static final int MOD1 = 1_000_000_003;
    static final int MOD2 = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String in = br.readLine();

        int st = 0;
        int en = length;

        while(st < en){

            int mid = st + (en - st + 1) / 2;
            if(lavinCarp(in, mid)) st = mid;
            else en = mid - 1;
        }
        System.out.println(st);
    }

    static boolean lavinCarp(String in, int L){

        Map<Long, Integer> count1 = new HashMap<>();
        Map<Long, Integer> count2 = new HashMap<>();

        long hash1 = 0;
        long hash2 = 0;
        long pp1 = 1;
        long pp2 = 1;

        for(int i=0; i <= in.length() - L; i++){

            //초기값 설정
            if(i == 0){
                for(int j=0; j<L; j++){
                    hash1 = ((hash1 * EXP1 + in.charAt(j) - 'a') % MOD1 + MOD1) % MOD1;
                    hash2 = ((hash2 * EXP2 + in.charAt(j) - 'a') % MOD2 + MOD2) % MOD2;
                    if(j != L - 1){
                        pp1 = (pp1 * EXP1 % MOD1 + MOD1) % MOD1;
                        pp2 = (pp2 * EXP2 % MOD2 + MOD2) % MOD2;
                    }
                }
            }
            else{
                hash1 = ((hash1 - (((in.charAt(i - 1) - 'a') * pp1) % MOD1 + MOD1) % MOD1) % MOD1 + MOD1) % MOD1;
                hash2 = ((hash2 - (((in.charAt(i - 1) - 'a') * pp2) % MOD2 + MOD2) % MOD2) % MOD2 + MOD2) % MOD2;

                hash1 = ((hash1 * EXP1) % MOD1 + MOD1) % MOD1;
                hash2 = ((hash2 * EXP2) % MOD2 + MOD2) % MOD2;

                hash1 = ((hash1 + in.charAt(i + L - 1) - 'a') % MOD1 + MOD1) % MOD1;
                hash2 = ((hash2 + in.charAt(i + L - 1) - 'a') % MOD2 + MOD2) % MOD2;

            }

            count1.put(hash1, count1.getOrDefault(hash1, 0) + 1);
            count2.put(hash2, count2.getOrDefault(hash2, 0) + 1);
            if(count1.get(hash1) >= 2 && count2.get(hash2) >= 2) return true;
//            if(count1.get(hash1) >= 2) return true;
//            if(count2.get(hash2) >= 2) return true;
        }
        return false;
    }

}
