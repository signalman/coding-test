package Algorithm.day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P3 {
    static int N;
    static Egg[] eggs;
    static int ret=0;
    static class Egg{
        int dur;
        int weight;
        Egg(int a, int b){
            this.dur = a;
            this.weight = b;
        }
    }
    static void crash(Egg e1, Egg e2) {
        e1.dur -= e2.weight;
        e2.dur -= e1.weight;
    }

    static void crashBack(Egg e1, Egg e2) {
        e1.dur += e2.weight;
        e2.dur += e1.weight;
    }

    public static void main(String[] args) throws IOException { //내구도와 무게

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];
        for(int i=0; i< N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) );
        }
        dfs(0);
        System.out.println(ret);

    }

    static void dfs(int idx) {
        if (idx >= N) { // 다 돌았을 때
            int cnt = 0;
            for(int i=0; i<N; i++){
                if(eggs[i].dur <= 0) cnt++;
            }
//            System.out.println("깨진 계란의 개수는: " + cnt);
            ret = Math.max(ret, cnt);
            return;
        }
        if(eggs[idx].dur <= 0) { //손에 든 계란이 깨졌거나
            dfs(idx + 1);
            return;
        }
        //
        if(Arrays.stream(eggs).filter(i -> i.dur >= 0).count() < 2){
            dfs(idx + 1);
            return;
        }
//        boolean flag = false;// 깨지지 않은 다른 계란이 없으면 넘어간다.
//        for(int i=0; i<N; i++){
//            if(idx == i) continue;
//            if(eggs[i].dur < 0) continue;
//            else{
//                flag = true;
//            }
//        }
//        if(!flag) {
//            dfs(idx + 1);
//            return;
//        }
//        Arrays.stream(eggs).filter(i -> i.dur>=0).count()
        for(int i=0; i<N; i++){
            if(eggs[i].dur <= 0 || i == idx) continue;   //내구성이 0이거나 현재 들고있는 계란일 경우
            crash(eggs[idx], eggs[i]);
//            System.out.println(idx + "번 계란과 " + i +"번 계란이 crush!! " +idx+ "번 계란의 내구도: " + eggs[idx].dur+" " + i+ "번 계란의 내구도: "+ eggs[i].dur);
            dfs(idx + 1);
            crashBack(eggs[idx], eggs[i]);
//            System.out.println(idx + "번 계란과 " + i +"번 계란 다시 돌려놓기" );

        }
    }

}
