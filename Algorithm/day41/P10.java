package Algorithm.day41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
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

        if (map[0][0] == 0) {
            dp[0][0][0] = 1;
            solve(0, 0, 0);
        } else {
            solve(0, 0, 2);
        }

        int ans = 0;
        for(int i =0; i< 3; i++){
            ans = Integer.max(ans, dp[N - 1][N - 1][i]);
        }
        System.out.println(ans);
    }

    private static void solve(int i, int j, int milk) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j, milk});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll(); //cur[0], cur[1]: 좌표, cur[2]: 마지막으로 먹은 우유

            for(int dir = 0; dir < 2; dir++){
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                int nMilk = (cur[2] + 1) % 3;

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                //원하는 우유일때
                if (map[nx][ny] == nMilk) {
                    dp[nx][ny][nMilk] = Integer.max(dp[nx][ny][nMilk], dp[cur[0]][cur[1]][cur[2]] + 1);
                    queue.add(new int[]{nx, ny, nMilk});
                }
                //원하지 않은 우유일때
                else{
                    dp[nx][ny][cur[2]] = Integer.max(dp[nx][ny][cur[2]], dp[cur[0]][cur[1]][cur[2]]);
                    queue.add(new int[]{nx, ny, cur[2]});
                }
            }
        }
    }
}
