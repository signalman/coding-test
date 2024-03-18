package Algorithm.day55;

import java.util.ArrayList;
import java.util.List;

public class 교점에별만들기 {

    public String[] solution(int[][] line) {
        List<long[]> xys = new ArrayList<>();
        for(int i=0; i<line.length; i++){
            for(int j = i + 1; j < line.length; j++) {
                double[] xy = root(line[i], line[j]);
                if(xy == null) continue;
                if (xy[0] == (long)xy[0] && xy[1] == (long)xy[1])
                    xys.add(new long[]{(long) xy[0], (long) xy[1]});
            }
        }

        long mnX = Integer.MAX_VALUE;
        long mxY = Integer.MIN_VALUE;

        for (long[] xy : xys) {
            if(xy[0] < mnX) mnX = xy[0];
            if(xy[1] > mxY) mxY = xy[1];
        }

        int n = 0, m = 0;
        for (long[] xy : xys) {
            int x = Math.abs((int)(xy[1] - mxY)); //행
            int y = (int)(xy[0] - mnX); //열
            n = Math.max(n, x);
            m = Math.max(m, y);
            xy[0] = x;
            xy[1] = y;
        }
        String[] answer = new String[n + 1];
        char[][] map = new char[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                map[i][j] = '.';
            }
        }
        for (long[] xy : xys) {
            map[(int)xy[0]][(int)xy[1]] = '*';
        }

        for(int i=0; i<n+1; i++){
            answer[i] = String.valueOf(map[i]);
        }
        return answer;
    }

    private double[] root(int[] line1, int[] line2) {

        long a = line1[0], b= line1[1], e = line1[2], c = line2[0], d= line2[1], f = line2[2];
        if((a * d - b * c) == 0) return null;
        return new double[]{(double)(b * f - e * d) / (a * d - b * c), (double)(e * c - a * f) / (a * d - b * c)};
    }
}
