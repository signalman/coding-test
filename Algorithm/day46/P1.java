package Algorithm.day46;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//재귀
public class P1 {

    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                ans = Math.max(ans, solve(i, j, map, dp));
            }
        }
        System.out.println(ans);
    }

    //x, y에서 시작했을 때의 최대
    static int solve(int x, int y, int[][] map, int[][] dp){

        if(dp[x][y] != 0) return dp[x][y];
        dp[x][y] = 1;

        for(int dir = 0; dir < 4; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || ny < 0 || nx >= map[0].length || ny >= map[0].length) continue;
            //갱신가능할때
            if(map[x][y] < map[nx][ny]){
                dp[x][y] = Math.max(dp[x][y], solve(nx, ny, map, dp) + 1);
            }
        }
        return dp[x][y];
    }
}
