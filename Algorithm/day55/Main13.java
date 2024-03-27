package Algorithm.day55;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;


class Main13 {

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for(int i=0; i<numbers.length; i++){
            String binary = Long.toString(numbers[i], 2);
            int target = findMinPower(binary.length());
            String satBinary = "0".repeat(target - 1 - binary.length()) + binary;
            answer[i] = solve(satBinary) ? 1 : 0;
        }
        return answer;
    }

    boolean solve(String binary){
        int[][] child = new int[binary.length()][2];
        dfs(0, binary.length() - 1, child);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add((binary.length() - 1) / 2);
        // System.out.println(Arrays.deepToString(child));

        while(!queue.isEmpty()){

            int parent = queue.poll();
            if(Arrays.equals(child[parent], new int[]{0, 0})) continue;

            int left = child[parent][0];
            int right = child[parent][1];
            if(binary.charAt(parent) == '0' && (binary.charAt(left) == '1' || binary.charAt(right) == '1')) return false;
            queue.add(left);
            queue.add(right);
        }
        return true;
    }

    int dfs(int start, int end, int[][] child){

        if(start == end){
            return start;
        }

        int parent = (start + end) / 2;
        child[parent][0] = dfs(start, parent - 1, child);
        child[parent][1] = dfs(parent + 1, end, child);
        return parent;
    }


    int findMinPower(int len){
        int x = 1;
        while(x <= len){
            x *= 2;
        }
        return x;
    }
}
