package Algorithm.day56;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main3 {
    public int[] solution(String s) {
        List<Integer> answer = new ArrayList<>();
        Map<Character, Integer> hash = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(hash.containsKey(c)) {
                answer.add(i - hash.get(c));
            }
            else answer.add(-1);
            hash.put(c, i);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
