package Algorithm.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Robot {

    static int T;
    static int N;
    static String[][] map = new String[21][21];
    static BufferedReader br;
    static StringTokenizer st;
    static int ans = 0;

    static int moveA(int x, int y){ // 오른쪽으로만 이동
        int ret = 0;
        //오른쪽 이동 검사
        if(y+1 < N){
            for(int i = y + 1; i < N; i++){
                if(!map[x][i].equals("S")) break;
                ret++;
            }
        }
        return ret;
    }
    static int moveB(int x, int y){ // 좌우로 이동
        int ret = 0;
        //오른쪽 이동 검사
        ret += moveA(x, y);

        //왼쪽이동검사
        if(y-1 >= 0){
            for(int i = y-1; i>= 0; i--){
                if(!map[x][i].equals("S")) break;
                ret++;
            }
        }
        return ret;
    }
    static int moveC(int x, int y){ // 상하좌우로 이동
        int ret = 0;
        //좌우 검사
        ret += moveB(x, y);

        //아래쪽 검사
        if(x + 1 < N){
            for(int i = x + 1; i < N; i++){
                if(!map[i][y].equals("S")) break;
                ret++;
            }
        }
        //위쪽 검사
        if(x - 1 >= 0){
            for(int i = x - 1; i >= 0; i--){
                if(!map[i][y].equals("S")) break;
                ret++;
            }
        }
        return ret;
    }


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            ans = 0;

            for(int i=0; i<N; i++){
                String line = br.readLine();
                st = new StringTokenizer(line);
                for(int j=0; j<N; j++){
                    map[i][j] = st.nextToken();
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j].equals("A")) {
                        ans += moveA(i, j);
                    }
                    else if(map[i][j].equals("B")) {
                        ans += moveB(i, j);
                    }
                    else if(map[i][j].equals("C")) {
                        ans += moveC(i, j);
                    }
                }
            }

            System.out.println("#" + t + " " + ans);
        }
    }
}
