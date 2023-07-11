package Algorithm.day37;

import java.io.*;
import java.util.*;

public class SW_5656_벽돌깨기_신호인 {

    static int N, W, H;
    static int[] arr;
    static int[][] map;
    static int ans = Integer.MAX_VALUE;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int play() {

        //이번 게임에 사용할 맵
        int[][] _map = new int[H][W];
        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                _map[i][j] = map[i][j];
            }
        }
        //구슬 출발
        for(int y: arr) {

            for(int x=0; x<H; x++) {
                if(_map[x][y] == 0) continue;
                //가장 처음 0이 아닌 수를 만나게 되는 순간부터 시작
                boom(_map, y, x);
                moveDown(_map);
                break;
            }
        }

        int cnt= 0;
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                if(_map[i][j] != 0) cnt++;
            }
        }
        return cnt;
    }

    private static void boom(int[][] _map, int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>(); //x, y, num, cnt
        queue.add(new int[] {x, y, _map[x][y]});
        _map[x][y] = 0;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cnt = 1;
            while(--cur[2] > 0){
                for(int dir = 0; dir < 4; dir++) {
                    int nx = cur[0] + dx[dir] * cnt;
                    int ny = cur[1] + dy[dir] * cnt;

                    if(nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                    queue.add(new int[] {nx ,ny , _map[nx][ny]});
                    _map[nx][ny] = 0;
                }
                cnt++;
            }
        }
    }

    private static void moveDown(int[][] _map) {
        for(int col = 0; col < W; col++){
            int[] tmp = new int[H];
            int idx = 0;
            for(int row = H-1; row >= 0; row--){
                if(_map[row][col] == 0 ) continue;
                tmp[idx++] = _map[row][col];
            }
            for(int row = H-1; row >= 0; row--){
                _map[row][col] = tmp[H - 1 - row];
            }
        }
    }

    static void dfs(int idx) {
        if(idx >= N) {
            //게임 시작
            ans = Math.min(play(), ans);
            return;
        }

        for(int i = 0; i<W; i++) {
            arr[idx] = i;
            dfs(idx + 1);
        }
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            arr = new int[N];
            map = new int[H][W];
            ans = Integer.MAX_VALUE;

            for(int i=0; i<H; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //구슬 조합 만들기
            dfs(0);
            System.out.println("#" + tc + " " + ans);
        }
    }
}