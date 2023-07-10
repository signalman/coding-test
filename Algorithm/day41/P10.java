package Algorithm.day41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10 {
    static int[][] map;
    static int N;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[N][N][3];
        int ret = map[0][0] == 0 ? solve(0, 0, 0) : solve(0, 0, 2) - 1;
        System.out.println(ret);
    }

    static int solve(int x, int y, int milk) {
        if(dp[x][y][milk] != 0) return dp[x][y][milk];
        dp[x][y][milk] = 1;
        for(int dir = 0; dir < 2; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            int nMilk = (milk + 1) % 3;

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            //원하는 우유일때
            if(map[nx][ny] == nMilk){
                dp[x][y][milk] = Integer.max(dp[x][y][milk], solve(nx, ny, nMilk) + 1);
            }
            //우유 먹지 않고 지나칠때
            else{
                dp[x][y][milk] = Integer.max(dp[x][y][milk], solve(nx, ny, milk));
            }
        }
        return dp[x][y][milk];
    }
}
