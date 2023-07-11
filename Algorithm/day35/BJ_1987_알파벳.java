package Algorithm.day35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1987_알파벳 {

    static int R, C;
    static char[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 1;
    static List<Character> record;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for(int i=0; i<R; i++){
            map[i] = br.readLine().toCharArray();
        }
        record = new ArrayList<>();
        record.add(map[0][0]);
        solve(0, 0);
        System.out.println(answer);
    }

    static void solve(int x, int y){

        answer = Math.max(answer, record.size());

        for(int dir = 0; dir < 4; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if(!record.contains(map[nx][ny])) {
                record.add(map[nx][ny]);
                solve(nx, ny);
                record.remove(record.size() - 1);
            }
        }
    }
}

