package day41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1 {

    static int N;
    static List<int[]> balls;
    static class Ball{
        int idx;
        int color;
        int size;

        Ball(int idx, int color, int size) {
            this.idx = idx;
            this.color = color;
            this.size = size;
        }
    }
    static Map<Integer, List<Ball>> map;

    /*
    * 1. (플레이어, 색, 크기)
    * 2. Map에 색깔별 크기순 정렬
    * 3.
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        balls = new ArrayList<>();
        map = new TreeMap<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            balls.add(new int[]{c, s});
            Ball ball = new Ball(i, c, s);
        }



    }
}
