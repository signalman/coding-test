package Algorithm.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9 {

    static int N, M;
    static char[][] map;
    static int[] ans;
    static int[] start;
    static int[] des;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //가로 크기
        M = Integer.parseInt(st.nextToken()); //세로 크기
        map = new char[N][M];
        ans = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        start = new int[2];
        des = new int[2];

        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                if (map[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
                if (map[i][j] == 'F') {
                    des[0] = i;
                    des[1] = j;
                }
            }
        }
        
        //g의 인접한 4방향 x 처리 - 주변을 지나지도 않는 경우
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if (map[i][j] == 'g') {
                    if(i + 1 < N && map[i+1][j] == '.') map[i+1][j] = 'x';
                    if(i - 1 >= 0 && map[i-1][j] == '.') map[i-1][j] = 'x';
                    if(j + 1 < M && map[i][j+1] == '.') map[i][j+1] = 'x';
                    if(j - 1 >= 0 && map[i][j-1] == '.') map[i][j-1] = 'x';
                }
            }
        }
        solve(start);
        System.out.println(ans[0] + " " + ans[1]);
    }

    private static void solve(int[] start) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][][] visit = new int[N][M][2];

        queue.add(new int[]{start[0], start[1], 0, 0}); //시작점, 쓰레기통, 주변
        visit[start[0]][start[1]] = new int[]{0, 0};
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                for(int k=0; k<2; k++){
                    visit[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int gCnt = cur[2];
            int xCnt = cur[3];

            for(int dir = 0; dir < 4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                int ngCnt = gCnt;
                int nxCnt = xCnt;

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] == 'F') {
                    visit[nx][ny] = select(visit[nx][ny], new int[]{ngCnt, nxCnt});
                    continue;
                }
                if (map[nx][ny] == 'g') ngCnt += 1;
                if(map[nx][ny] == 'x') nxCnt += 1;
                if (visit[nx][ny][0] > ngCnt || (visit[nx][ny][0] == ngCnt && visit[nx][ny][1] > nxCnt)) {
                    visit[nx][ny] = new int[]{ngCnt, nxCnt};
                    queue.add(new int[]{nx, ny, ngCnt, nxCnt});
                }
            }
        }
        ans = visit[des[0]][des[1]];
    }

    private static int[] select(int[] ints, int[] ints1) {
        if(ints[0] < ints1[0] || (ints[0] == ints1[0] && ints[1] < ints1[1])){
            return ints;
        }
        else return ints1;

    }
}
