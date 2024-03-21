package Algorithm.day55;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Main7 {
    public int[] solution(int[] prices) {

        List<Integer> answer = new ArrayList<>();
        Stack<int[]> st = new Stack<>(); //값, index
        for(int i=prices.length -1; i>=0; i--){
            if(st.isEmpty()) {
                st.push(new int[]{prices[i], i});
                answer.add(0);
            }
            else{

                while(!st.isEmpty() && st.peek()[0] >= prices[i]){
                    st.pop();
                }
                if(st.isEmpty()) {
                    answer.add(prices.length - 1 - i);
                } else{
                    answer.add(st.peek()[1] - i);
                }
                st.push(new int[]{prices[i], i});
            }
        }
        Collections.reverse(answer);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
