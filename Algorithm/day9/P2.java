package Algorithm.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P2{
    static int N, M, P;
    static int[] step = new int[10];
    static boolean[][] canExtend = new boolean[1001][1001];
    static ArrayList<LinkedList<Tuple>> q = new ArrayList<>(11);
    static int[] area = new int[11];
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    static class Tuple{
        int x,y,z;
        Tuple(int x, int y, int z){
            this.x =x;
            this.y = y;
            this.z = z;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=P; i++){
            step[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=P+1; i++){
            q.add(new LinkedList<>());
        }

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                char ch = str.charAt(j);
                if(ch == '.') canExtend[i][j] = true;
                else if(ch == '#') canExtend[i][j] = false;
                else{
                    canExtend[i][j] = false;
                    LinkedList l = q.get(ch-'0');
                    l.offer(new Tuple(i, j, 0));
                    q.set(ch - '0', l);
                    area[ch-'0'] += 1;
                }
            }
        }

        while(true){
            boolean isExtend = false;

            for(int i=1; i<=P; i++){
                LinkedList<Tuple> nq = new LinkedList<>();
                LinkedList<Tuple> cq = q.get(i);
                while(!cq.isEmpty()){
                    Tuple tuple = cq.poll();
                    int cx = tuple.x;
                    int cy = tuple.y;
                    int cz = tuple.z;
                    if(cz >= step[i]){
                        nq.offer(new Tuple(cx, cy, 0));
                        continue;
                    }
                    for(int dir = 0; dir < 4; dir++){
                        int nx = cx + dx[dir];
                        int ny = cy + dy[dir];
                        int nz = cz + 1;
                        if(nx < 0 || ny < 0 || nx >= N || ny >= M)continue;
                        if(canExtend[nx][ny] == false) continue;
                        cq.offer(new Tuple(nx, ny, nz));
                        canExtend[nx][ny] = false;
                        area[i]++;
                        isExtend = true;
                    }
                }
                q.set(i, nq);
            }
            if(!isExtend) break;
        }

        for(int i=1; i<=P; i++){
            System.out.print(area[i] + " ");
        }

    }
}