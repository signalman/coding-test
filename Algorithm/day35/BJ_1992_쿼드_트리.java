package Algorithm.day35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1992_쿼드_트리 {
    static int N;
    static String[] map;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new String[N];
        for(int i=0; i<N; i++){
            map[i] = br.readLine();
        }
        solve(0, 0, N);
        System.out.println(sb);
    }

    private static void solve(int r, int c, int size) {
        if(isFill(r, c, size) == -1){
            sb.append("(");
            //재귀 호출
            int half = size / 2;
            solve(r, c, half);
            solve(r , c + half, half);
            solve(r + half, c , half);
            solve(r + half, c + half, half);
            sb.append(")");
        }
        else {
            sb.append(isFill(r, c, size));
        }
    }

    static int isFill(int r, int c, int size){ //0으로 찼으면 0, 1로 찼으면 1, 둘다아니면 -1

        int val = map[r].charAt(c);

        for(int i=r; i<r+size; i++){
            for(int j=c; j<c+size; j++){
                if(map[i].charAt(j) != val){
                    return -1;
                }
            }
        }
        return val - '0';
    }
}
