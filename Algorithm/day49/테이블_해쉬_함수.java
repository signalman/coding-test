package Algorithm.day49;

import java.util.Arrays;

public class 테이블_해쉬_함수 {

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int hash = 0;
        row_begin--;
        row_end--;
        Arrays.sort(data, (d1, d2) -> {
            if(d1[col - 1] == d2[col - 1]) return Integer.compare(d2[0], d1[0]);
            else return Integer.compare(d1[col - 1], d2[col - 1]);
        });

        for(int i=row_begin; i<=row_end; i++){
            int tmp = 0;
            for(int j=0; j<data[0].length; j++){
                tmp += data[i][j] % (i+1);
            }
            hash ^= tmp;
        }
        return hash;
    }
}
