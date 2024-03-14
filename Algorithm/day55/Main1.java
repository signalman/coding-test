package Algorithm.day55;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main1 {
    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, 1, 0, -1};

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;

        //game_board에서 빈칸 모양들 저장
        List<int[][]> emptyShapes = new ArrayList<>();
        List<int[][]> blocks = new ArrayList<>();

        addShape(game_board, emptyShapes);
        addShape(table, blocks);

        boolean[] isUsed = new boolean[blocks.size()];

        for(int[][] empty: emptyShapes){
            if(placeBlock(empty, blocks, isUsed)) {
                answer += countZero(empty);
            }
        }
        return answer;
    }
    public boolean placeBlock(int[][] empty, List<int[][]> blocks, boolean[] isUsed){

        for(int i=0; i<blocks.size(); i++){

            if(isUsed[i]) continue;
            int[][] block = blocks.get(i);

            for(int r = 0; r <= 4; r++){
                block = rotate(block);
                if(check(empty, block)) {
                    isUsed[i] = true;
                    return true;
                }
            }
        }
        return false;
    }

    private void addShape(int[][] board, List<int[][]> candidate) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(visited[i][j] || board[i][j] == 1) continue;
                int[][] shape = bfs(i, j, visited, board, 0);
                candidate.add(shape);
            }
        }
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
