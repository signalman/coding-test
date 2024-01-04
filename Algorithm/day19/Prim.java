package Algorithm.day19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Prim {

    private static class Node {
        int nxt;
        int cost;
        Node(int nxt, int cost){
            this.nxt = nxt;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");
        int V = Integer.parseInt(in[0]);
        int E = Integer.parseInt(in[1]);

        List<Node>[] graph = new List[V + 1];
        for(int i=0; i<V+1; i++){
            graph[i] = new ArrayList<>();
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        boolean[] visit = new boolean[V + 1];

        for(int i = 0; i < E; i++){
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            int c = Integer.parseInt(edge[2]);
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        for (Node node : graph[1]) {
            pq.add(new Node(node.nxt, node.cost));
        }
        visit[1] = true;

        int answer = 0;
        int e = 0;

        while (e < V - 1) {
            Node cur = pq.poll();
            if(visit[cur.nxt]) continue;
            visit[cur.nxt] = true;
            answer += cur.cost;
            e++;
            for(Node node: graph[cur.nxt]){
                pq.add(new Node(node.nxt, node.cost));
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();

    }
}
