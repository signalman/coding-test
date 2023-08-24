package Algorithm.day43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 * 정사각형 N*N
 *
* */
public class P1 {

    static String SUCCESS = "HaruHaru";
    static String FAIL = "Hing";
    static int N;
    static int[][] map;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean isPossible = solve();
        System.out.println(isPossible ? SUCCESS : FAIL);
    }

    private static boolean solve() {

        boolean[][] visit = new boolean[N][N];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, map[0][0]});
        visit[0][0] = true;

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();
            for(int dir = 0; dir < 2; dir++){
                int nx = cur[0] + dx[dir] * cur[2];
                int ny = cur[1] + dy[dir] * cur[2];

                if((nx < 0 || ny < 0 || nx >= N || ny >= N) || visit[nx][ny]) continue;
                if(map[nx][ny] == -1) return true;
                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny, map[nx][ny]});
            }
        }
        return false;
    }
}
