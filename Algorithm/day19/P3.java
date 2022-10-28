package Algorithm.day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class P3 {

    static int N;
    static int[][] board;
    static boolean[][] vis;
    static int ans = 0;
    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {-1, 1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        vis = new boolean[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        chess(board, 0);
        System.out.println(ans);
    }

    private static void chess(int[][] myBoard, int count) {
        int[][] tmp = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                tmp[i][j] = myBoard[i][j];
            }
        }
//        int[][] tmp = myBoard.clone();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if (tmp[i][j] == 1 && vis[i][j] == false) {
                    vis[i][j] = true;
                    put(i, j, tmp);
                    chess(tmp, count + 1);
                    tmp = myBoard.clone();
                }
            }
        }
//        System.out.println(board);
        ans = Math.max(ans, count);
    }

    private static void put(int i, int j, int[][] board) {
        board[i][j] = 0;
        for(int dir=0; dir<4; dir++){
            int cnt = 1;
            while (true) {
                int nx = i + dx[dir] * cnt;
                int ny = j + dy[dir] * cnt;
                if(nx < 0 || ny < 0 || nx >= N || ny >= N ) break;
                board[nx][ny] = 0;
                cnt++;
            }
        }
    }

}
