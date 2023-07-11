package Algorithm.day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P1 {
    static final int R = 12;
    static final int C = 6;
    static char[][] board = new char[R][C];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean canBoom = false;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<R; i++){
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        int cnt = 0;
        while (true) {
            canBoom = false;
            //bfs를 돌면서 상하좌우 4개 이상 연결된 곳 찾고 .으로 바꾸기
            bfs();
            if(!canBoom) break;
            cnt++;
            //각 열에 대해 아래로 이동
            move();
        }
        System.out.println(cnt);
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        for(int i=0; i<R; i++){
            Arrays.fill(visited[i], false);
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(board[i][j] == '.' || visited[i][j]) continue;
                int count = 1;
                queue.offer(new Node(i, j));
                visited[i][j] = true;
                while (!queue.isEmpty()) {
                    Node cur = queue.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];

                        if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                        if(board[nx][ny] != board[cur.x][cur.y] || visited[nx][ny]) continue;
                        queue.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                        count++;
                    }
                }
                if (count >= 4) {
                    canBoom = true;
                    // i, j에 대한 boom
                    char c = board[i][j];
                    board[i][j] = '.';
                    queue.offer(new Node(i, j));
                    while (!queue.isEmpty()) {
                        Node cur = queue.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];
                            if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                            if(board[nx][ny] != c) continue;
                            board[nx][ny] = '.';
                            queue.offer(new Node(nx, ny));
                        }
                    }
                }
            }
        }
    }

    static void move(){
        for (int col = 0; col < 6; col++) {
            String str = "";
            for (int row = 0; row <12; row++) {
                if(board[row][col] == '.')continue;
                str += board[row][col];
            }
            int a = 12 - str.length();
            while (a > 0) {
                str = '.' + str;
                a--;
            }

            for (int row = 0; row < 12; row++) {
                board[row][col] = str.charAt(row);
            }
        }
    }

    static class Node{
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
