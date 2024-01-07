package Algorithm.day44;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int[] dx = {1, 1, 0, 0, -1, -1};
    static int[] dy = {0, 1, -1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc ++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int ans = solve(s, e);
            System.out.println("#" + tc + " " + ans);
        }
    }

    private static class Node{
        int dist;
        int row;
        int col;
        Node(int dist, int row, int col){
            this.dist = dist;
            this.row = row;
            this.col = col;
        }
    }
    //오른쪽 아래 => + (i + 1)
    //왼쪽 아래 => + (i)

    private static int solve(int s, int e){
        //현재값, 행, 열
        Queue<Node> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[150][150];
        int[] startRC = getRC(s);
        int[] endRC =  getRC(e);
        queue.add(new Node(0, startRC[0], startRC[1]));
        visited[startRC[0]][startRC[1]] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur.row == endRC[0] && cur.col == endRC[1]) return cur.dist;

            for(int dir = 0; dir < 6; dir++){
                int nx = cur.row + dx[dir];
                int ny = cur.col + dy[dir];

                if(nx < 1 || ny < 1 || nx >= 150 || ny >= 150) continue;
                if(visited[nx][ny]) continue;
                queue.add(new Node(cur.dist + 1, nx, ny));
                visited[nx][ny] = true;
            }
        }
        return -1;
    }

    //해당 수의 row, col 구하기
    private static int[] getRC(int num){
        if(num == 1) return new int[]{1, 1};
        int[] ret = new int[2];
        for(int i=1; i< 10001; i++){
            if((num >= (i * i + i) / 2 + 1) && (num < ((i+1) * (i+1) + i + 1) / 2 + 1)){
                ret[0] = i + 1;
                ret[1] = num - (i * i + i) / 2;
                break;
            }
        }
        return ret;
    }
}
