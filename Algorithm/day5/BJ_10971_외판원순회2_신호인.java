import java.io.*;
import java.util.*;

public class BJ_10971_외판원순회2_신호인 {

    static int N;
    static int[][] map;
    static int[] arr;
    static boolean[] vis;
    static int ans = Integer.MAX_VALUE;

    static void solve(int idx){

        if(idx >= N){
            int ret = 0;
            for(int i=0; i<arr.length; i++){
                if(i < arr.length - 1){
                    if(map[arr[i]][arr[i+1]] == 0) return;
                    ret += map[arr[i]][arr[i+1]];
                } else{
                    if(map[arr[i]][arr[0]] == 0) return;
                    ret += map[arr[i]][arr[0]];
                }
            }
            ans = Math.min(ans, ret);
            return;
        }
        for(int i=0; i<N; i++){
            if(vis[i]) continue;
            arr[idx] = i;
            vis[i] = true;
            solve(idx + 1);
            vis[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        arr = new int[N];
        vis = new boolean[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0);
        System.out.println(ans);
    }
}
