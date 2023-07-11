package Algorithm.day31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D2_1954_달팽이숫자_신호인 {

    static StringBuilder sb;
    static int[][] board;
    static int N;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int test = 1; test <= t; test++){
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            for(int i=0; i<N; i++) Arrays.fill(board[i], 0, N, -7); //초기 -7로 세팅
            sb = new StringBuilder();
            snail(0, 0, 0, 1); //(0, 0) 방향, 넣어야 할 값
            printResult(test);
        }
    }


    private static void snail(int x, int y, int dir, int val) {

        board[x][y] = val;
        for(int i=0; i<4; i++){
            int nd = (dir + i) % 4;
            int nx = x + dx[nd];
            int ny = y + dy[nd];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] != -7) continue;
            snail(nx ,ny, nd, val+1);
            return;
        }
    }
    private static void printResult(int test) {
        sb.append("#").append(test).append('\n');
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(board[i][j]).append(" ");
            }sb.append('\n');
        }
        System.out.print(sb);
    }
}
