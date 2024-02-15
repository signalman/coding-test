package Algorithm.day50;

import java.util.PriorityQueue;

public class 디펜스게임 {
    public int solution(int n, int k, int[] enemy) {
        if(k >= enemy.length) return enemy.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<enemy.length; i++){
            if(pq.size() < k){
                pq.add(enemy[i]);
                continue;
            }
            if(pq.peek() > enemy[i]){
                n -= enemy[i];
            }
            else{
                n -= pq.poll();
                pq.add(enemy[i]);
            }
            if(n < 0) return i;
        }
        return enemy.length;
    }
}
