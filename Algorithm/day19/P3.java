package Algorithm.day19;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3 {
    static int N;
    static int[][] board;
    static boolean[][] visited, isBlack;
    static int[] res;
    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {-1, 1, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];
        isBlack = new boolean[N][N];
        res = new int[2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                isBlack[i][j] = (i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1);
            }
        }

        dfs(0, true, 0);
        dfs(0, false, 0);
        System.out.println(res[0] + res[1]);
    }

    static void dfs(int idx, boolean black, int cnt) {

        for(int i=idx; i<N*N; i++){
            int x = i / N;
            int y = idx % N;

            if(board[x][y] == 0 || isBlack[x][y] != black || !check(x, y)) continue;
            visited[x][y] = true;
            dfs(i + 1, black, cnt + 1);
            visited[x][y] = false;
        }
        res[black ? 0 : 1] = Math.max(res[black ? 0 : 1], cnt);
    }

    static boolean check(int x, int y) {
        for (int dir = 0; dir < 2; dir++) {
            int cnt = 0;
            while (true) {
                int nx = x + (dx[dir] * cnt);
                int ny = y + (dy[dir] * cnt);

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;
                if(visited[nx][ny]) return false;
                cnt++;
            }
        }
        return true;
    }

}
