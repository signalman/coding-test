import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static boolean[][] vis;
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};
    static int N;
    static ArrayList<Integer> ret;
    public static class Pair{
        int a;
        int b;
        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
        public int first(){
            return a;
        }
        public int second(){
            return b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        vis = new boolean[N][N];
        List<Integer> ret = new ArrayList<>();
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                board[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
        int home = 0;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(board[i][j] == 1 && vis[i][j] ==false){
                    home++;
                    int cnt = 1;
                    Pair pair = new Pair(i, j);
                    q.offer(pair);
                    vis[i][j] = true;
                    while (!q.isEmpty()) {
                        Pair cur = q.poll();

                        for(int dir = 0; dir < 4; dir++){
                            int nx = cur.first() + dx[dir];
                            int ny = cur.second() + dy[dir];
                            if(nx < 0 || ny <0 || nx >= N || ny >= N) continue;
                            if(board[nx][ny] == 0 || vis[nx][ny]) continue;
                            pair = new Pair(nx, ny);
                            q.offer(pair);
                            vis[nx][ny] = true;
                            cnt++;
                        }
                    }
                    ret.add(cnt);
                }
            }
        }
        Collections.sort(ret);
        ret.add(0, home);
        for (Integer i : ret) {
            System.out.println(i);
        }
    }
}
