package Algorithm.day13;

import java.io.*;
import java.util.*;

public class P10 {

    static int N, M;
    static ArrayList<Node>[] adj;
    static long[] dist1;
    static long[][] dist2;

    static class Node{
        int to;
        long dist;

        Node(int to, long dist){
            this.to = to;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        dist1 = new long[N + 1];
        dist2 = new long[2][N+1];

        for(int i=0; i<N+1; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            adj[a].add(new Node(b, d));
            adj[b].add(new Node(a, d));
        }

        dijkstra1();
        dijkstra2();

        int cnt = 0;
        for(int i=1; i<=N; i++){
            if(dist1[i] < Math.min(dist2[0][i], dist2[1][i])) cnt++;
        }
        System.out.println(cnt);
    }

    private static void dijkstra1() {
        dist1 = new long[N+1];
        Arrays.fill(dist1, Long.MAX_VALUE);
        int start = 1;
        dist1[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.dist));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if(dist1[cur.to] < cur.dist) continue;

            for (Node nxt : adj[cur.to]) {
                long nxtDist = nxt.dist * 2;
                if (dist1[nxt.to] > dist1[cur.to] + nxtDist) {
                    dist1[nxt.to] = dist1[cur.to] + nxtDist;
                    pq.add(new Node(nxt.to, dist1[nxt.to]));
                }
            }
        }
    }

    private static void dijkstra2() {
        for(int i=0; i<2; i++){
            for(int j=0; j<N+1; j++){
                dist2[i][j] = Long.MAX_VALUE;
            }
        }

        int start = 1;
        dist2[0][start] = 0;

        PriorityQueue<WolfNode> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.dist));
        pq.add(new WolfNode(start, 0, true));

        while (!pq.isEmpty()) {
            WolfNode cur = pq.poll();
            int idx = cur.isOdd ? 0 : 1;

            if(dist2[idx][cur.to] < cur.dist) continue;

            for (Node nxt : adj[cur.to]) {
                long nxtDist = cur.isOdd ? nxt.dist : nxt.dist * 4;
                int nxtIdx = 1 - idx;
                if (dist2[nxtIdx][nxt.to] > dist2[idx][cur.to] + nxtDist) {
                    dist2[nxtIdx][nxt.to] = dist2[idx][cur.to] + nxtDist;
                    pq.add(new WolfNode(nxt.to, dist2[nxtIdx][nxt.to], !cur.isOdd));
                }
            }
        }
    }

    static class WolfNode{
        int to;
        long dist;
        boolean isOdd;

        WolfNode(int to, long dist, boolean isOdd) {
            this.to = to;
            this.dist = dist;
            this.isOdd = isOdd;
        }
    }
}
