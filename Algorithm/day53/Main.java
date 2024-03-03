package Algorithm.day53;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    int[][] map;
    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, 1, 0, -1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        map = new int[51][51];

        //모든 직사각형 색칠
        for(int[] r: rectangle){
            int x1 = r[0];
            int y1 = r[1];
            int x2 = r[2];
            int y2 = r[3];

            for(int i = x1; i <= x2; i++){
                for(int j = y1; j <= y2; j++){
                    map[i][j] = 1;
                }
            }
        }
        //라인트레이싱 bfs

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[51][51];
        queue.add(new int[]{characterX, characterY, 0});
        visited[characterX][characterY] = true;

        while(!queue.isEmpty()){

            int[] cur = queue.poll();

            if(isInside(cur, map)) continue;
            if(cur[0] == itemX && cur[1] == itemY) return cur[2];
            System.out.println(cur[0] + " "+ cur[1]);

            for(int dir = 0; dir < 4; dir++){
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if(nx < 0 || ny < 0 || nx >= 51 || ny >= 51) continue;
                if(visited[nx][ny] || map[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, cur[0] + 1});
            }
        }
        return -1;
    }
    boolean isInside(int[] cur, int[][] map){
        for(int dir = 0; dir < 4; dir++){
            int nx = cur[0] + dx[dir];
            int ny = cur[1] + dy[dir];
            if(map[nx][ny] == 0) return false;
        }
        return true;
    }
}
