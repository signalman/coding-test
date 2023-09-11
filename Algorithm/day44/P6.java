package Algorithm.day44;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P6 {

    static int N, START, END, M;
    static List<int[]>[] transport; //시작 idx -> [목적지, 비용]
    static int[] getMoney;
    static Log[] logs;

    static class Log{
        int curMoney, beforeNode;
        boolean isVisit;
        public Log(){
            this.curMoney = Integer.MIN_VALUE;
            this.beforeNode = -1;
            this.isVisit = false;
        }

        public Log(int curMoney, int beforeNode, boolean isVisit) {
            this.curMoney = curMoney;
            this.beforeNode = beforeNode;
            this.isVisit = isVisit;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        START = Integer.parseInt(st.nextToken());
        END = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        transport = new ArrayList[N];
        for(int i=0; i<N; i++){
            transport[i] = new ArrayList<>();
        }
        getMoney = new int[N];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            transport[start].add(new int[]{end, cost});
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            getMoney[i] = Integer.parseInt(st.nextToken());
        }

        logs = new Log[N];
        for(int i=0; i<N; i++){
            logs[i] = new Log();
        }
        solve();
    }

    private static void solve() {
        //[현재노드, 현재금액]
        Queue<int[]> queue = new ArrayDeque<>();
        logs[START].isVisit = true;
        logs[START].beforeNode = -1;
        logs[START].curMoney = getMoney[0];
        queue.add(new int[]{START, logs[START].curMoney});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curNode = cur[0];
            int curMoney = cur[1];

            for (int[] nxt : transport[cur[0]]) {
                int nxtNode = nxt[0];
                int transportCost = nxt[1];

                if (logs[nxtNode].isVisit) {

                    if (logs[nxtNode].beforeNode == curNode) {
                        if(!logs[END].isVisit) continue;
                        System.out.println("Gee");
                        return;
                    }
                    if(logs[nxtNode].curMoney >= curMoney + getMoney[nxtNode] - transportCost) continue;
                }
                logs[nxtNode].beforeNode = curNode;
                logs[nxtNode].isVisit = true;
                logs[nxtNode].curMoney = curMoney + getMoney[nxtNode] - transportCost;
                queue.add(new int[]{nxtNode, logs[nxtNode].curMoney});
            }
        }
        List<Integer> list = new ArrayList<>();
        int[] a = new int[20];
        list.toArray(list.toArray(new Integer[0]));

        System.out.println(logs[END].isVisit ? logs[END].curMoney : "gg");

    }
}
