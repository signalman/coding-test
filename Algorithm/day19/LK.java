package Algorithm.day19;

import java.io.*;
import java.util.*;

public class LK {

    private static final int EXP1 = 251;
    private static final int EXP2 = 43;

    private static final long MOD = 1_000_000_005;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String in = br.readLine();
        String pattern = br.readLine();

        List<Integer> answer = solve(in, pattern);
        sb.append(answer.size()).append('\n');

        for (Integer integer : answer) {
            sb.append(integer).append(' ');
        }
        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static List<Integer> solve(String in, String pattern){
        List<Integer> ret = new ArrayList<>();

        int inputLength = in.length();
        int patternLength = pattern.length();

        int inputHash1 = 0;
        int patternHash1 = 0;
        int inputHash2 = 0;
        int patternHash2 = 0;

        long power1 = 1;
        long power2 = 1;

        for(int i = 0; i <= inputLength - patternLength; i++){

            if(i == 0){

                for(int j = 0; j < patternLength; j++){
                    patternHash1 = (int) ((patternHash1 + (pattern.charAt(patternLength - j - 1) * power1)) % MOD);
                    inputHash1 = (int) ((inputHash1 + (in.charAt(patternLength - j - 1) * power1)) % MOD);

                    patternHash2 = (int) ((patternHash2 + (pattern.charAt(patternLength - j - 1) * power2)) % MOD);
                    inputHash2 = (int) ((inputHash2 + (in.charAt(patternLength - j - 1) * power2)) % MOD);


                    if(j < patternLength - 1){
                        power1 = (power1 * EXP1) % MOD;
                        power2 = (power2 * EXP2) % MOD;
                    }
                }
            }
            else{
                inputHash1 = (int) (((inputHash1 - in.charAt(i-1) * power1) * EXP1 + in.charAt(i + patternLength - 1)) % MOD);
                inputHash2 = (int) (((inputHash2 - in.charAt(i-1) * power2) * EXP2 + in.charAt(i + patternLength - 1)) % MOD) ;
                if(inputHash1 < 0) inputHash1 += MOD;
                if(inputHash2 < 0) inputHash2 += MOD;
            }
            if(inputHash1 == patternHash1
                && inputHash2 == patternHash2
            ) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
}





