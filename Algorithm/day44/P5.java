package Algorithm.day44;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P5 {

    static int N, C, M;
    static int[] boxes;
    static List<Delivery> infos;
    static class Delivery implements Comparable<Delivery>{
        int from, to, box;
        Delivery(int from, int to, int box) {
            this.from = from;
            this.to = to;
            this.box = box;
        }
        @Override
        public int compareTo(Delivery d){
            return Integer.compare(this.to, d.to);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //집의 개수
        C = Integer.parseInt(st.nextToken()); //트럭의 용량
        M = Integer.parseInt(br.readLine()); //박스의 개수

        infos = new ArrayList<>();
        boxes = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int box = Integer.parseInt(st.nextToken());
            infos.add(new Delivery(from, to, box));
        }
        Collections.sort(infos);

        int ans = 0;
        for (Delivery info : infos) {

            int from = info.from;
            int to = info.to;
            int box = info.box;

            int mx = 0;
            for(int i=from; i<to; i++){
                mx = Math.max(boxes[i], mx);
            }

            int pos = Math.min(C - mx, box);
            ans += pos;
            for (int i = from; i < to; i++) {
                boxes[i] += pos;
            }
        }
        System.out.println(ans);
    }
}
