package Algorithm.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P8 {

    static int N, M;
    static List<int[]>[] adj;
    static int[] dist;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        /* 최단 거리 테이블 MAX값으로 채우기 */
        dist = new int[N + 2];
        Arrays.fill(dist, 0, N + 2, Integer.MAX_VALUE);
        dist[1] = 0;

        /* 연결 리스트 초기화 */
        adj = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        /* 연결 리스트 업데이트 */
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            adj[a].add(new int[]{d, b});
            adj[b].add(new int[]{d, a});
        }

        dijkstra1();

    }

    static void dijkstra1(){
        boolean[] vis = new boolean[N];

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.add(new int[]{dist[1], 1}); //초기값 넣기
        vis[1] = true;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            for (int[] nxt : adj[cur[1]]) {
                if(vis[nxt[1]]) continue;
                if(dist[nxt[1]] > dist[cur[1]] + nxt[0]) {
                    dist[nxt[1]] = dist[cur[1]] + nxt[0];
                    pq.add(new int[]{nxt[1], dist[nxt[1]]});
                }
            }
        }
    }
    static void dijkstra2(){

    }

}
