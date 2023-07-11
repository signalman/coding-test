package Algorithm.day37;

import java.io.*;
import java.util.*;
public class D4_1238_Contact {

    static List<Integer>[] adjList;
    static int N;
    static int START;
    static int[] vis;
    static int ans;

    static void bfs(int idx) {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(idx);
        vis[idx] = 1;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int nxt: adjList[cur]) {
                if(vis[nxt] > 0) continue;
                queue.add(nxt);
                vis[nxt] = vis[cur] + 1;
            }
        }
        int cnt = 0;
        for(int i=1; i<=100; i++) {
            if(vis[i] > 0) {
                cnt = Math.max(cnt, vis[i]);
            }
        }
        for(int i=1; i<=100; i++) {
            if(vis[i] == cnt) {
                ans = Math.max(ans, i);
            }
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1; tc<=10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            START = Integer.parseInt(st.nextToken());
            ans = 0;

            adjList = new ArrayList[101];
            vis = new int[101];

            for(int i=0; i<=100; i++) {
                adjList[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N/2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjList[from].add(to);
            }
            bfs(START);
            System.out.println("#" + tc + " "+ ans);
        }
    }
}
