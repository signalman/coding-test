package Algorithm.day43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5 {

    static int N, M, T;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = solve();
        System.out.println(ans <= T ? ans : "Fail");
    }

    private static int solve() {

        int[][][] visit = new int[2][N][M];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0});
        visit[0][0][0] = 1; // 칼 안들고 0,0에서 시작 -> 거리 1

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();
            int w = cur[0];
            int x = cur[1];
            int y = cur[2];

            if(x == N-1 && y == M-1) return (visit[w][x][y] - 1);

            for(int dir = 0; dir < 4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                int nw = w;

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(map[nx][ny] == 0 && visit[nw][nx][ny] != 0) continue;
                if(visit[nw][nx][ny] != 0) continue;
                if(w == 1){
                    queue.add(new int[]{nw, nx, ny});
                    visit[nw][nx][ny] = visit[w][x][y] + 1;
                }
                else {
                    if(map[nx][ny] == 1) continue;
                    if(map[nx][ny] == 2) nw = 1;
                    queue.add(new int[]{nw, nx, ny});
                    visit[nw][nx][ny] = visit[w][x][y] + 1;
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
