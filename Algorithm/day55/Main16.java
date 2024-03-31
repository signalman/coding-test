package Algorithm.day55;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main16 {

    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, 1, 0, -1};
    int[][] emptyArray = new int[][]{
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0}
    };

    int answer = Integer.MAX_VALUE;
    public int solution(int[][] board, int r, int c) {
        Map<Integer, Boolean> visited = new HashMap<>();
        int item = board[r][c];
        board[r][c] = 0;
        int hash = Objects.hash(Arrays.deepHashCode(board), r, c);
        visited.put(hash, true);
        if(item != 0){
            dfs(board, r, c, item, 1, visited);
        } else{
            dfs(board, r, c, item, 0, visited);
        }
        return answer;
    }

    void dfs(int[][] board, int r, int c, int captured, int count, Map<Integer, Boolean> visited){

        if(Arrays.deepEquals(board, emptyArray)) {
            System.out.println(r + " " + c +  " " + Arrays.deepToString(board) +  " " + count);
            answer = Math.min(answer, count);
            return;
        }
//        System.out.println(r + " " + c +  " " + Arrays.deepToString(board) +  " " + count);
        for(int dir = 0; dir < 4; dir++){
            for (int[] nxt : new int[][]{pressMove(r, c, dir), pressCtrl(r, c, dir, board)}) {
                int hash = Objects.hash(Arrays.deepHashCode(board), nxt[0], nxt[1]);
                if(visited.containsKey(hash)) continue;

                int item = board[nxt[0]][nxt[1]];
                //아직 처음 선택 x
                if(captured == 0){
                    //다음 칸이 캐릭터일때
                    if(item != 0){
                        board[nxt[0]][nxt[1]] = 0;
                        visited.put(Objects.hash(Arrays.deepHashCode(board), nxt[0], nxt[1]), true);
                        dfs(board, nxt[0], nxt[1], item, count + 2, visited);
                        board[nxt[0]][nxt[1]] = item;
                    }
                    else{
                        visited.put(Objects.hash(Arrays.deepHashCode(board), nxt[0], nxt[1]), true);
                        dfs(board, nxt[0], nxt[1], captured, count + 1, visited);
                    }
                }
                //하나 찍었을 때 captured 가 0이 아님
                else{
                    //만족하는 거 찾음
                    if(item == captured){
                        board[nxt[0]][nxt[1]] = 0;
                        visited.put(Objects.hash(Arrays.deepHashCode(board), nxt[0], nxt[1]), true);
                        dfs(board, nxt[0], nxt[1], 0, count + 2, visited);
                        board[nxt[0]][nxt[1]] = item;
                    }
                    else{
                        visited.put(Objects.hash(Arrays.deepHashCode(board), nxt[0], nxt[1]), true);
                        dfs(board, nxt[0], nxt[1], captured, count + 1, visited);
                    }
                }
            }
        }
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

        Main16 main16 = new Main16();
        System.out.println(main16.solution(new int[][]{{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}}, 1, 0));
//        System.out.println(main16.solution(new int[][]{{3,0,0,2}, {0,0,1,0},{0,1,0,0}, {2,0,0,3}}, 0, 1));
    }
}
