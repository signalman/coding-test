package Algorithm.day12;

import java.util.Arrays;

public class test {
    static int[][] board = new int[5][5];

    public static void main(String[] args) {

        for(int i=0; i<5; i++){
            Arrays.fill(board[i], 0, 4, -1);
        }
        int[] n = Arrays.copyOf(board[2], 5);
        int[] m = {-1, -1, -1, -1, 0};
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

        for(int i=0; i<5; i++){
            System.out.println(n[i]);
        }
        System.out.println(Arrays.equals(n, m));
    }
}
