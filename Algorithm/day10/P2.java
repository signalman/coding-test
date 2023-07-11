package Algorithm.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2 {
    static int N, M;
    static boolean[][] light = new boolean[101][101];
    static boolean[][] vis = new boolean[101][101];
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {1, 0, 0, -1};
    static ArrayList<Node>[][] map = new ArrayList[101][101];
    static class Node{
        int x,y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                map[i][j] = new ArrayList<>();
            }
        }

        for(int i=0; i<M; i++){
            String str = br.readLine();
            st = new StringTokenizer(str);
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int toRow = Integer.parseInt(st.nextToken());
            int toCol = Integer.parseInt(st.nextToken());
            map[row][col].add(new Node(toRow,toCol));
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1, 1));
        vis[1][1] = true;
        light[1][1] = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            //현재 방에서 불켜기
            for (Node node : map[cur.x][cur.y]) {
                if(vis[node.x][node.y]) continue;
                light[node.x][node.y] = true;
                for(int dir =0; dir < 4; dir++){
                    int nx = node.x + dx[dir];
                    int ny = node.y + dy[dir];
                    if(nx < 1 || ny < 1 || nx > N || ny > N) continue;
                    if(vis[nx][ny]){
                        queue.offer(new Node(node.x, node.y));
                        vis[node.x][node.y] = true;
                    }
                }
            }
            for(int dir = 0; dir < 4; dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < 1 || ny < 1 || nx > N || ny > N) continue;
                if(vis[nx][ny] || !light[nx][ny]) continue;
                queue.offer(new Node(nx, ny));
                vis[nx][ny] = true;
            }
        }
        int cnt = 0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(light[i][j]) cnt++;
            }
        }
        System.out.println(cnt);
    }
}