package Algorithm.day56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> hash = new HashMap<>();

        for(int i=0; i<yearning.length; i++){
            hash.put(name[i], yearning[i]);
        }

        for(String[] p: photo){
            int sum = Arrays.stream(p).mapToInt(i -> hash.getOrDefault(i, 0)).sum();
            answer.add(sum);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
