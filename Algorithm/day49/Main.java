package Algorithm.day49;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        String[][] arrays = new String[][]{{"first", "second"}, {"third", "forth"}, {"fifth", "sixth"}};

        String[] naturalOrder = new String[]{"hello", "my", "name", "is", "HOIN"};


        Arrays.sort(arrays, Comparator.comparing(s -> s[1]));
        for (String[] array : arrays) {
            System.out.println(List.of(array));
        }

        for (String s : naturalOrder) {
            System.out.println(s);
        }


    }
    class Solution {

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        public int[] solution(String[] maps) {
            List<Integer> answer = new ArrayList<>();

            char[][] map = new char[maps.length][maps[0].length()];
            boolean[][] visited = new boolean[maps.length][maps[0].length()];
            for(int i=0; i<maps.length; i++){
                map[i] = maps[i].toCharArray();
            }

            for(int i=0; i<map.length; i++){
                for(int j=0; j<map[0].length; j++){
                    if(visited[i][j] || map[i][j] == 'X') continue;
                    answer.add(bfs(i, j, map, visited));
                }
            }
            if(answer.isEmpty()) answer.add(-1);
            return answer.stream().sorted().mapToInt(i -> i).toArray();
        }

        int bfs(int x, int y, char[][] map, boolean[][] visited){

            int ret = map[x][y] - '0';
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{x, y});
            visited[x][y] = true;

            while(!queue.isEmpty()){

                int[] cur = queue.poll();

                for(int dir = 0; dir < 4; dir++){

                    int nx = cur[0] + dx[dir];
                    int ny = cur[1] + dy[dir];

                    if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;
                    if(visited[nx][ny] || map[nx][ny] == 'X') continue;
                    ret += map[nx][ny] -'0';
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
            return ret;
        }
    }
}
