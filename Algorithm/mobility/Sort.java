package Algorithm.mobility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        solve(str1, str2);

    }
    private static void solve(String str1, String str2) {

        int[][] dp = new int[1001][1001];
        for(int i=0; i<str1.length(); i++){
            for(int j=0; j<str2.length(); j++){
                //포함시키기
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i + 1][j + 1] = Math.max(dp[i][j] + 1, dp[i + 1][j + 1]);
                }
                else{
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        System.out.println(dp[str1.length()][str2.length()]);
        StringBuilder lcs = new StringBuilder();

        int i = str1.length(), j = str2.length();
        while(!(i == 0 || j == 0)){
            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else if (dp[i][j] == dp[i][j - 1]) {
                j--;
            }
            else{
                lcs.append(str1.charAt(i - 1));
                i--;
                j--;
            }
        }
        System.out.println(lcs.reverse());
    }
}

