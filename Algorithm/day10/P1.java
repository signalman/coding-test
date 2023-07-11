package Algorithm.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1 {
    static int[] dz = {0, 0, 0, 0, 1, -1}; //높이
    static int[] dx = {0, 1, -1, 0, 0, 0}; //행
    static int[] dy = {1, 0, 0, -1, 0, 0}; //열
    static char[][][] MAP = new char[31][31][31];
    static int L, R, C;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<String> ret = new ArrayList<>();
    static int tx, ty, tz;
    static class Tuple{
        int z, x, y;
        int dist;
        Tuple(int z, int x, int y){ //높이, 행, 열
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if(L==0&&R==0&&C==0) break;

            Queue<Tuple> queue = new LinkedList<>();
            int dist[][][] = new int[31][31][31];
            for(int i=0; i<L; i++){
                for(int j=0; j<R; j++){
                    String str = br.readLine();
                    for(int k=0; k<C; k++){
                        char ch = str.charAt(k);
                        MAP[i][j][k] = ch;
                        if(ch == 'S'){
                            queue.offer(new Tuple(i, j, k));
                            dist[i][j][k] = 1;
                        }
                        if(ch == 'E'){
                            tz = i;
                            tx = j;
                            ty = k;
                        }
                    }
                }
                br.readLine();
            }
            boolean canEscape = false;
            while(!queue.isEmpty()){
                Tuple t = queue.poll();
                if(t.z == tz && t.x == tx && t.y == ty) {
                    canEscape = true;
                    break;
                }
                for(int dir = 0; dir < 6; dir++){
                    int nz = t.z + dz[dir]; //높이
                    int nx = t.x + dx[dir]; //행
                    int ny = t.y + dy[dir]; //열

                    if(nx < 0 || ny < 0 || nz < 0 || nz >= L || nx >= R || ny >= C) continue;
                    if(MAP[nz][nx][ny] == '#') continue;
                    if(dist[nz][nx][ny] != 0) continue;
                    queue.offer(new Tuple(nz, nx, ny));
                    dist[nz][nx][ny] = dist[t.z][t.x][t.y] + 1;
                }
            }
            if(canEscape) printCanEscape(dist[tz][tx][ty]-1);
            else printCannotEscaped();
        }

        for (String s : ret) {
            System.out.println(s);
        }

    }

    static void printCanEscape(int x){
        String str = "Escaped in " + x + " minute(s).";
        ret.add(str);
    }
    static void printCannotEscaped(){
        ret.add("Trapped!");
    }
}