package Algorithm.day56;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//1:34
//북 동 남 서
public class Main {

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0; //청소하는 칸

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y, d});
        map[x][y] = 2;
        count++;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(nearDirty(cur, map)){
                d = cur[2];

                while(true){
                    d = (d + 3) % 4;
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];
                    if(map[nx][ny] == 0){
                        map[nx][ny] = 2;
                        queue.add(new int[]{nx, ny, d});
                        count++;
                        break;
                    }
                }

            } else{
                int nd = (cur[2] + 2) % 4;
                int nx = cur[0] + dx[nd];
                int ny = cur[1] + dy[nd];
                if(map[nx][ny] == 1) break;
                queue.add(new int[]{nx, ny, d});
            }
        }
        System.out.println(count);
    }

    static boolean nearDirty(int[] cur, int[][] map) {
        int x = cur[0];
        int y = cur[1];
        int d = cur[2];

        for(int dir = 0; dir < 4; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(map[nx][ny] == 0) return true;
        }
        return false;
    }
}
