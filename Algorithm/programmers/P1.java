package Algorithm.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


//Comparable 기본 정렬기준 디폴트 정렬 기준.
// -> int compareTo(주어진 객체를 자신과 비교)

//Comparator 기본 정렬기준 외 정렬 기준.
// -> int compare(Obj o1, Obj o2) 0같다. 양수 왼쪽이 큼, 음수: 오른쪽 큼
public class P1 {
    static class Node implements Comparator {
        int x, y;

        @Override
        public int compare(Object o1, Object o2) {
            return 0;
        }

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        String[] str = {"", ""};
        Arrays.sort(str, String.CASE_INSENSITIVE_ORDER);




        return answer;
    }

}
