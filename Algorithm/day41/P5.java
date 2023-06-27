package Algorithm.day41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P5 {
    static int N;
    static List<int[]> lecture;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lecture = new ArrayList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            lecture.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        Collections.sort(lecture, (o1, o2) -> {
            if(o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o1[0], o2[0]);
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(); //강의 끝나는 min힙
        pq.add(lecture.get(0)[1]);

        for(int i=1; i<N; i++){
            //강의 중일 경우
            Integer cur = pq.peek();
            if(cur <= lecture.get(i)[0]) pq.poll();
            pq.add(lecture.get(i)[1]);
        }
        System.out.println(pq.size());
    }
}
