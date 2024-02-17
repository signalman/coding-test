package Algorithm.day50;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class L1 {
    int mxNode;

    int[] solution(int[] nodes, int[][] edges){
        int[] answer = new int[2];
        for(int i=0; i<nodes.length; i++){
            mxNode = Math.max(nodes[i], mxNode);
        }

        List<Integer>[] graph = new List[mxNode + 1];
        for(int i=0; i<=mxNode; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        for(int node: nodes){
            int ret = treeType(node, graph); //0홀짝트리, 1역홀짝트리, -1:아무것도 아님
            if(ret != -1) answer[ret]++;
        }
        return answer;
    }

    int treeType(int node, List<Integer>[] graph){

        boolean[] visited = new boolean[mxNode + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(node);
        visited[node] = true;
        int type = type(node, graph[node].size());
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for(int nxt: graph[cur]){
                if(visited[nxt]) continue;
                int childCount = 0;
                for(int nxtChild: graph[nxt]){
                    if(visited[nxtChild]) continue;
                    childCount++;
                }
                if(type(nxt, childCount) != type) return -1;
                queue.add(nxt);
                visited[nxt] = true;
            }
        }
        return type;
    }

    int type(int node, int child) {
        if(node % 2 == 1 && child % 2 == 1) return 0; //홀수 노드
        if(node % 2 == 0 && child % 2 == 0) return 0; //짝수 노드
        if(node % 2 == 1 && child % 2 == 0) return 1; //역홀수 노드
        if(node % 2 == 0 && child % 2 == 1) return 1; //역짝수 노드
        return -1;
    }

    public static void main(String[] args) {

        L1 l1 = new L1();
        int[] nodes = new int[]{11, 9, 3, 2, 4, 6};
        int[][] edges = new int[][]{{9, 11}, {2, 3}, {6, 3}, {3, 4}};

        nodes = new int[]{9, 15, 14, 7, 6, 1, 2, 4, 5, 11, 8, 10};
        edges = new int[][]{{5, 14}, {1, 4}, {9, 11}, {2, 15}, {2, 5}, {9, 7}, {8, 1}, {6, 4}};
        int[] solution = l1.solution(nodes, edges);
        System.out.println(solution[0] + " " + solution[1]);
    }
}
