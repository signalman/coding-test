package Algorithm.day55;

import java.util.ArrayDeque;
import java.util.Queue;

//boolean[][][][] //visit 4 * 4 * 4 * 4
public class Main15 {

    class Status{
        int r, c;
        int id; //captured character id
    }

    public int solution(int[][] board, int r, int c) {
        int answer = 0;
        boolean[][][][] visited = new boolean[][4][4]; //현재 보드의 상태에 기반한 방문 처리

        Queue<Status> queue = new ArrayDeque<>();
        visited[][r][c]

        




        return answer;
    }

    public static void main(String[] args) {
        Main15 main15 = new Main15();
        System.out.println(main15.solution(new int[][]{{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}}, 1, 0));
        System.out.println(main15.solution(new int[][]{{3,0,0,2}, {0,0,1,0},{0,1,0,0}, {2,0,0,3}}, 0, 1));
    }
}
