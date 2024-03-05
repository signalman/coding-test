package Algorithm.day53;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Problem {

    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, 1, 0, -1};

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;

        List<int[][]> emptySpace = findBlocks(game_board, 0);
        List<int[][]> blocks = findBlocks(table, 1);

        boolean[] visited = new boolean[emptySpace.size()];

        for (int[][] block : blocks) {
            int[][] _block = new int[block.length][block[0].length];
            for(int i=0; i<block.length; i++) _block[i] = block[i].clone();

            boolean filled = false;

            for(int r = 0; r < 4 && !filled; r++){
                _block = rotate(_block);

                for(int i=0; i<emptySpace.size(); i++){
                    if(visited[i]) continue;
                    if(isFit(emptySpace.get(i), _block)){
                        visited[i] = true;
                        answer += countBlocks(_block);
                        filled = true;
                        break;
                    }
                }
            }
        }
        return answer;
    }

    int countBlocks(int[][] block){
        int count = 0;
        for(int i=0; i<block.length; i++){
            for(int j=0; j<block[0].length; j++){
                if(block[i][j] == 1) count++;
            }
        }
        return count;
    }


    public boolean isFit(int[][] board, int[][] block){

        if(!(board.length == block.length && board[0].length == block[0].length)) return false;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if((board[i][j]^block[i][j]) == 0) return false;
            }
        }
        return true;
    }

    private List<int[][]> findBlocks(int[][] board, int value) {

        List<int[][]> blocks = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(visited[i][j]) continue;
                if(board[i][j] == value) {

                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;

                    int minX = i, minY = j, maxX= i, maxY = j;

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();

                        for(int dir = 0; dir < 4; dir++){
                            int nx = cur[0] + dx[dir];
                            int ny = cur[1] + dy[dir];

                            if(nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) continue;
                            if(visited[nx][ny] || board[nx][ny] != value) continue;
                            queue.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                            minX = Math.min(minX, nx);
                            minY = Math.min(minY, ny);
                            maxX = Math.max(maxX, nx);
                            maxY = Math.max(maxY, ny);
                        }
                    }

                    int[][] block = new int[maxX - minX + 1][maxY - minY + 1];
                    for(int r = minX; r <= maxX; r++){
                        for(int c = minY; c <= maxY; c++){
                            block[r-minX][c-minY] = board[r][c];
                        }
                    }
                    blocks.add(block);
                }
            }
        }
        return blocks;
    }

    public int[][] rotate(int[][] block){
        int row = block.length;
        int col = block[0].length;
        int[][] rotatedBlock = new int[col][row];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                rotatedBlock[j][row - 1 - i] = block[i][j];
            }
        }
        return rotatedBlock;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2}, {2, 3}};
        int[][] clone = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            clone[i] = array[i].clone();
        }
        array[0][0] = 2;
    }
}
