package Algorithm.day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4 {
    static int N;
    static int[] res;
    static int[][] board;
    static boolean[][] visited, isBlack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        res = new int[2];
        board = new int[N][N];
        visited = new boolean[N][N];
        isBlack = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                isBlack[i][j] = (i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1);
            }
        }

        dfs(0,true,0); // black 칸의 비숍
        dfs(0,false,0); // white 칸의 비숍
        System.out.println(res[0] + res[1]);
    }

    static void dfs(int index, boolean black, int cnt) {

        for (int i = index; i < N * N; i++) {
            int x = i / N;
            int y = i % N;

            if (board[x][y] == 0 || isBlack[x][y] != black || !check(x, y))
                continue;

            visited[x][y] = true;
            dfs(i + 1, black, cnt + 1);
            visited[x][y] = false;
        }

        res[black ? 0 : 1] = Math.max(res[black ? 0 : 1], cnt);
    }

    // 현재 위치  +  대각선 체크
    static boolean check(int x, int y) {
        int[] dx = {-1,-1};
        int[] dy = {-1,1};

        for (int i = 0; i < 2; i++){
            int nx = x;
            int ny = y;
            while (true) {
                if (0 > nx || nx >= N || 0 > ny || ny >= N)
                    break;
                if (visited[nx][ny])
                    return false;

                nx += dx[i];
                ny += dy[i];
            }
        }
        return true;
    }
}
