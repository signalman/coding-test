package Algorithm.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2 {
    static int N, M, P;
    static int[] S = new int[10];
    static String[] board;
    static String[] tmp;
    static int[] ret;
    static int dx[] = {0, -1, 1, 0};
    static int dy[] = {1, 0, 0, -1};

    static class Pair{
        int x, y;
        Pair(int a, int b){
            this.x = a;
            this.y = b;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        board = new String[M];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=P; i++){
            S[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N; i++){
//            board[i].insert(0, br.readLine());
//            board[i].append(br.readLine());
            board[i] = br.readLine();
        }

        tmp = new String[M];
        while(true){
            tmp = Arrays.copyOf(board, M);
            for(int i=1; i<=P; i++) bfs(i);
            if(Arrays.equals(board, tmp)) break;
        }

        ret = new int[P+1];
        Arrays.fill(ret, 0);
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i].charAt(j) =='.') continue;
                char c = board[i].charAt(j);


            }
        }

        for(int p =1; p<=P; p++){
            System.out.print(ret[p] + " ");
        }

    }

    //해당 플레이어의 이동
    private static void bfs(int player) {
        Queue<Pair> queue = new LinkedList<>();
        boolean vis[][] = new boolean[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tmp[i].charAt(j) - '0' == player){
                    queue.offer(new Pair(i, j));
                    vis[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            for(int dir = 0; dir < 4; dir++){
                int times = S[player];
                int nx = cur.x + dx[dir] * times;
                int ny = cur.y + dy[dir] * times;

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(tmp[nx].charAt(ny) != '.' || vis[nx][ny]) continue;
                queue.offer(new Pair(nx, ny));
                StringBuilder sb = new StringBuilder(tmp[nx]);
                sb.setCharAt(ny, (char)player);
                tmp[nx] = sb.toString();
                vis[nx][ny] = true;
            }
        }
        tmp = board;
    }
}
