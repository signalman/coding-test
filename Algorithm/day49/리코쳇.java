package Algorithm.day49;

public class 리코쳇 {
    class Solution {
        static int[] dx = new int[]{1, 0, -1, 0};
        static int[] dy = new int[]{0, 1, 0, -1};
        static boolean[][] visited = new boolean[101][101];

        public int solution(String[] board) {
            int answer = 987654321;
            int x =0, y = 0;

            char[][] map = new char[board.length][board[0].length()];
            for(int i=0; i<map.length; i++){
                for(int j=0; j<map[0].length; j++){
                    map[i][j] = board[i].charAt(j);
                    if(map[i][j] == 'R') {x = i; y = j;}
                }
            }


            for(int i=0; i<4; i++){
                answer = Math.min(answer, minMove(x, y, i, board));
            }


            return answer;
        }

        int minMove(int x, int y, int dir, String[] board){
            if(board[x].charAt(y) == 'G') return 1;
            if(visited[x][y]) return 987654321;
            visited[x][y] = true;
            while(true){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if(nx < 0 || ny < 0 || board[nx].charAt(ny) == 'D') break;
                x = nx;
                y = ny;
            }
            int up = minMove(x, y, 0, board);
            int down = minMove(x, y, 1, board);
            int left = minMove(x, y, 2, board);
            int right = minMove(x, y, 3, board);
            return Math.min(up, Math.min(down, Math.min(left, right))) + 1;
        }

    }
}
