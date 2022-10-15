package Algorithm.nexon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2 {
    static int[][] board;
    static int N, M, K;
    static int[][][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static class Pair{
        int x, y, z;
        Pair(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
        int getX(){
            return x;
        }
        int getY(){
            return y;
        }
        int getZ(){
            return z;
        }
    }

    static int bfs(int i, int j){
        int ret= 0x7f7f7f7f;
        dist[i][j][0] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i, j, 0));
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            for(int dir=0; dir<4; dir++){
                int nx = cur.getX() + dx[dir];
                int ny = cur.getY() + dy[dir];
                int z = cur.getZ();

                if(nx < 0|| ny <0 || nx >= N || ny >=M) continue;
                if(board[nx][ny] == 1){
                    if(z+1 > K) continue;
                    if(dist[nx][ny][z+1] != 0) continue;
                    if(z>=1 && dist[nx][ny][z-1] != 0)continue;
                    queue.offer(new Pair(nx, ny, z+1));
                    dist[nx][ny][z+1] = dist[cur.getX()][cur.getY()][z] + 1;
                }
                else{
                    if(dist[nx][ny][z] != 0) continue;
                    if(z>=1 && dist[nx][ny][z-1] !=0)continue;
                    queue.offer(new Pair(nx, ny, z));
                    dist[nx][ny][z] = dist[cur.getX()][cur.getY()][z] + 1;
                }
            }
        }
        for(int times=0; times<=K; times++){
            if(dist[N-1][M-1][times] == 0)continue;
            ret = Math.min(ret, dist[N-1][M-1][times]);
        }
        if(ret == 0x7f7f7f7f) ret = -1;
        return ret;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N+1][M+1];
        dist = new int[N+1][M+1][K+1];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                board[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        int ans = bfs(0, 0);
        System.out.println(ans);
    }
}
