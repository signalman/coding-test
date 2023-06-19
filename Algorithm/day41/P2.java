package Algorithm.day41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2 {

    static int K, V, E;
    static List<Integer>[] edge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < K; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            edge = new List[V+1];
            for(int i=0; i<=V; i++){
                edge[i] = new ArrayList<Integer>();
            }
            for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                edge[u].add(v);
                edge[v].add(u);
            }

            boolean answer = isBinaryGraph();
            System.out.println(answer ? "YES" : "NO");
        }
    }

    static boolean isBinaryGraph(){
        Queue<Integer> queue = new ArrayDeque<>();
        int[] color = new int[V+1];
        for(int i=1; i<=V; i++){
            if(color[i] != 0) continue;
            color[i] = 1;
            queue.add(i);
            while(!queue.isEmpty()){
                int cur = queue.poll();
                for(int nxt: edge[cur]){
                    if(color[nxt] == color[cur]) return false;
                    if(color[nxt] == 3 - color[cur]) continue;
                    color[nxt] = 3 - color[cur];
                    queue.add(nxt);
                }
            }
        }
        return true;
    }
}
