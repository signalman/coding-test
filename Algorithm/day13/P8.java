package Algorithm.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
=======
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
>>>>>>> b3b7f71d0b842c7e2a6c29d6f2dd997a1999c8a5
import java.util.StringTokenizer;

public class P8 {

    static int N, M;
<<<<<<< HEAD
    static List<Node> adj;
    static class Node{
        int from, to, dist;
        Node(int from, int to, int dist){
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }
=======
    static List<int[]>[] adj;
    static int[] dist;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
>>>>>>> b3b7f71d0b842c7e2a6c29d6f2dd997a1999c8a5

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
<<<<<<< HEAD
        adj = new ArrayList<>();

        for(int i=0; i<M; i++){
=======

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
>>>>>>> b3b7f71d0b842c7e2a6c29d6f2dd997a1999c8a5
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

<<<<<<< HEAD
            Node node1 = new Node(a, b, d);
            Node node2 = new Node(b, a, d);

            adj.add(node1);
            adj.add(node2);
        }
        Collections.sort(adj, Comparator.comparingInt(o -> o.dist));
=======
            adj[a].add(new int[]{d, b});
            adj[b].add(new int[]{d, a});
        }

        dijkstra1();

>>>>>>> b3b7f71d0b842c7e2a6c29d6f2dd997a1999c8a5





    }
<<<<<<< HEAD
}

=======

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
>>>>>>> b3b7f71d0b842c7e2a6c29d6f2dd997a1999c8a5
