package Algorithm.day49;

import java.util.Arrays;

public class 시소짝궁 {

    public long solution(int[] weights) {

        long answer = 0;
        Arrays.sort(weights);

        for(int i=0; i<weights.length; i++){
            int upper = upperBound(weights, i + 1, weights.length, weights[i]);
            int lower = lowerBound(weights, i + 1, weights.length, weights[i]);
            answer += upper - lower;
            for(int dist1 = 2;  dist1 <= 4; dist1++){
                for(int dist2 = dist1 + 1; dist2 <= 4; dist2++){
                    double t= (double)weights[i] * dist2 / dist1;
                    if(t != Math.floor(t)) continue;
                    upper = upperBound(weights, i + 1, weights.length, (int)t);
                    lower = lowerBound(weights, i + 1, weights.length, (int)t);
                    answer += upper - lower;
                }
            }

        }
        return answer;
    }


    public int lowerBound(int[] weights, int start, int end, int target){
        while(start < end){
            int mid = (start + end) / 2;
            if(weights[mid] < target){
                start = mid + 1;
            }
            else end = mid;
        }
        return start;
    }

    public int upperBound(int[] weights, int start, int end, int target){
        while(start < end){
            int mid = (start + end) / 2;
            if(weights[mid] <= target){
                start = mid + 1;
            }
            else end = mid;
        }
        return start;
    }
}
