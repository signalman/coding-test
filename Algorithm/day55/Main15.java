package Algorithm.day55;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

//boolean[][][][] //visit 4 * 4 * 4 * 4
public class Main15 {

    class Status {
        int r, c;
        int id; //captured character id
        int dist;
        public Status(int r, int c, int id, int dist){
            this.r = r;
            this.c = c;
            this.id = id;
            this.dist = dist;
        }
    }

    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, 1, 0};

    int[][] emptyArray = new int[][]{
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0}
    };


    public int solution(int[][] board, int r, int c) {
        int answer = 0;
        Map<Integer, Boolean> map = new HashMap<>();

        Queue<Status> queue = new ArrayDeque<>();
        int hash = Objects.hash(Arrays.deepHashCode(board), r, c);
        map.put(hash, true);
        queue.add(new Status(r, c, board[r][c], 0));

        while (!queue.isEmpty()) {
            Status cur = queue.poll();
            int x = cur.r;
            int y = cur.c;
            int id = cur.id;
            int dist = cur.dist;

            for(int dir = 0; dir < 4; dir++){
                for (int[] nxt : new int[][]{pressMove(x, y, dir), pressCtrl(x, y, dir, board)}) {

                    int hashVal = Objects.hash(Arrays.deepHashCode(board), nxt[0], nxt[1]);
                    if(map.containsKey(hashVal)) continue;

                    if (id == 0) {
                        //빈칸일 경우
                        if (board[nxt[0]][nxt[1]] == 0)
                            queue.add(new Status(nxt[0], nxt[1], board[nxt[0]][nxt[1]], dist + 1));
                        //인형이 있을 경우 - 엔터까지 쳐야함.
                        else {
                            queue.add(new Status(nxt[0], nxt[1], board[nxt[0]][nxt[1]], dist + 2));
                        }
                        board[nxt[0]][nxt[1]] = 0;
                    } else {
                        //똑같은거 찾음
                        if(board[nxt[0]][nxt[1]] == id){
                            queue.add(new Status(nxt[0], nxt[1], board[nxt[0]][nxt[1]], dist + 2));
                            board[nxt[0]][nxt[1]] = 0;
                        } else{
                            queue.add(new Status(nxt[0], nxt[1], id, dist + 1));
                        }
                    }
                    hashVal = Objects.hash(Arrays.deepHashCode(board), nxt[0], nxt[1]);
                    map.put(hashVal, true);
                }
            }
        }
        return answer;
    }

    int[] pressMove(int r, int c ,int dir){
        int nx = r + dx[dir];
        int ny = c + dy[dir];
        if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) {
            return new int[]{r, c};
        }
        return new int[]{nx, ny};
    }


    int[] pressCtrl(int r, int c, int dir, int[][] board){

        int nx = r + dx[dir];
        int ny = c + dy[dir];

        while(nx >= 0 && ny >= 0 && nx < 4 && ny < 4){

            r = nx;
            c = ny;
            if(board[r][c] != 0) break;
            nx = r + dx[dir];
            ny = c + dy[dir];
        }
        return new int[]{r, c};
    }


    public static void main(String[] args) {
        Map<int[][], Integer> map = new HashMap<>();
        map.put(new int[][]{{1, 2, 3}, {2, 3, 4}}, 2);
        map.put(new int[][]{{1, 2, 3}, {2, 3, 4}}, 3);

        Map<List<List<Integer>>, Integer> map1 = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(1, 2, 3));
        list.add(List.of(2, 3, 4));
        map1.put(list, 2);

        List<List<Integer>> list1 = new ArrayList<>();
        list1.add(List.of(1, 2, 3));
        list1.add(List.of(2, 3, 4));
        map1.put(list1, 2);

        System.out.println(map1.keySet());
        int hash = Objects.hash(list, 2, 3);
        int hash1 = Objects.hash(list1, 2, 3);
        System.out.println(hash1 == hash);
        int i1 = Arrays.deepHashCode(new int[][]{{1, 2, 3}, {2, 3, 4}});
        int i = Arrays.deepHashCode(new int[][]{{1, 2, 3}, {2, 3, 4}});
        System.out.println(i1 == i);

//        Main15 main15 = new Main15();
//        System.out.println(main15.solution(new int[][]{{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}}, 1, 0));
//        System.out.println(main15.solution(new int[][]{{3,0,0,2}, {0,0,1,0},{0,1,0,0}, {2,0,0,3}}, 0, 1));
    }
}
