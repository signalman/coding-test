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


        List<int[][]> emptyBoard = new ArrayList<>();
        List<int[][]> fillTable = new ArrayList<>();

        addEmptyBoard(game_board, emptyBoard);
        addFillTable(table, fillTable);

        boolean[] visited = new boolean[emptyBoard.size()];
        for(int[][] p: fillTable){
            boolean flag = false;
            int[][] rot = p;
            for(int i=0; i<4; i++){
                rot = rotate(rot);

                for(int j=0; j<emptyBoard.size(); j++){
                    if(visited[j]) continue;
                    if(isFit(rot, emptyBoard.get(j))){
                        int cnt = 0;
                        for(int x=0; x<rot.length; x++){
                            for(int y=0; y<rot[0].length; y++){
                                if(rot[x][y] == 1) cnt++;
                            }
                        }
                        answer+= cnt;
                        visited[j] = true;
                        flag = true;
                        break;
                    }
                }
                if(flag) break;
            }
        }
        return answer;
    }

    public boolean isFit(int[][] board, int[][] seg){
        if(!(board.length == seg.length && board[0].length == seg[0].length)) return false;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if((board[i][j]^seg[i][j]) == 0) return false;
            }
        }
        return true;
    }

    int[][] rotate(int[][] array){

        int rows = array.length;
        int cols = array[0].length;
        int[][] rotatedArray = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotatedArray[j][rows - 1 - i] = array[i][j];
            }
        }

        return rotatedArray;

    }

    //table 순회하면서 1이 찾아지면 해당 좌표에서 BFS 로 1이 칠해진 좌표들을 구함
    //해당 좌표에서 x minmax, y minmax 값을 구해 2중 for문으로 2차원배열만들기
    //gameboard에서도 찾아진 0에 대해서 minmax 값으로 2차원 배열 만들어서
    //만들어진 배열을 회전 시켜보면서 game_board에 넣을 수 있는 지 검사. xor사용하면 좋을듯?
    //넣을 수 있다면 넣기

    public void addEmptyBoard(int[][] game_board, List<int[][]> emptyBoard){

        boolean[][] visited = new boolean[51][51];

        for(int i=0; i<game_board.length; i++){
            for(int j=0; j<game_board[0].length; j++){
                if(game_board[i][j] == 1 || visited[i][j]) continue;
                if(game_board[i][j] == 0) BFS(i, j, game_board, visited, emptyBoard, 0);
            }
        }
        // emptyBoard.stream().forEach(i -> System.out.println(Arrays.deepToString(i)));
    }

    public void addFillTable(int[][] table, List<int[][]> fillTable){
        boolean[][] visited = new boolean[51][51];

        for(int i=0; i<table.length; i++){
            for(int j=0; j<table[0].length; j++){
                if(table[i][j] == 0 || visited[i][j]) continue;
                if(table[i][j] == 1) BFS(i, j, table, visited, fillTable, 1);
            }
        }
    }

    public void BFS(int x, int y, int[][] map, boolean[][] visited, List<int[][]> collections, int value){

        int minX = 51;
        int minY = 51;
        int maxX = -1;
        int maxY = -1;

        maxX = Math.max(maxX, x);
        maxY = Math.max(maxY, y);
        minX = Math.min(minX, x);
        minY = Math.min(minY, y);

        Queue<int[]> queue = new ArrayDeque<>();
        visited[x][y] = true;
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()){

            int[] cur = queue.poll();

            for(int dir = 0; dir < 4; dir++){

                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;
                if(visited[nx][ny] || map[nx][ny] != value) continue;
                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
                maxX = Math.max(maxX, nx);
                maxY = Math.max(maxY, ny);
                minX = Math.min(minX, nx);
                minY = Math.min(minY, ny);
            }
        }
        int[][] added = new int[maxX - minX + 1][maxY - minY + 1];
        for(int i=minX; i<=maxX; i++){
            for(int j=minY; j<=maxY; j++){
                added[i-minX][j-minY] = map[i][j];
            }
        }
        collections.add(added);
    }


}
