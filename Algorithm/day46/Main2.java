package Algorithm.day46;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main2 {

    public int solution(int[] menu, int[] order, int k) {
        int answer = 0;

        int index = 0;
        long curTime = 0;
        Queue<Integer> queue = new ArrayDeque<>(); //걸릴시간

        while(index < order.length){

            //작업 넣기
            while(index < order.length && curTime >= index * k){
                queue.add(menu[order[index]]);
                if(curTime == index * k)
                    answer = Math.max(answer, queue.size());
                else
                    answer = Math.max(answer, queue.size() + 1);
                index++;
                // System.out.println(answer);
            }
            if(queue.isEmpty()){
                curTime = index * k;
                continue;
            }
            //작업 완료하기
            int takenTime = queue.poll();
            curTime += takenTime;
        }


        return answer;
    }
}
