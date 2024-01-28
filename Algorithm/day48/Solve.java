package Algorithm.day48;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;

public class Solve {
    static final int INF = 33333;

    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));
        Queue<int[]> queue = new ArrayDeque<>();
        for(int[] route: routes){
            queue.add(route);
        }

        int tmp = -INF;
        while(!queue.isEmpty()){

            int[] cur = queue.poll();
            //범위안에 있을 경우
            if(tmp >= cur[0] && tmp <= cur[1]) continue;

            //범위 밖에 있을 경우
            tmp = cur[1];
            answer++;
        }
        return answer;
    }
}
