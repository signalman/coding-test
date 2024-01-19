package Algorithm.day47;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static final int p1 = 31;
    static final int p2 = 43;

    static final long MOD1 = 1_000_000_003;
    static final long MOD2 = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String string = br.readLine();

        int st = 0;
        int en = L;

        while(st != en){

            int mid = st + (en - st + 1) / 2; //현재 문자열의 길이를 가정
            //조건에 만족
            if(cal(string, mid)){
                st = mid;
            }
            //조건 만족 x
            else{
                en = mid - 1;
            }
        }
        System.out.println(st);
    }


    static boolean cal(String str, int length){

        Map<Long, Integer> count1 = new HashMap<>();
        Map<Long, Integer> count2 = new HashMap<>();

        long hash1 = 0;
        long hash2 = 0;
        long pp1 = 1;
        long pp2 = 1;

        for(int i=0; i<str.length() - length + 1; i++){

            if(i == 0){
                for(int j=0; j < length; j++){
                    hash1 = (hash1 * p1 + str.charAt(j) - '0') % MOD1;
                    hash2 = (hash2 * p2 + str.charAt(j) - '0') % MOD2;

                    if(j != length - 1){
                        pp1 = (pp1 * p1) % MOD1;
                        pp2 = (pp2 * p2) % MOD2;
                    }
                }
            }
            else{
                hash1 = (hash1 - ((pp1 * (str.charAt(i - 1) - '0') % MOD1) + MOD1) % MOD1) * p1 + str.charAt(i + length - 1) - '0';
                hash1 = (hash1 % MOD1 + MOD1) % MOD1;

                hash2 = (hash2 - ((pp2 * (str.charAt(i - 1) - '0') % MOD2) + MOD2) % MOD2) * p2 + str.charAt(i + length - 1) - '0';
                hash2 = (hash2 % MOD2 + MOD2) % MOD2;
            }
            count1.put(hash1, count1.getOrDefault(hash1, 0) + 1);
            count2.put(hash2, count2.getOrDefault(hash2, 0) + 1);
            if(count1.get(hash1) >= 2 && count2.get(hash2) >= 2) return true;
        }
        return false;
    }
}
