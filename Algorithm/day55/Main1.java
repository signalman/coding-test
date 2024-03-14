package Algorithm.day55;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main1 {
    class Solution {
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        public int solution(int[][] game_board, int[][] table) {
            int answer = 0;

            //game_board에서 빈칸 모양들 저장
            List<int[][]> emptyShapes = new ArrayList<>();
            boolean[][] visited1 = new boolean[game_board.length][game_board[0].length];
            for(int i=0; i<game_board.length; i++){
                for(int j=0; j<game_board[0].length; j++){
                    if(visited1[i][j] || game_board[i][j] == 1) continue;
                    int[][] shape = bfs(i, j, visited1, game_board, 0);
                    emptyShapes.add(shape);
                }
            }

            List<int[][]> blocks = new ArrayList<>();
            boolean[][] visited2 = new boolean[table.length][table[0].length];
            for(int i=0; i<table.length; i++){
                for(int j=0; j<table[0].length; j++){
                    if(visited2[i][j] || table[i][j] == 0) continue;
                    int[][] block = bfs(i, j, visited2, table, 1);
                    blocks.add(block);
                }
            }

            boolean[] isUsed = new boolean[blocks.size()];

            for(int[][] empty: emptyShapes){

                for(int i=0; i<blocks.size(); i++){
                    if(isUsed[i]) continue;

                    int[][] block = blocks.get(i);
                    int r = 0;
                    boolean flag = false;
                    while(r < 4){
                        block = rotate(block);
                        //todo - 검사
                        if(check(empty, block)) {
                            //todo - 1 개수
                            answer += countZero(empty);
                            flag = true;
                            isUsed[i] = true;
                            break;
                        }
                        r++;
                    }
                    if(flag) break;
                }
            }
            return answer;
        }

        public int[][] rotate(int[][] block){
            int n = block.length;
            int m = block[0].length;
            int[][] rotatedBlock = new int[m][n];

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    rotatedBlock[j][n - 1 - i] = block[i][j];
                }
            }
            return rotatedBlock;
        }

        public int countZero(int[][] array){
            int ret = 0;
            for(int i=0; i<array.length; i++){
                for(int j=0; j<array[0].length; j++){
                    if(array[i][j] == 0) ret++;
                }
            }
            return ret;
        }

        public boolean check(int[][] empty, int[][] block){
            if(empty.length != block.length || empty[0].length != block[0].length) return false;

            for(int i=0; i<empty.length; i++){
                for(int j=0; j<empty[0].length; j++){
                    if((empty[i][j] ^ block[i][j]) != 1) return false;
                }
            }
            return true;
        }

        public int[][] bfs(int x, int y, boolean[][] visited, int[][] board, int target){

            int maxX = x, maxY = y, minX = x, minY = y;

            Queue<int[]> queue = new ArrayDeque<>();
            visited[x][y] = true;
            queue.add(new int[]{x, y});

            while(!queue.isEmpty()){

                int[] cur = queue.poll();

                for(int dir =0; dir < 4; dir++){
                    int nx = cur[0] + dx[dir];
                    int ny = cur[1] + dy[dir];

                    if(nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) continue;
                    if(visited[nx][ny] || board[nx][ny] != target) continue;
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    maxX = Math.max(maxX, nx);
                    maxY = Math.max(maxY, ny);
                    minX = Math.min(minX, nx);
                    minY = Math.min(minY, ny);
                }
            }

            int[][] ret = new int[maxX - minX + 1][maxY - minY + 1];

            for(int i=0; i<ret.length; i++){
                for(int j=0; j<ret[0].length; j++){
                    ret[i][j] = 1 - target;
                    ret[i][j] = board[i + minX][j + minY];
                }
            }
            return ret;
        }

    }
}
