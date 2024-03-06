package Algorithm.day53;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leet {
    public int minimumLength(String s) {

        Deque<Character> deque = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++){
            deque.addLast(s.charAt(i));
        }

        while(deque.peekFirst() == deque.peekLast()){

            Character c = deque.peekFirst();

            while (!deque.isEmpty()) {
                if(deque.peekLast().equals(c)) break;
                deque.pollLast();
            }
            while (!deque.isEmpty()) {
                if(deque.peekFirst() != c) break;
                deque.pollFirst();
            }
        }
        return deque.size();
    }
}
