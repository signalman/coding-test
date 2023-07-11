package Algorithm.day37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_2115_벌꿀채취 {
    static int N, M, C;
    static int[][] map;
    static int[] arr;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            arr = new int[2];
            ans = 0;

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            //두개의 벌통 조합을 뽑기
            dfs(0, 0);
            System.out.println("#" + tc + " " + ans);
        }
    }

    private static void dfs(int idx, int st) {

        if(idx == 2){
            int[] worker1 = new int[2];
            int[] worker2 = new int[2];

            worker1[0] = arr[0] / N; //시작행
            worker1[1] = arr[0] % N; //시작열

            worker2[0] = arr[1] / N; //시작행
            worker2[1] = arr[1] % N; //시작열
            
            //조합을 만들 수 없는 경우
            //같은 행에 있고 열이 겹칠때
            if(worker1[0] == worker2[0] && worker1[1] + M - 1 >= worker2[1]) return;
            //열이 범위를 벗어날때
            if(worker1[1] + M - 1>= N || worker2[1] + M - 1 >= N) return;
            List<Integer> candi1 = new ArrayList<>();
            List<Integer> candi2 = new ArrayList<>();
            for(int i=0; i<M; i++){
                candi1.add(map[worker1[0]][worker1[1] + i]);
                candi2.add(map[worker2[0]][worker2[1] + i]);
            }

            boolean[] isSelcted1 = new boolean[M];
            boolean[] isSelcted2 = new boolean[M];

            select1(0, isSelcted1, isSelcted2, candi1, candi2);
            return;
        }

        for(int i=st; i<N*N; i++){
            arr[idx] = i;
            dfs(idx + 1, i + 1);
        }
    }

    private static void select1(int idx, boolean[] isSelcted1, boolean[] isSelcted2, List<Integer> candi1, List<Integer> candi2) {

        if(idx == M){
            select2(0, isSelcted1, isSelcted2, candi1, candi2);
            return;
        }

        isSelcted1[idx] = true;
        select1(idx + 1, isSelcted1, isSelcted2, candi1, candi2);
        isSelcted1[idx] = false;
        select1(idx + 1, isSelcted1, isSelcted2, candi1, candi2);
    }

    private static void select2(int idx, boolean[] isSelcted1, boolean[] isSelcted2, List<Integer> candi1, List<Integer> candi2) {

        if(idx == M){
            int ret = 0;
            int sum1 = 0;
            int sum2 = 0;
            for(int i=0; i<M; i++){
                if(isSelcted1[i]){
                    ret += (candi1.get(i) * candi1.get(i));
                    sum1 += candi1.get(i);
                }
                if(isSelcted2[i]){
                    ret += (candi2.get(i) * candi2.get(i));
                    sum2 += candi2.get(i);
                }
                if(sum1 > C || sum2 > C) return;
            }
            ans = Math.max(ans, ret);
            return;
        }
        isSelcted2[idx] = true;
        select2(idx + 1, isSelcted1, isSelcted2, candi1, candi2);
        isSelcted2[idx] = false;
        select2(idx + 1, isSelcted1, isSelcted2, candi1, candi2);
    }
}
