package Algorithm.day54;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solve1 {

    public class Plan{
        String name;
        int start;
        int duration;
        Plan(String name, int start, int duration){
            this.name = name;
            this.start = start;
            this.duration = duration;
        }
    }

    public String[] solution(String[][] plans){

        List<String> answer = new ArrayList<>();

        PriorityQueue<Plan> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.start)); //시작시간이 빠른 것부터.
        Arrays.stream(plans).forEach(e -> pq.add(new Plan(e[0], convertTime(e[1]), convertMin(e[2]))));
        Stack<Plan> st = new Stack<>(); //남은 과제 저장

        while (!pq.isEmpty()) {

            Plan cur = pq.poll();
            
            //다음 과제 없음
            if(pq.isEmpty()){
                answer.add(cur.name);
                break;
            }

            Plan nxt = pq.peek();

            //다음과제 딱맞춰 끝날때
            if (nxt.start == cur.start + cur.duration) {
                answer.add(cur.name);
            }
            //다하고도 시간이 남을 때
            else if(nxt.start > cur.start + cur.duration){
                int remain = nxt.start - cur.start - cur.duration;
                answer.add(cur.name);
                while (!st.isEmpty() && remain > 0) {
                    Plan top = st.peek();
                    if(remain >= top.duration){
                        remain -= top.duration;
                        answer.add(top.name);
                        st.pop();
                    }
                    else{
                        top.duration -= remain;
                        remain = 0;
                    }
                }
            }
            //다음과제 전까지 현재 과제 끝낼 수 X
            else{
                st.add(new Plan(cur.name, cur.start, cur.duration - (nxt.start - cur.start)));
            }
        }
        while (!st.isEmpty()) {
            answer.add(st.pop().name);
        }

        return answer.toArray(new String[0]);
    }

    public int convertTime(String time){
        String[] sp = time.split(":");
        return Integer.parseInt(sp[0]) * 60 + Integer.parseInt(sp[1]);
    }
    public int convertMin(String min){
        return Integer.parseInt(min);
    }
}
