package Algorithm.day53;

import java.util.ArrayDeque;
import java.util.Queue;

class Main {
    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, 1, 0, -1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        int[][] map = new int[101][101];
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;

        for(int[] r: rectangle){

            r[0] *= 2;
            r[1] *= 2;
            r[2] *= 2;
            r[3] *= 2;

            for(int x = r[0]; x <= r[2]; x++){
                for(int y = r[1]; y <= r[3]; y++){
                    //라인일때
                    if(x == r[0] || x == r[2] || y == r[1] || y == r[3]) {
                        if(map[x][y] == -1) continue;
                        map[x][y] = 1;
                    }
                    else map[x][y] = -1; //내부 표시
                }
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[101][101];

        queue.add(new int[]{characterX, characterY, 0}); //좌표 이동거리
        visited[characterX][characterY] = true;

        while(!queue.isEmpty()){

            int[] cur = queue.poll();
            if(cur[0] == itemX && cur[1] == itemY) return cur[2] / 2;

            for(int dir = 0; dir < 4; dir++){

                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if(nx < 0 || ny < 0 || nx >= 101 || ny >= 101) continue;
                if(visited[nx][ny] || map[nx][ny] != 1) continue;
                queue.add(new int[]{nx, ny, cur[2] + 1});
                visited[nx][ny] = true;
            }
        }
        return -1;
    }
}