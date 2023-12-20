package Algorithm.day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P6 {

    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){

            int F = Integer.parseInt(br.readLine());

            Map<String, Integer> indexMap = new HashMap<>();
            int index = 0;
            p = new int[200002];

            Arrays.fill(p, 0, 200002, -1);

            for(int j=0; j<F; j++){
                String[] friends = br.readLine().split(" ");
                //없다면 index 부여
                for(String name: friends){
                    if(!indexMap.containsKey(name)) {
                        indexMap.put(name, index);
                        indexMap.put(name, index);
                        index++;
                    }
                }
                int network = union(indexMap.get(friends[0]), indexMap.get(friends[1]));
                sb.append(network).append('\n');
            }
        }
        System.out.println(sb);
    }

    private static int union(int friend1, int friend2) {

        int rootA = find(friend1);
        int rootB = find(friend2);

        if (rootA == rootB) {
            return -p[rootA];
        }
        //루트가 다름.
        if(p[rootA] <= p[rootB]){
            p[rootA] += p[rootB];
            p[rootB] = rootA;
            return -p[rootA];
        }
        else{
            p[rootB] += p[rootA];
            p[rootA] = rootB;
            return -p[rootB];
        }
    }
    private static int find(int node){
        if(p[node] < 0) return node;
        return p[node] = find(p[node]);
    }
}
