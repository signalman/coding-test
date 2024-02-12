package Algorithm.day49;

import java.util.ArrayDeque;
import java.util.Queue;

public class 리코쳇게임 {
    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, 1, 0, -1};
    int n, m;

    public int solution(String[] board) {
        int answer = -1;

        int[] start = new int[2];
        n = board.length;
        m = board[0].length();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length(); j++){
                if(board[i].charAt(j) == 'R'){
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        visited[start[0]][start[1]] = true;
        queue.add(new int[]{start[0], start[1], 0});

        while(!queue.isEmpty()){

            int[] cur = queue.poll();
            if(board[cur[0]].charAt(cur[1]) == 'G') return cur[2];

            for(int dir = 0; dir < 4; dir++){
                int x = cur[0];
                int y = cur[1];
                while(true){
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if(!inRange(nx, ny) || board[nx].charAt(ny) == 'D') break;
                    x = nx;
                    y = ny;
                }
                if(visited[x][y]) continue;
                visited[x][y] = true;
                queue.add(new int[]{x, y, cur[2] + 1});
            }
        }

        return answer;
    }

    boolean inRange(int x, int y){
        return x >= 0 && y >= 0 && x < n && y < m;
    }

}
