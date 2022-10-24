package Algorithm.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2 {
    static int R, C;
    static final int MX = 1502;
    static char[][] board = new char[MX][MX];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Pair> birds = new ArrayList<>();
    static Queue<Pair> q1 = new LinkedList<>();
    static Queue<Pair> q2= new LinkedList<>();
    static Queue<Pair> l1= new LinkedList<>();
    static Queue<Pair> l2= new LinkedList<>();
    static boolean[][] vis = new boolean[MX][MX];
    static boolean[][] visited = new boolean[MX][MX];
    static int lx, ly;
    static boolean isPossible = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<C; j++){
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'L') {
                    lx = i;
                    ly = j;
                }
                if (board[i][j] != 'X') {
                    q1.offer(new Pair(i, j));
                }
            }
        }

        int days = 0;
        l1.offer(new Pair(lx, ly));
        board[lx][ly] = '.';
        vis[lx][ly] = true;

        //백조가 서로 못 만나는 동안
        while(!isPossible){
            //물이 녹는 함수.
            while (!q1.isEmpty()) {
                Pair cur = q1.poll();
                visited[cur.x][cur.y] = true;
                for(int dir = 0 ; dir < 4; dir++){
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if(visited[nx][ny]) continue;
                    if(board[nx][ny] == 'X'){
                        q2.offer(new Pair(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }

            while (!q2.isEmpty()) {
                Pair cur = q2.poll();
                board[cur.x][cur.y] = '.';
                q1.offer(new Pair(cur.x, cur.y));
            }
            days++;
            //백조찾기
            while (!l1.isEmpty()) {
                Pair cur = l1.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if(vis[nx][ny]) continue;
                    if (board[nx][ny] == 'X') {
                        l2.offer(new Pair(nx, ny));
                        vis[nx][ny] = true;
                        continue;
                    } else if (board[nx][ny] == 'L') {
                        isPossible = true;
                        break;
                    }
                    vis[nx][ny] = true;
                    l1.offer(new Pair(nx, ny));
                }
            }
            while (!l2.isEmpty()) {
                Pair cur = l2.poll();
                l1.offer(new Pair(cur.x, cur.y));
            }
        }
        System.out.println(days);
    }


    static class Pair{
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
