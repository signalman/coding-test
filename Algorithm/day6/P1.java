package Algorithm.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1 {
    private static int N = 100_002;
    private static int sis;
    private static int bro;
    private static int[] board = new int[N];
    private static int[] fromIdx = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sis = Integer.parseInt(st.nextToken());
        bro = Integer.parseInt(st.nextToken());

        Arrays.fill(board, -1);
        Arrays.fill(fromIdx, 0);
        board[sis] = 0;
        fromIdx[sis] = sis;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(sis);
        while (board[bro] == -1) {
            int cur = queue.poll();
            int[] arr = {cur - 1, cur + 1, cur * 2};
            for (int nx : arr) {
                if(nx < 0 || nx >= N) continue;
                if(board[nx] != -1) continue;
                board[nx] = board[cur] + 1;
                queue.offer(nx);
                fromIdx[nx] = cur;
            }
        }

        System.out.println(board[bro]);
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(bro);
        while(deque.peekFirst() != sis){
            deque.offerFirst(fromIdx[deque.peekFirst()]);
        }
        for (Integer integer : deque) {
            System.out.print(integer  + " ");
        }
    }
}
