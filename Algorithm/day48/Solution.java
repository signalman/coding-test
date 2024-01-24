package Algorithm.day48;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
class Solution {
    static int[][] map = new int[11][11];
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    public int solution(String dirs) {
        int x = 5, y = 5;
        Set<List<Integer>> set = new HashSet<>();

        for(int i = 0; i<dirs.length(); i++){
            char c = dirs.charAt(i);
            int nx = 0, ny = 0;
            switch(c){
                case 'U':
                    nx = x + dx[0];
                    ny = y + dy[0];
                    break;
                case 'D':
                    nx = x + dx[1];
                    ny = y + dy[1];
                    break;
                case 'R':
                    nx = x + dx[2];
                    ny = y + dy[2];
                    break;
                case 'L':
                    nx = x + dx[3];
                    ny = y + dy[3];
                    break;
            }
            if(nx < 0 || ny < 0 || nx >= 11 || ny>= 11) continue;
            set.add(Arrays.asList(x, y, nx, ny));
            set.add(Arrays.asList(nx, ny, x, y));
            x = nx;
            y = ny;
        }
        return set.size() / 2;
    }
}
