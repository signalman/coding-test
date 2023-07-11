package Algorithm.day17;

import java.util.Scanner;

public class P4 {
    static int N;
    static int eggCount=0;
    static class Egg{
        int weight;
        int dur;
        Egg(){
            weight=0;
            dur=0;
        }
        Egg(int d, int w){
            dur=d;
            weight=w;
        }
    }
    static void dfs(int turn, boolean[] isOk, int c, Egg[] eggs) {
        if (turn == N) {
            eggCount = Math.max(c, eggCount);
            return;
        }
        if (isOk[turn]) {
            dfs(turn + 1, isOk, c, eggs);
        }
        else {
            boolean tempFlag = true;
            for (int i = 0; i < N; i++) {
                if (!isOk[i]) tempFlag = false; // 칠 수 있는 계란이 있다면 false
                if (!isOk[i]&&i!=turn) { // 계란이 깨져있지 않고 같은 계란이 아니라면
                    eggs[i].dur -= eggs[turn].weight;
                    eggs[turn].dur -= eggs[i].weight;
                    int tempCount = 0;
                    if (eggs[turn].dur <= 0) {
                        isOk[turn] = true;
                        tempCount++;
                    }
                    if (eggs[i].dur <= 0) {
                        isOk[i] = true;
                        tempCount++;
                    }
                    dfs(turn + 1, isOk, c+tempCount, eggs); // 쳐보고 넘긴 다음 원래대로 돌린다.
                    if (eggs[turn].dur <= 0) {
                        isOk[turn] = false;
                    }
                    if (eggs[i].dur <= 0) {
                        isOk[i] = false;
                    }
                    eggs[turn].dur += eggs[i].weight;
                    eggs[i].dur += eggs[turn].weight;
                }
            }
            if(!tempFlag) dfs(N, isOk, c, eggs); // 칠 수 있는 계란이 없다는 뜻이므로 바로 종료
        }
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        N=scan.nextInt();
        Egg eggs[]=new Egg[10];
        for(int i=0;i<N;i++) {
            int d=scan.nextInt();
            int w=scan.nextInt();
            eggs[i]=new Egg(d,w);
        }
        boolean isOk[]=new boolean[10];
        dfs(0, isOk, 0, eggs);
        System.out.println(eggCount);
    }
}