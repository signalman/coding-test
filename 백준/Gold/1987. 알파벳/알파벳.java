import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int R, C;
    static char[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 1;
    static ArrayList<Character> list;

    static class Token{
        int x, y;
        List<Character> record;
        Token(int x, int y, List record){
            this.x = x;
            this.y = y;
            this.record = record;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for(int i=0; i<R; i++){
            map[i] = br.readLine().toCharArray();
        }
        list = new ArrayList<>();
        list.add(map[0][0]);
        solve(0, 0);
        System.out.println(answer);
    }

    static void solve(int x, int y){

        answer = Math.max(answer, list.size());

        for(int dir = 0; dir < 4; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if(!list.contains(map[nx][ny])) {
                list.add(map[nx][ny]);
                solve(nx, ny);
                list.remove(list.size() - 1);
            }
        }
    }


//    private static void solve(int x, int y) {
//        Queue<Token> queue = new ArrayDeque<>();
//        Token token = new Token(x, y, new ArrayList<>(Arrays.asList(map[x][y])));
//        queue.add(token);
//
//        while (!queue.isEmpty()) {
//            Token cur = queue.poll();
//
//            for(int dir =0; dir <4; dir++){
//                int nx = cur.x + dx[dir];
//                int ny = cur.y + dy[dir];
//                //Deep copy 해야함
//                List<Character> record = new ArrayList<>();
//                for (Character c : cur.record) {
//                    record.add(c);
//                }
//                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
//                if(isPossible(cur, nx, ny)){
//                    record.add(map[nx][ny]);
//                    queue.add(new Token(nx, ny, record));
//                    answer = Math.max(answer, record.size());
//                }
//            }
//        }
//    }
//
//    private static boolean isPossible(Token cur, int nx, int ny) {
//        return !cur.record.contains(map[nx][ny]);
//    }
}
