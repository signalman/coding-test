package Algorithm.day35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빵집 {

    static int R, C, ans;
    static char[][] map;
    //우상, 우, 우하
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};
    static int st = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for(int i=0; i<R; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < R; i++){ //우상, 우, 우하로 탐색하면 다음 파이프 최댓값 탐색에 영향을 미치지 않음.
            ans += solve(i, 0) ? 1 : 0;
        }
        System.out.println(ans);
    }

    static boolean solve(int r, int c) {

        if(r < 0 || r >= R || c < 0 || c >= C)  return false;
        if(map[r][c] == 'x')  return false;
        if(c == C-1) return true;

        map[r][c] = 'x';

        if(solve(r-1, c+1)) return true;
        else if(solve(r, c+1)) return true;
        else if(solve(r+1, c+1)) return true;
        return false;
    }


}
