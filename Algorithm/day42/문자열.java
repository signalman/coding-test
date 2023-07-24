package Algorithm.day42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열 {

    static String S;
    static int N;
    static String[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        N = Integer.parseInt(br.readLine());
        A = new String[N];
        for(int i=0; i<N; i++){
            A[i] = br.readLine();
        }

        String tmp = "";
        //solve
        int ans = solve(0, tmp);
        System.out.println(ans);
    }
    private static int solve(int idx, String tmp) {

        if(idx == S.length()) return 1;

        for(int i = idx; i < S.length(); i++){
            tmp += S.charAt(i);
            for (String s : A) {
                if (tmp.equals(s)) {
                    int result = solve(idx + s.length(), "");
                    if(result == 1) return 1;
                }
            }
        }
        return 0;
    }
}
