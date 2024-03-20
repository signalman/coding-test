package Algorithm.day55;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//2:36
public class Main6 {

    static class Node{
        int id;
        int maxWeight;

        public Node(int id, int maxWeight) {
            this.id = id;
            this.maxWeight = maxWeight;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Node>[] edges = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            edges[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[a].add(new Node(b, c));
            edges[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        int l = 1;
        int r = 1_000_000_000;
        while (l < r) {

            int mid = (l + r + 1) / 2;

            if(isPossible(edges, mid, start, end, n)){
                l = mid;
            } else{
                r = mid - 1;
            }
        }
        System.out.println(l);
    }

    private static boolean isPossible(List<Node>[] edges, int mid, int start, int end, int n) {

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {

            int cur = queue.poll();
            if(cur == end) return true;
            for (Node nxt : edges[cur]) {
                if(visited[nxt.id] || nxt.maxWeight < mid) continue;
                queue.add(nxt.id);
                visited[nxt.id] = true;
            }
        }
        return false;
    }
}
