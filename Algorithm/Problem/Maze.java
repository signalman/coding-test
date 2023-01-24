package Algorithm.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Maze {
    static int T;
    static int N;
    static int[][] map = new int[21][21];
    static int startX, startY;
    static int jumperCnt;
    static int orderCnt;
    static Pair[] order;
    static int[] dx = {0, -1, 0, 1, 0};
    static int[] dy = {0, 0, 1, 0, -1};

    static boolean OOB(int x, int y){
        return (x < 1 || y > N || x > N || y < 1);
    }

    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            N = Integer.parseInt(st.nextToken());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            jumperCnt = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<jumperCnt; i++){
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = -7;
            }
            orderCnt = Integer.parseInt(br.readLine());
            order = new Pair[orderCnt];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<orderCnt; i++){
                order[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            boolean flag = false;
            for(Pair p : order){
                while(p.y-- > 0){
                    startX += dx[p.x];
                    startY += dy[p.x];
                    if(OOB(startX, startY) || map[startX][startY] == -7) {
                        startX = 0;
                        startY = 0;
                        flag = true;
                    }
                    if(flag) break;
                }
                if(flag) break;
            }
            System.out.println("#" + t + " " + startX + " " + startY);
        }

    }


}
