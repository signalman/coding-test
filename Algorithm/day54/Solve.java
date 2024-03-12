package Algorithm.day54;

import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solve {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        PriorityQueue<String[]> pq = new PriorityQueue<>(Comparator.comparingInt(s -> calc(s[1])));
        pq.addAll(Arrays.asList(plans));

        //미완성 과제
        Stack<String[]> st = new Stack<>(); //이름, 남은시간

        while(!pq.isEmpty()){

            //현재 숙제
            String[] poll = pq.poll();

            //다음번 숙제가 없다.
            if(pq.isEmpty()){
                answer.add(poll[0]);
                continue;
            }

            //끝마칠 수 있을 때
            String[] nxt = pq.peek();
            int diff = diff(nxt[1], poll[1]);
            int compare = diff - Integer.parseInt(poll[2]);
            if (compare == 0) {
                answer.add(poll[0]);
            }
            //끝마친 후에도 시간이 남을 때
            else if(compare > 0){
                answer.add(poll[0]);
                while(compare > 0 && !st.isEmpty()){
                    if(Integer.parseInt(st.peek()[1]) <= compare){
                        String[] pop = st.pop();
                        compare -= Integer.parseInt(pop[1]);
                        answer.add(pop[0]);
                    }
                    else{
                        st.peek()[1] = String.valueOf(Integer.parseInt(st.peek()[1]) - compare);
                    }
                }
            }
            //끝마칠 수 없을때
            else{
                st.add(new String[]{poll[0], String.valueOf(Integer.parseInt(poll[2]) - diff)});
            }
        }

        //남은 숙제 해결
        while (!st.isEmpty()) {
            String[] pop = st.pop();
            answer.add(pop[0]);
        }
        return answer.toArray(new String[0]);
    }

    public int calc(String time){
        String[] sp = time.split(":");
        return Integer.parseInt(sp[0]) * 60 + Integer.parseInt(sp[1]);
    }

    public int diff(String nxtTime, String curTime) {
        return calc(nxtTime) - calc(curTime);
    }

    public static void main(String[] args) {
        Period period = Period.of(2021, 3, 4);
        Period period1 = period.plusDays(20);
        System.out.println(period1.toString());
    }

}
