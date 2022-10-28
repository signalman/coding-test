package Algorithm.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Tests {
    public static void main(String[] args) {

        int[][] board = {{1, 2, 3}, {4, 5, 6,}, {7, 8, 9,}};

        int[][] clone = board.clone();
        int[][] e = new int[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                e[i][j] = board[i][j];
            }
        }


        for (int[] ints : e) {
            for (int anInt : ints) {
                System.out.print(anInt+ " ");
            }
            System.out.println();
        }

        for (int[] ints : clone) {
            for (int anInt : ints) {
                System.out.print(anInt+ " ");
            }
            System.out.println();
        }

    }

    private static void func(int[][] board) {
        board[1][1] = 1002;
    }
}
