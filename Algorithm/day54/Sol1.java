package Algorithm.day54;

import static java.lang.Math.max;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Sol1 {

    //genreCount -> HashMap
    //
    public class Node{
        int index;
        int plays;
        public Node(int index, int plays){
            this.index = index;
            this.plays = plays;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreCount = new HashMap<>();
        Map<String, PriorityQueue<Node>> genreByTop2 = new HashMap<>();

        for(int i=0; i<plays.length; i++){
            genreCount.put(genres[i], genreCount.getOrDefault(genres[i], 0) + plays[i]);
            if (genreByTop2.containsKey(genres[i])) {
                genreByTop2.get(genres[i])
                           .add(new Node(i, plays[i]));
            } else {
                genreByTop2.put(genres[i], new PriorityQueue<>((n1, n2) ->{
                    if (n1.plays == n2.plays) {
                        return Integer.compare(n1.index, n2.index);
                    }
                    else{
                        return Integer.compare(n2.plays, n1.plays);
                    }
                }));
                genreByTop2.get(genres[i])
                           .add(new Node(i, plays[i]));
            }

        }
        List<String> collect = genreCount.keySet()
                                         .stream()
                                         .sorted((k1, k2) -> Integer.compare(genreCount.get(k2),
                                             genreCount.get(k1)))
                                         .collect(
                                             Collectors.toList());

        List<Integer> answer = new ArrayList<>();
        for (String genre : collect) {
            PriorityQueue<Node> pq = genreByTop2.get(genre);
            int times = 0;
            while(!pq.isEmpty() && times < 2){
                answer.add(pq.poll().index);
                times++;
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int num = -123;
        num = num * max(1,3);
        System.out.println(num);
    }
}
