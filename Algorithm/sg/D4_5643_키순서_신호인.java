package Algorithm.sg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
정점 자신에서 outDegree + inDegree = n-1
 */
public class D4_5643_키순서_신호인 {

    static int N, M;
    static int T;
    static List<Integer>[] order, reverse;
    static int[] visit1, visit2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            order = new List[N+1];
            reverse = new List[N+1];
            for(int i=0; i<N+1; i++){
                order[i] = new ArrayList<>();
                reverse[i] = new ArrayList<>();
            }

            //순서 입력받기
            for(int i=0; i<M; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                order[a].add(b);
                reverse[b].add(a);
            }

            visit1 = new int[N+1];
            visit2 = new int[N+1];

            int[] outdegree = new int[N+1];
            int[] indegree = new int[N+1];
            Queue<Integer> queue1 = new ArrayDeque<>();
            Queue<Integer> queue2 = new ArrayDeque<>();

            for(int i=1; i<=N; i++){
                queue1.add(i);
                queue2.add(i);

                Arrays.fill(visit1, 0);
                Arrays.fill(visit2, 0);
                visit1[i] = 1;

                int cnt1 = 0, cnt2 = 0;
                while (!queue1.isEmpty()) {
                    Integer cur = queue1.poll();

                    for(int nxt: order[cur]){
                        if(visit1[nxt] == 1) continue;
                        cnt1++;
                        queue1.add(nxt);
                        visit1[nxt] = 1;
                    }

                }
                while(!queue2.isEmpty()){
                    Integer cur = queue2.poll();

                    for(int nxt: reverse[cur]){
                        if(visit2[nxt] == 1) continue;
                        cnt2++;
                        queue2.add(nxt);
                        visit2[nxt] = 1;
                    }
                }
                outdegree[i] = cnt1;
                indegree[i] = cnt2;
            }

            int ans = 0;
            for(int i=1; i<=N; i++){
                if(outdegree[i] + indegree[i] == N - 1) ans++;
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}
