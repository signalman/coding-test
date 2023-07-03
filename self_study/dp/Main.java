package self_study.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//딸, 초, 바, 딸

//dp[i][j][k][l] : i,j의 음식점에서 먹고/안먹고  마지막먹은 아이스크림[l]
public class Main {
    static int dy[] = { 1, 0 };
    static int dx[] = { 0, 1 };
    static int[][] V;
    static int[][][] DP;
    static int N;
    static int solve(int x, int y, int milk){
        int ret = DP[x][y][milk + 1];
        if(ret != -1) return ret;
        ret = 0;

        for(int dir = 0; dir < 2; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (V[nx][ny] == (milk + 1) % 3) {
                ret = Math.max(ret, solve(nx, ny, (milk + 1) % 3) + 1);
            }
            ret = Math.max(ret, solve(nx, ny, milk));
        }
//        DP[x][y][milk] = ret;
        return ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        V = new int[N][N];
        DP = new int[N][N][4];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                V[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        init();
        int ans = V[0][0] == 0 ? solve(0, 0, 0) + 1 : solve(0, 0, -1);
        System.out.println(ans);
    }

    private static void init() {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<4; k++){
                    DP[i][j][k] = -1;
                }
            }
        }
    }
}
