package Algorithm.day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3 {
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static class Dice{
        //현재 위치
        int x, y;

        //위, 뒤, 오, 왼, 앞, 밑
        int[] figure = new int[6];

        Dice(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] board;
    static int N, M, K;
    static int sx, sy;
    static int[] op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        op = new int[K];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Dice dice = new Dice(sx,sy);
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            op[i] = Integer.parseInt(st.nextToken());
            move(dice, op[i]);
        }
    }

    private static void move(Dice dice, int dir) {
        //위 뒤 오 왼 앞 밑
        int[] figure = dice.figure;

        int nx = dice.x + dx[dir];
        int ny = dice.y + dy[dir];
        if(nx < 0 || ny < 0 || nx >= N || ny >= M) return;
        dice.x = nx;
        dice.y = ny;

        if (dir == 1) { //동
            int tmp = figure[0];
            figure[0] = figure[3];
            figure[3] =figure[5];
            figure[5] = figure[2];
            figure[2] = tmp;
        } else if (dir == 2) { //서
            int tmp = figure[0];
            figure[0] = figure[2];
            figure[2] = figure[5];
            figure[5] = figure[3];
            figure[3] = tmp;
        } else if (dir == 3) { //북
            int tmp = figure[0];
            figure[0] = figure[4];
            figure[4] = figure[5];
            figure[5] = figure[1];
            figure[1] = tmp;
        } else if (dir == 4) {  //남
            int tmp = figure[0];
            figure[0] = figure[1];
            figure[1] = figure[5];
            figure[5] = figure[4];
            figure[4] = tmp;
        }

        if (board[dice.x][dice.y] == 0) {
            board[dice.x][dice.y] = figure[5];
        }
        else{
            figure[5] = board[dice.x][dice.y];
            board[dice.x][dice.y] = 0;
        }

        System.out.println(figure[0]);

    }
}
