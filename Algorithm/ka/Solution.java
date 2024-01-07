package Algorithm.ka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 힘, 지능 민첩을 적어도 한 번씩
* 소멸되는 능력치 최소화
*
* */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            int n = Integer.parseInt(br.readLine());
            Person[] persons = new Person[n];
            int[][] dp = new int[n][(1<<3)]; //최소
            for(int i=0; i<n; i++){
                for(int j=0; j<8; j++){
                    dp[i][j] = 987654321;
                }
            }
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                persons[i] = new Person(a, b, c);
            }

            solve(persons, dp);
            int ans = dp[n-1][7];
            ans = ans == 987654321 ? -1: ans;
            System.out.println("#" + tc + " " + ans);
        }
    }
    private static void solve(Person[] persons, int[][] dp){
        dp[0][1 << 0] = persons[0].b + persons[0].c;
        dp[0][1 << 1] = persons[0].a + persons[0].c;
        dp[0][1 << 2] = persons[0].a + persons[0].b;
        for(int i=0; i<persons.length - 1; i++){

            for(int j = 0; j < (1<<3); j++){
                dp[i + 1][j | (1<<0)] = Math.min(dp[i + 1][j | (1<<0)], dp[i][j] + persons[i+ 1].b + persons[i + 1].c);
                dp[i + 1][j | (1<<1)] = Math.min(dp[i + 1][j | (1<<1)], dp[i][j] + persons[i + 1].a + persons[i + 1].c);
                dp[i + 1][j | (1<<2)] = Math.min(dp[i + 1][j | (1<<2)], dp[i][j] + persons[i + 1].a + persons[i + 1].b);
            }
        }
    }

    private static class Person{
        int a, b, c;
        Person(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
