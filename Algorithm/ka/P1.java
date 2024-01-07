package Algorithm.ka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1 {

    static int[] cache;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringBuilder sb = new StringBuilder();
            char[][] board = new char[3][3];
            cache = new int[60000];
            for(int i=0; i< 60000; i++) cache[i] = -2;
            for(int i=0; i<3; i++){
                board[i] = br.readLine().toCharArray();
            }
            int[] cnt = new int[2];
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(board[i][j] == 'o') cnt[0]++;
                    else if(board[i][j] == 'x') cnt[1]++;
                }
            }
            
            //1: 승, 0: 비김, -1: 짐
            int ans = cnt[0] == cnt[1] ? solve(board, 'x') : solve(board, 'o');

            if(ans == 0){
                sb.append("TIE").append("\n");
            }
            else{
                if(cnt[0] == cnt[1]) {
                    if(ans == 1){
                        sb.append("x").append("\n");
                    }
                    else {
                        sb.append("o").append("\n");
                    }
                }
                else{
                    if(ans == 1){
                        sb.append("o").append("\n");
                    }
                    else{
                        sb.append("x").append("\n");
                    }
                }
            }
            System.out.print(sb);
        }
    }

    private static int boardToInt(char[][] board){
        int ret = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                ret *= 3;
                if(board[i][j] == 'o') ret += 1;
                else if(board[i][j] == 'x') ret += 2;
            }
        }
        return ret;
    }
    private static boolean isFinished(char[][] board, char turn){
        if(board[0][0] != '.' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return true;
        if(board[0][2] != '.' && board[0][2] == board[1][1] && board[2][0] == board[1][1]) return true;
        for(int i=0; i<3; i++){
            if(board[i][0] != '.'&& board[i][0] == board[i][1] && board[i][1] == board[i][2]) return true;
            if(board[0][i] != '.'&& board[0][i] == board[1][i] && board[1][i] == board[2][i]) return true;
        }
        return false;
    }


    private static int solve(char[][] board, char turn){
        int ret = cache[boardToInt(board)];

        if(ret != -2) return ret;
        if(isFinished(board, (char) ('o' + 'x' - turn))) return -1;

        int minValue = 2;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i][j] == '.') {
                    board[i][j] = turn;
                    minValue = Math.min(minValue, solve(board, (char) ('o' + 'x' - turn)));
                    board[i][j] = '.';
                }
            }
        }
        if(minValue == 0 || minValue == 2) return cache[boardToInt(board)] = 0;
        return cache[boardToInt(board)] = -minValue;
    }
}
