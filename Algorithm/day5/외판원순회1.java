import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 외판원순회1 {

    static int N;
    static int[][] map;
    static int[][] dp;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][(1<<N)+1];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<(1<<N); j++){
                dp[i][j] = INF;
            }
        }

        for(int i=1; i<N; i++){
            dp[i][(1<<i)] = map[0][i];
        }

        for(int j=1; j<N; j++){
            //가려는 노드
            for(int i=1; i<N; i++){
                if(i == j) continue;
                if(map[j][i] == 0) continue;
                for(int k=0; k<(1<<N); k++){
                    //j->i를 구하려하므로 j까지 오지 않은 경우 pass
                    if(dp[j][k] == INF) continue;
                    //이미 i를 방문하고 왔다면 pass
                    if((k & (1<<i)) > 0) continue;
                    dp[i][k | (1<<i)] = Math.min(dp[j][k] + map[j][i], dp[i][k | (1<<i)]);
                    System.out.println("i: " + i + ", j: " + j +", 방문함: " + (k|(1<<i)) +", 답: " + dp[i][k | (1<<i)]);
                }
            }
        }
        int ans = INF;
        for(int i=1; i<N; i++){
            if(dp[i][(1<<N)-2] == INF) continue;
            if(map[i][0] == 0) continue;
            ans = Math.min(dp[i][(1<<N)-2] + map[i][0], ans);
        }
        System.out.println(ans);
        for(int i=0; i<4; i++){
            System.out.println(dp[i][14]+ " ");
        }
    }
}
