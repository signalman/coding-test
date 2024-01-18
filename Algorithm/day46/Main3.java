package Algorithm.day46;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main3 {
    static int[][] holeMap;
    static int[] dx = {1, 0, -1, 0, 2, 0, -2, 0};
    static int[] dy = {0, 1, 0, -1, 0, 2, 0, -2};
    static int[][][] dist;

    public int solution(int n, int m, int[][] hole) {
        holeMap = new int[n+1][m+1];
        dist = new int[n+1][m+1][2];
        for(int[] h: hole){
            holeMap[h[0]][h[1]] = 1;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, 1, 1});
        dist[1][1][1] = 1;


        while(!queue.isEmpty()){
            int[] cur = queue.poll(); //x, y, remain

            for(int dir = 0; dir < 4; dir++){
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if(nx > n || ny > m || nx <= 0 || ny <= 0) continue;
                if(dist[nx][ny][cur[2]] != 0 || holeMap[nx][ny]==1) continue;
                dist[nx][ny][cur[2]] = dist[cur[0]][cur[1]][cur[2]] + 1;
                queue.add(new int[]{nx, ny, cur[2]});
            }

            //마법쓰기
            if(cur[2] == 1){
                for(int dir = 4; dir < 8; dir++){
                    int nx = cur[0] + dx[dir];
                    int ny = cur[1] + dy[dir];

                    if(nx > n || ny > m || nx <= 0 || ny <= 0) continue;
                    if(dist[nx][ny][0] != 0 || holeMap[nx][ny] == 1) continue;
                    dist[nx][ny][0] = dist[cur[0]][cur[1]][1] + 1;
                    queue.add(new int[]{nx, ny, 0});
                }
            }
        }

        int ans = 0;
        if(dist[n][m][0] != 0 && dist[n][m][1] != 0) ans = Math.min(dist[n][m][0], dist[n][m][1]);
        else ans = (dist[n][m][0] | dist[n][m][1]);

        return ans - 1;
    }
}
