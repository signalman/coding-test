package Algorithm.day11;

import java.util.LinkedList;
import java.util.Queue;

public class P1 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum = 0;
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i : queue1) {
            q1.offer(i);
            sum += i;
            sum1 += i;
        }
        for (int i : queue2) {
            q2.offer(i);
            sum += i;
            sum2 += i;
        }
        if(sum % 2 == 1) return -1;
        while(answer<=600_000){
            if(sum1 == sum2) return answer;
            if(sum1 > sum2) {
                sum1 -= q1.peek();
                sum2 += q1.poll();
            }
            else{
                sum2 -= q2.peek();
                sum1 += q2.poll();
            }
            answer++;
        }
        return -1;
    }
}
