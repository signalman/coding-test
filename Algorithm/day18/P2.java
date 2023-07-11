package Algorithm.day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2 {
    static int N, M;
    static int G, R;
    static int[][] board;
    public static void main(String[] args) throws IOException {//0호수, 1뿌릴x, 2뿌릴o
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //뿌릴 수 있는 칸 중 배양액의 개수만큼 뽑는 경우의 수.
        //뽑은 칸 중 각 배양액의 개수에 맞게 나눈다.
        //돌린다.

    }
}
