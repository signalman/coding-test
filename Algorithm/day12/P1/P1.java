package Algorithm.day12.P1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1 {
    static int n;
    static int[][] board;
    static int blue;
    static int white;
    static boolean isOneFill(int x1, int y1, int x2, int y2){
        for(int i=x1; i<x2; i++){
            for(int j=y1; j<y2; j++){
                if(board[i][j] != 1) return false;
            }
        }
        return true;
    }
    static boolean isZeroFill(int x1, int y1, int x2, int y2){
        for(int i=x1; i<x2; i++){
            for(int j=y1; j<y2; j++){
                if(board[i][j] != 0) return false;
            }
        }
        return true;
    }

    static void cutPaper(int x1, int y1, int x2, int y2){
        if (isOneFill(x1, y1, x2, y2)) {
            blue++;
            return;
        }
        if (isZeroFill(x1, y1, x2, y2)) {
            white++;
            return;
        }
        cutPaper(x1, y1, (x1+x2) / 2, (y1+y2) / 2);
        cutPaper(x1, (y1+y2)/2, (x1+x2)/2, y2);
        cutPaper((x1+x2)/2, y1, x2, (y1+y2)/2);
        cutPaper((x1+x2)/2, (y1+y2)/2, x2, y2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cutPaper(0,0, n, n);
        System.out.println(white);
        System.out.println(blue);
    }
}
