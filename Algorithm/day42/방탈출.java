package day42;//package Algorithm.day42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

/*
한 점에서 다른 모든 점까지의 거리, 합 계산
거리가 가장 긴것 중 최고 합구하기
0은 못감
 */
public class 방탈출 {
    static int N, M;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] ans; //거리, 합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        ans = new int[2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans[0] = 0;
        ans[1] = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0) continue;
                solve(i, j);
            }
        }
        System.out.println(ans[1]);
    }
    static void solve(int x, int y){
        int[][] dist = new int[N][M];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        dist[x][y] = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(dist[cur[0]][cur[1]] > ans[0]){
                ans[0] = dist[cur[0]][cur[1]];
                ans[1] = map[x][y] + map[cur[0]][cur[1]];
            }
            else if ((dist[cur[0]][cur[1]] == ans[0]) && (ans[1] < map[cur[0]][cur[1]] + map[x][y])) {
                ans[1] = map[cur[0]][cur[1]] + map[x][y];
            }

            for(int dir = 0; dir < 4; dir++){
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(map[nx][ny] == 0 || dist[nx][ny] != 0) continue;
                queue.add(new int[]{nx, ny});
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
            }
        }
    }
}
