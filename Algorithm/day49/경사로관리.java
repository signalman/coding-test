package Algorithm.day49;

import java.util.ArrayDeque;
import java.util.Queue;

public class 경사로관리 {

    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, 1, 0, -1};
    int n, m;

    public int solution(int[][] board) {
        n = board.length;
        m = board[0].length;
        int answer = bfs(0, 0, board);

        return answer;
    }

    int bfs(int r, int c, int[][] board){
        int[][][] dist = new int[n][m][4];
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                for(int d= 0; d < 4; d++){
                    dist[i][j][d] = Integer.MAX_VALUE;
                }
        Queue<int[]> queue = new ArrayDeque<>();
        for(int dir = 0; dir < 4; dir++){
            queue.add(new int[]{r, c, dir});
        }
        dist[0][0][0] = 0;
        dist[0][0][1] = 0;
        dist[0][0][2] = 0;
        dist[0][0][3] = 0;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for(int dir = 0 ; dir < 4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(board[nx][ny] == 1) continue;
                //코너가 생기는 경우
                if(cur[2] % 2 != dir % 2){
                    if(dist[nx][ny][dir] > dist[x][y][cur[2]] + 600){
                        dist[nx][ny][dir] = dist[x][y][cur[2]] + 600;
                        queue.add(new int[]{nx, ny, dir});
                    }
                }
                else{
                    if(dist[nx][ny][dir] > dist[x][y][cur[2]] + 100){
                        dist[nx][ny][dir] = dist[x][y][cur[2]] + 100;
                        queue.add(new int[]{nx, ny, dir});
                    }
                }
            }
        }

        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m; j++){
        //         if(dist[i][j] == Integer.MAX_VALUE) System.out.print("X" + " ");
        //         else System.out.print(dist[i][j]+ " ");
        //     }
        //     System.out.println();
        // }

        int ret = Integer.MAX_VALUE;
        for(int dir =0; dir < 4; dir++){
            ret = Math.min(ret, dist[n-1][m-1][dir]);
        }
        return ret;
    }

}
