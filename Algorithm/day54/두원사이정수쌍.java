package Algorithm.day54;

import static java.lang.Math.*;

public class 두원사이정수쌍 {
    class Solution {
        public long solution(int r1, int r2) {
            long answer = 0;
            for(int x = 1; x <= r2; x++){
                int maxY = (int) floor(sqrt((long)r2 * r2 - (long)x * x));
                int minY = (int) ceil(sqrt((long) r1 * r1 - (long) x * x));
                answer += maxY - minY + 1;
            }
            return answer * 4;
        }
    }
}
