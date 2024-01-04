package Algorithm.day19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {

    private static int[] p;

    private static boolean isDiffGroup(int n1, int n2){
        int pn1 = find(n1); int pn2 = find(n2);
        if(pn1 == pn2) return false;
        p[pn1] = n2;
        return true;
    }

    private static int find(int node){
        if(p[node] < 0) return node;
        return p[node] = find(p[node]);
    }

    //크루스칼 알고리즘
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");
        int V = Integer.parseInt(in[0]);
        int E = Integer.parseInt(in[1]);

        List<int[]> edges = new ArrayList<>();
        p = new int[V + 1];
        Arrays.fill(p, -1);
        for(int i = 0; i < E; i++){
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            int c = Integer.parseInt(edge[2]);
            edges.add(new int[]{a, b, c});
        }

        Collections.sort(edges, Comparator.comparingInt(o -> o[2]));
        int e = 0;
        int answer = 0;

        for(int[] edge: edges){

            if(e == V - 1) break;
            if(!isDiffGroup(edge[0], edge[1])) continue;
            e += 1;
            answer += edge[2];
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();

    }

}
