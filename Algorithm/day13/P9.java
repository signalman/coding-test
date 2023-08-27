package Algorithm.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9 {
    static int V, E, K;
    static List<int[]>[] adj;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        adj = new ArrayList[V + 1];
        dist = new int[V + 1];
        for(int i=1; i<=V; i++){
            dist[i] = Integer.MAX_VALUE;
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[u].add(new int[]{v, w});
        }

        dijkstra();

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=V; i++){
            sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append('\n');
        }
        System.out.println(sb);
    }

    static void dijkstra(){
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        boolean[] vis = new boolean[V + 1];
        dist[K] = 0;
        pq.add(new int[]{K, dist[K]}); //정점, 정점까지 현재 최단거리
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(vis[cur[0]]) continue;
            vis[cur[0]] = true;

            for (int[] nxt : adj[cur[0]]) {
                if(dist[nxt[0]] > dist[cur[0]] + nxt[1]){
                    dist[nxt[0]] = dist[cur[0]] + nxt[1];
                    pq.add(new int[]{nxt[0], dist[nxt[0]]});
                }
            }
        }
    }
}
