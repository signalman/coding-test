package Algorithm.day46;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int start, end, time;
        public Node(int start, int end, int time){
            this.start = start;
            this.end = end;
            this.time= time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            List<Node> edges = new ArrayList<>();
            //m
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edges.add(new Node(s, e, t));
                edges.add(new Node(e, s, t));
            }
            for(int i=0; i<w; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edges.add(new Node(s, e, -t));
            }
            boolean ans = false;
            ans = solve(0, edges, n);
            if (ans)
                sb.append("YES\n");
            else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }
    static boolean solve(int node, List<Node> edges, int n){
        int[] dist = new int[n + 1];
        Arrays.fill(dist, 0, n + 1, 987654321);
        dist[node] = 0;
        for(int i=1; i<n; i++){

            for(int j=0; j<edges.size(); j++){
                int s = edges.get(j).start;
                int e = edges.get(j).end;
                int t = edges.get(j).time;
                if(dist[e] > dist[s] + t) dist[e] = dist[s] + t;
            }
        }

        for(int j=0; j<edges.size(); j++){
            int s = edges.get(j).start;
            int e = edges.get(j).end;
            int t = edges.get(j).time;
            if(dist[e] > dist[s] + t) return true;
        }
        return false;
    }


}
