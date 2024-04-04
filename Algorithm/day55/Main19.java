package Algorithm.day55;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main19 {

    static int N, M;
    static List<int[]> candidate = new ArrayList<>();
    static List<List<int[]>> virus = new ArrayList<>();
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    candidate.add(new int[]{i, j});
                }
            }
        }
        dfs(candidate, M, -1, new ArrayList<>());

        int answer = INF;
        for (List<int[]> virus : virus) {

            int[][] dist = new int[N][N];
            int d = bfs(map, virus, dist);
            if(!check(map, dist)) continue;
            answer = Math.min(answer, d);
        }
        System.out.println(answer == INF ? -1 : answer);
    }

    static boolean check(int[][] map, int[][] dist){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 0 && dist[i][j] == 0) return false;
            }
        }
        return true;
    }

    static int bfs(int[][] map, List<int[]> virus, int[][] dist){

        Queue<int[]> queue = new ArrayDeque<>();
        int mx = 1;
        for (int[] v : virus) {
            dist[v[0]][v[1]] = 1;
            queue.add(new int[]{v[0], v[1]});
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;
                if(dist[nx][ny] > 0 || map[nx][ny] == 1) continue;
                queue.add(new int[]{nx, ny});
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                if(map[nx][ny] != 2){
                    mx = Math.max(mx, dist[nx][ny]);
                }
            }
        }
        return mx - 1;
    }

    static void dfs(List<int[]> candidate, int M, int idx, List<int[]> tmp) {

        if(tmp.size() == M){
            virus.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = idx + 1; i < candidate.size(); i++){
            tmp.add(new int[]{candidate.get(i)[0], candidate.get(i)[1]});
            dfs(candidate, M, i, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
