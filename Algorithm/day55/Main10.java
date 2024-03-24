package Algorithm.day55;

import java.util.Stack;
import java.util.stream.Collectors;

public class Main10 {

    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        int len = number.length() - k;

        for(char c: number.toCharArray()){
            int num = c - '0';
            while(!stack.isEmpty() && stack.peek() < num && k > 0){
                stack.pop();
                k--;
            }
            stack.push(num);
        }
        return stack.subList(0, len).stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
    }
}
