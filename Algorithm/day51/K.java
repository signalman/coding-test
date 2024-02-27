package Algorithm.day51;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class K {
    private final int MAX = 1000001;
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        //인접리스트 초기화
        List<Integer>[] outDegree = new List[MAX];
        List<Integer>[] inDegree = new List[MAX];
        for(int i=0; i<MAX; i++){
            outDegree[i] = new ArrayList<>();
            inDegree[i] = new ArrayList<>();
        }
        //인접리스트 값 할당
        for (int[] edge : edges) {
            outDegree[edge[0]].add(edge[1]);
            inDegree[edge[1]].add(edge[0]);
        }

        //새로 생긴 정점 찾기
        int cNode = -1;
        for(int i=0; i<MAX; i++){
            if(inDegree[i].size() == 0 && outDegree[i].size() >= 2) cNode = i;
        }
        answer[0] = cNode;

        //새로 생긴 정점 무효화
        for (Integer tNode : outDegree[cNode]) {
            inDegree[tNode].remove((Integer)cNode);
        }

        boolean[] visited = new boolean[MAX];
        for(Integer startNode: outDegree[cNode]){
            answer[solve(startNode, inDegree, outDegree, visited)]++; //1: 도넛, 2: 막대, 3: 8자
        }
        return answer;
    }

    int solve(int startNode, List<Integer>[] inDegree, List<Integer>[] outDegree, boolean[] visited){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            //막대그래프 판별
            if(isShapeStick(outDegree[cur])) return 2;
            //8자그래프 판별
            if(isShapeEight(inDegree, outDegree, cur)) return 3;

            for(int nxt: outDegree[cur]){
                if(visited[nxt]) continue;
                queue.add(nxt);
                visited[nxt] = true;
            }
        }
        return 1;
    }

    private static boolean isShapeEight(List<Integer>[] inDegree, List<Integer>[] outDegree,
        int cur) {
        return outDegree[cur].size() == 2 && inDegree[cur].size() == 2;
    }

    private static boolean isShapeStick(List<Integer> outDegree) {
        return outDegree.size() == 0;
    }
    public static void main(String[] args) {
        int[][] case1 = new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}};
        K k = new K();
        int[] solution = k.solution(case1);
        Arrays.stream(solution).forEach(System.out::print);
        System.out.println();
        int[][] case2 = new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}};
        solution = k.solution(case2);
        Arrays.stream(solution).forEach(System.out::print);
    }
}
