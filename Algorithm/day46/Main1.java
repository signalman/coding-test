package Algorithm.day46;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main1 {

    //프로그램 종료시각, 점수마다의 대기시간
//program[i] = [점수/호출시각/실행시간]
    public long[] solution(int[][] program) {
        long[] answer = new long[11];
        //우선순위 높은 순
        //호출시각 순
        Arrays.sort(program, Comparator.comparingInt(o1 -> o1[0]));
        Arrays.sort(program, Comparator.comparingInt(o1 -> o1[1]));


        Arrays.sort(program, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return Integer.compare(o1[0], o2[0]);
                }
                return Integer.compare(o1[1], o2[1]);
            }
        });

        //우선순위 높은 순
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        long curTime = 0;
        int idx = 0;

        while(idx < program.length){
            //현재 시각보다 작은 작업 넣기
            while(idx < program.length && curTime >= program[idx][1]){
                pq.add(program[idx]);
                idx++;
            }
            if(pq.isEmpty()) {
                curTime = program[idx][1];
                continue;
            }


            //한가지 작업 처리하기
            int[] p = pq.poll(); //점수, 호출시각, 실행시간
            //대기시간 갱신
            answer[p[0]] += (curTime - p[1]);

            //현시시각 갱신
            curTime += p[2];
        }

        while(!pq.isEmpty()){
            int[] p = pq.poll(); //점수, 호출시각, 실행시간
            //대기시간 갱신
            answer[p[0]] += (curTime - p[1]);

            //현시시각 갱신
            curTime += p[2];
        }

        answer[0] = curTime;
        return answer;
    }
}
