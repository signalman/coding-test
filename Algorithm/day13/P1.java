package Algorithm.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1 {
    static int N;
    static char[][] board = new char[65][65];

    static int check(int x, int y, int N){
        int ret = -1;
        char tmp = board[x][y];
        for(int i=x; i<x+N; i++){
            for(int j=y; j<y+N; j++){
                if(board[i][j] != tmp) return ret;
            }
        }
        return tmp - '0';
    }

    static void rec(int x, int y, int N){
        int fill = check(x, y, N);

        if(fill == 0) {
            System.out.print(0);
        }
        else if(fill == 1){
            System.out.print(1);
        }
        else{
            System.out.print("(");
            rec(x, y, N/2);
            rec(x, y + N/2, N/2);
            rec(x + N/2, y, N/2);
            rec(x + N/2, y + N/2, N/2);
            System.out.print(")");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                board[i][j] = str.charAt(j);
            }
        }

        rec(0, 0, N);
    }
}
