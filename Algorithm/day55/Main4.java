package Algorithm.day55;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main4 {

    public int solution(int n, int[][] wires) {

        int answer = Integer.MAX_VALUE;
        for(int i=0; i< n - 1; i++){

            List<Integer>[] edges = unPowered(wires, i);
            int[] count = bfs(n, edges);
            if(Math.abs(count[0] - count[1]) < answer) answer = Math.abs(count[0] - count[1]);
        }

        return answer;
    }


    List<Integer>[] unPowered(int[][] wires, int index){

        List<Integer>[] edges = new List[wires.length + 2];
        for(int i=1; i<=wires.length + 1; i++){
            edges[i] = new ArrayList<>();
        }

        for(int i=0; i<wires.length; i++){

            if(i == index) continue;
            int st = wires[i][0];
            int en = wires[i][1];
            edges[st].add(en);
            edges[en].add(st);
        }

        return edges;
    }

    int[] bfs(int n, List<Integer>[] edges){

        List<Integer> ret = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();

        int count = 0;

        for(int i=1; i<=n; i++){
            if(visited[i]) continue;
            queue.add(i);
            visited[i] = true;
            count = 1;
            while(!queue.isEmpty()){

                int cur = queue.poll();
                for(int nxt: edges[cur]){
                    if(visited[nxt]) continue;
                    visited[nxt] = true;
                    queue.add(nxt);
                    count++;
                }
            }
            ret.add(count);
        }
        return ret.stream().mapToInt(i -> i).toArray();
    }
}
