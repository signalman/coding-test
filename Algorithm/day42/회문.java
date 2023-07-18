package Algorithm.day42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문 {

    static int T;
    static String[] inputs;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        inputs = new String[T];
        sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            inputs[i] = br.readLine();
        }

        for (String s : inputs) {
            sb.append(solve(s, 0, s.length()-1, 0))
              .append('\n');
        }

        System.out.println(sb);
    }
    //comabccbamaoc
    //coammoc
    //abcba
    static int solve(String s, int st, int en, int cnt){
        if(st > en || cnt >= 2){
            return cnt;
        }
        //다를때
        if(s.charAt(st) != s.charAt(en)){
            int a = solve(s, st + 1, en, cnt + 1);
            int b = solve(s, st, en - 1, cnt + 1);
            return Math.min(a, b);
        }
        //같을때
        return solve(s, st + 1, en - 1, cnt);
    }
}
