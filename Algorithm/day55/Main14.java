package Algorithm.day55;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//1:11시작
public class Main14 {

    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, 1, 0, -1};
    public int solution(int[][] board, int r, int c) {
        int answer = 0;

        while(!isComplete(board)){

            if(board[r][c] == 0){
                int[] nxt = findCard(board, r, c); //카드가 있는 좌표, 이동 거리
                answer += nxt[2]; //카드까지 가는데 이동 거리
                r = nxt[0];
                c = nxt[1];
            } else {
                answer += findPair(board, r, c);
                answer += 2; //엔터
            }
        }
        return answer;
    }

    boolean isComplete(int[][] board){
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(board[i][j] != 0) return false;
            }
        }
        return true;
    }

    int[] findCard(int[][] board, int r, int c){
        int[][] dist = new int[4][4];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r, c});
        while (!queue.isEmpty()) {

            int[] cur = queue.poll();
            if(board[cur[0]][cur[1]] != 0){
                return new int[]{cur[0], cur[1], dist[cur[0]][cur[1]]};
            }

            for (int[] nxt : nxtStep(board, dist, cur[0], cur[1])) {
                queue.add(new int[]{nxt[0], nxt[1]});
            }
        }

        return null;
    }

    int findPair(int[][] board, int r, int c){

        int card = board[r][c];
        int[][] dist = new int[4][4];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r, c});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if ((cur[0] != r || cur[1] != c) && board[cur[0]][cur[1]] == card) {
                board[cur[0]][cur[1]] = 0;
                board[r][c] = 0;
                return dist[cur[0]][cur[1]];
            }
            for (int[] nxt : nxtStep(board, dist, cur[0], cur[1])) {
                queue.add(new int[]{nxt[0], nxt[1]});
            }
        }
        return -1;
    }

    List<int[]> nxtStep(int[][] board, int[][] dist, int r, int c){
        List<int[]> ret = new ArrayList<>();

        for(int dir = 0; dir < 4; dir++){
            int nx = r + dx[dir];
            int ny = c + dy[dir];
            if(nx < 0 || ny < 0 || nx >= 4 || ny >= 4) continue;
            if(dist[nx][ny] != 0) continue;
            ret.add(new int[]{nx, ny});
            dist[nx][ny] = dist[r][c] + 1;
        }

        for(int dir = 0; dir < 4; dir++){

            int nx = r + dx[dir];
            int ny = c + dy[dir];

            while(true){
                if(nx < 0 || ny < 0 || nx >= 4 || ny >= 4) {
                    nx -= dx[dir];
                    ny -= dy[dir];
                    break;
                }
                if(board[nx][ny] != 0) break;
                nx += dx[dir];
                ny += dy[dir];
            }
            if(dist[nx][ny] != 0) continue;
            ret.add(new int[]{nx, ny});
        }

        return ret;
    }
}
