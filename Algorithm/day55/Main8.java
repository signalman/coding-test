package Algorithm.day55;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main8 {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, Comparator.comparing((int[] i) -> i[0]).thenComparing(i -> i[1]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparing(o -> o[1])); //요청시각, 걸리는 시간

        int index = 0;
        int curTime = 0;

        while(index < jobs.length){

            if(index < jobs.length && curTime < jobs[index][0] && pq.isEmpty()) curTime = jobs[index][0];
            //pq에 작업 넣기
            while(index < jobs.length && jobs[index][0] <= curTime){
                pq.add(new int[]{jobs[index][0], jobs[index][1]});
                index++;
            }
            //큐에 있는 작업 완료하기.
            if(!pq.isEmpty()){
                int[] poll = pq.poll(); //요청시각, 소요시간
                curTime += poll[1];
                answer += (curTime - poll[0]);
            }
        }

        while(!pq.isEmpty()){
            int[] poll = pq.poll(); //요청시각, 소요시간
            curTime += poll[1];
            answer += curTime - poll[0];
        }

        return answer / jobs.length;
    }
}
