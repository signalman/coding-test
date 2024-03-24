package Algorithm.day55;

import java.util.Stack;

public class 큰수만들기 {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Integer> st = new Stack<>();

        for(char c: number.toCharArray()){
            int num = c - '0';
            while(!st.isEmpty() && st.peek() < num && k > 0){
                st.pop();
                k--;
            }
            st.push(num);
        }
        while(!st.isEmpty()){
            while(st.size() > number.length() - k){
                st.pop();
            }
            int num = st.pop();
            answer =  num + answer;
        }

        return answer;
    }
}
