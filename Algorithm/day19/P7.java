package Algorithm.day19;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P7 {

    public int solution(int[][] jobs) { //시작시각, 걸리는 시간

        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        int answer = 0;
        int now = 0;
        int i = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        //작업의 처리를 내가 판단해야하므로 for문 대신 while문으로
        while(!pq.isEmpty() || i < jobs.length){
            while(now >= jobs[i][0] && i < jobs.length){
                pq.add(new int[]{jobs[i][0], jobs[i][1]});
                i++;
            }
            if(!pq.isEmpty()){
                int[] curJob = pq.poll();
                now += curJob[1];
                answer += now - curJob[0];
            }
            else if(i < jobs.length && now < jobs[i][0]) now = jobs[i][0];
        }
        return answer / jobs.length;
    }
}
