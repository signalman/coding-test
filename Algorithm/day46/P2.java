package Algorithm.day46;//재귀로 완전탐색
import java.util.*;
class P2 {
    static int n, m;
    static int[] RED, BLUE; //각 수레의 도착 지점
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] maze;

    public int solution(int[][] maze) {

        n = maze.length;
        m = maze[0].length;
        this.maze = maze;
        int[] red = new int[2], blue = new int[2];
        boolean[][][] visited = new boolean[n][m][2];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(maze[i][j] == 1){
                    red = new int[]{i, j};
                    visited[i][j][0] = true;
                }
                else if(maze[i][j] == 2){
                    blue = new int[]{i, j};
                    visited[i][j][1] = true;
                }
                else if(maze[i][j] == 3){
                    RED = new int[]{i, j};
                }
                else if(maze[i][j] == 4){
                    BLUE = new int[]{i, j};
                }
            }
        }
        int turn = 0;
        //수레 한개 움직이기
        solve(red, blue, visited, 0, 0, 0);
        solve(red, blue, visited, 0, 0, 1);
        if(answer == Integer.MAX_VALUE) return 0;
        return answer;
    }


    void solve(int[] red, int[] blue, boolean[][][] visited, int redVal, int blueVal, int turn){

        //두 수레 모두 도착
        if(Arrays.equals(red,RED) && Arrays.equals(blue, BLUE)){
            int val = Math.max(redVal, blueVal);
            answer = Math.min(answer, val);
            return;
        }

        //빨간색 수레
        if(turn == 0){
            //도착지 도착
            if(Arrays.equals(red, RED)){
                solve(red, blue, visited, redVal, blueVal, turn ^ 1);
            }
            else{
                //빨간 수레 
                for(int dir = 0;  dir < 4; dir++){
                    int nx = red[0] + dx[dir];
                    int ny = red[1] + dy[dir];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    //막혀있거나 방문했거나, blue가 있으면 continue;
                    if(maze[nx][ny] == 5 || visited[nx][ny][0] || (nx == blue[0] && ny == blue[1])) continue;
                    visited[nx][ny][0] = true;
                    solve(new int[]{nx, ny}, blue, visited, redVal + 1, blueVal, turn ^ 1);
                    visited[nx][ny][0] = false;
                }
            }
        }

        //파란색 수레
        else{
            //도착지 도착
            if(Arrays.equals(blue, BLUE)){
                solve(red, blue, visited, redVal, blueVal, (turn + 1) % 2);
            }
            else{
                //파란색 수레 움직이기
                for(int dir = 0;  dir < 4; dir++){
                    int nx = blue[0] + dx[dir];
                    int ny = blue[1] + dy[dir];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    //막혀있거나 방문했거나, red가 있으면 continue;
                    if(maze[nx][ny] == 5 || visited[nx][ny][1] || (nx == red[0] && ny == red[1])) continue;
                    visited[nx][ny][1] = true;
                    solve(red, new int[]{nx, ny}, visited, redVal, blueVal +1, turn ^ 1);
                    visited[nx][ny][1] = false;
                }
            }
        }
    }
}