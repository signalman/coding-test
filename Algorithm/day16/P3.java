package Algorithm.day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P3 {
    static final int MX = 5;
    static char[][] board = new char[MX][MX];
    static int[] arr = new int[25];
    static int[] ret = new int[7];
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<MX; i++){
            String str = br.readLine();
            for(int j=0; j<MX; j++){
                board[i][j] = str.charAt(j);
            }
        }
        for(int i=0; i<25; i++){
            arr[i] = i;
        }
        //0~ 24까지의 수 중 7개를 선택함
        //선택한 7개의 수가 각각 인접했는지, S가 4개 이상인지 확인
        dfs(0);
        System.out.println(cnt);
    }

    static void dfs(int idx){
        if(idx >= 7){
            //7개의 수가 각각 인접해 있는지
            if(!isClose(ret)) return;
            //S가 4개 이상인지
            if(!isMoreFour(ret)) return;
            cnt++;
            return;
        }
        if (idx == 0) {
            for(int i=0; i<25; i++){
                ret[idx] = arr[i];
                dfs(idx + 1);
            }
        }
        else{
            for (int i = 0; i < 25; i++) {
                if (ret[idx - 1] < arr[i]) {
                    ret[idx] = arr[i];
                    dfs(idx + 1);
                }
            }
        }
    }

    private static boolean isMoreFour(int[] ret) {
        int som = 0;
        for (int num : ret) {
            int i = num / 5;
            int j = num % 5;
            if(board[i][j] == 'S'){
                som++;
            }
        }
        return som >= 4;
    }

    private static boolean isClose(int[] ret) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean[][] m = new boolean[5][5];
        for(int i=0; i<5; i++){
            Arrays.fill(m[i], false);
        }
        for (int num : ret) {
            int i = num / 5;
            int j = num % 5;
            m[i][j] = true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(ret[0]/5, ret[0]%5));
        m[ret[0]/5][ret[0]%5] = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for(int dir = 0 ; dir < 4; dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx <0 || ny < 0 || nx>=5 || ny >= 5) continue;
                if(m[nx][ny] == false) continue;
                queue.offer(new Node(nx, ny));
                m[nx][ny] = false;
            }
        }
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(m[i][j] == true) return false;
            }
        }
        return true;
    }

    static class Node{
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
