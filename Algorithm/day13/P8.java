package Algorithm.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class P8 {

    static int N, M;
    static List<Node> adj;
    static class Node{
        int from, to, dist;
        Node(int from, int to, int dist){
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            Node node1 = new Node(a, b, d);
            Node node2 = new Node(b, a, d);

            adj.add(node1);
            adj.add(node2);
        }
        Collections.sort(adj, Comparator.comparingInt(o -> o.dist));





    }
}

