package Algorithm.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Move {
    static int T;
    static int X, Y, N;
    static int[][] map;
    static User[] users;
    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 0, 1, 1, 1, 0, -1, -1, -1};
    static boolean OOB(int x, int y){
        return (x <= 0 || y <= 0 || x > N || y > N);
    }

    static class User{

        int startX;
        int startY;
        int moveCnt;
        User(int startX, int startY, int moveCnt) {
            this.startX = startX;
            this.startY = startY;
            this.moveCnt = moveCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            map = new int[X+2][Y+2];
            for(int i=1; i<=X; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=Y; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            users = new User[N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                users[i] = new User(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            int sumReward = 0;

            for(int i=0; i<N; i++){
                User u = users[i];
                boolean flag = false;
                int reward = 0;

                while(u.moveCnt-- > 0){
                    int number = map[u.startX][u.startY];
                    int dir = number / 10;
                    int cnt = number % 10;

                    u.startX += (dx[dir] * cnt);
                    u.startY += (dy[dir] * cnt);
                    if(OOB(u.startX, u.startY)) {
                        flag = true;
                        break;
                    }
                    System.out.println(u.startX + " " + u.startY);
                }
                if(flag) reward = 0;
                else reward = map[u.startX][u.startY] * 100;
                sumReward += (reward - 1000);
            }
            System.out.println("#" + t + " " +sumReward);
        }
    }
}
