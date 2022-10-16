package Algorithm.day12;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2 {
    static int testCase;
    final static int MX = 105;
    static int h, w;
    static char[][] board = new char[MX][MX];
    static boolean[][] vis = new boolean[MX][MX];
    static String keyStr;
    static int[] dx = {0, -1, 1, 0,};
    static int[] dy = {-1, 0, 0, 1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer> ret = new ArrayList<>();

    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0){
            Queue<Pair> queue = new LinkedList<>();
            Queue<Pair>[] door = new LinkedList[26];
            int cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            for(int i=0; i<h+2; i++) {
                Arrays.fill(board[i], 0, w + 2, '.');
                Arrays.fill(vis[i], 0, w + 2, false);
            }
            for(int i=1; i<=h; i++){
                String str = br.readLine();
                for(int j=1; j<=w; j++){
                    board[i][j] = str.charAt(j-1);
                }
            }
            keyStr = br.readLine();
            int[] key = new int[26];
            if(!keyStr.equals("0")) {
                for(int i=0; i<keyStr.length(); i++){
                    key[keyStr.charAt(i) - 'a'] = 1;
                }
            }
            vis[0][0] = true;
            queue.offer(new Pair(0, 0));
            for(int i=0; i<26; i++){
                door[i] = new LinkedList<>();
            }
            while (!queue.isEmpty()) {
                Pair cur = queue.poll();
                for(int dir =0; dir < 4; dir++){
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    if(nx < 0 || ny < 0 || nx >= h+2 || ny >= w+2) continue;
                    if(board[nx][ny] == '*' || vis[nx][ny]) continue;
                    vis[nx][ny] = true;

                    //열쇠 발견
                    if(board[nx][ny] >= 'a' && board[nx][ny] <= 'z'){
                        int findKey = board[nx][ny] - 'a';
                        key[findKey] = 1;
                        while(!door[findKey].isEmpty()){
                            Pair ndoor = door[findKey].poll();
                            queue.offer(new Pair(ndoor.x, ndoor.y));
                        }
                    }
                    //문 발견
                    else if(board[nx][ny] >= 'A' && board[nx][ny] <='Z'){
                        //todo
                        int t = board[nx][ny] - 'A';
                        if(key[t] == 0){
                            door[t].offer(new Pair(nx, ny));
                            continue;
                        }
                    }
                    //문서 발견
                    else if(board[nx][ny] == '$'){
                        cnt++;
                    }
                    queue.offer(new Pair(nx, ny));
                }
            }
            ret.add(cnt);
        }

        for (Integer integer : ret) {
            System.out.println(integer);
        }

    }
}
