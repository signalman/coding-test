package Algorithm.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1 {
    static int N;
    static int[][] board;
    static int MAX = -1; //비가 가장 많이 올때의 양을 저장
    static int ret = 0;
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int water){ //water은 현재 비의 양
        Queue<Pair> queue = new LinkedList<>();
        boolean vis[][] = new boolean[N][N];
        for(int i=0; i<N; i++) Arrays.fill(vis[i], false);

        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(vis[i][j] || board[i][j] <= water) continue;
                queue.offer(new Pair(i, j));
                vis[i][j] = true;
                cnt++;
                while(!queue.isEmpty()){
                    Pair cur = queue.poll();
                    for(int dir =0; dir<4; dir++){
                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];
                        if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                        if(vis[nx][ny] || board[nx][ny] <= water) continue;
                        queue.offer(new Pair(nx, ny));
                        vis[nx][ny] = true;
                    }
                }
            }
        }
        ret = Math.max(ret, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int height = Integer.parseInt(st.nextToken());
                board[i][j] = height;
                MAX = Math.max(height, MAX);
            }
        }

        for(int i=0; i<=MAX; i++){
            bfs(i);
        }
        System.out.println(ret);
    }
}
