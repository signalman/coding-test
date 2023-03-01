package Algorithm.day35;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_15683_감시_신호인 {

    static int N, M;
    static char[][] map;
    static ArrayList<int[]> cctv; //cctv 좌표 저장
    //하, 좌, 상, 우
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        cctv = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if(map[i][j] != '0' && map[i][j] != '6') cctv.add(new int[] {i, j});
            }
        }

        //모든 경우의수 구하기
        for(int brute = 0; brute < (1<<2*cctv.size()); brute++) {

            int tmp = brute;
            //cctv별 방향 저장
            int[] quarter = new int[cctv.size()];

            for(int i=cctv.size()-1; i>=0; i--) {
                int d = tmp % 4;
                quarter[i] = d;
                tmp /= 4;
            }
            solve(quarter);
        }
        System.out.println(answer);
    }

    private static void solve(int[] quarter) {

        //이번에 사용할 맵
        char[][] _map = new char[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                _map[i][j] = map[i][j];
            }
        }

        //각 cctv별 감시 위치 파악
        for(int i=0; i<cctv.size(); i++) {

            int dir = quarter[i];
            int x = cctv.get(i)[0];
            int y = cctv.get(i)[1];

            switch(_map[x][y]) {
                case '1':
                    watch1(x, y, dir, _map);
                    break;
                case '2':
                    watch1(x, y, dir, _map);
                    watch1(x, y, (dir + 2) % 4, _map);
                    break;

                case '3':
                    watch1(x, y, dir, _map);
                    watch1(x, y, (dir + 1) % 4, _map);
                    break;

                case '4':
                    watch1(x, y, dir, _map);
                    watch1(x, y, (dir + 1) % 4, _map);
                    watch1(x, y, (dir + 3) % 4, _map);
                    break;

                case '5':
                    watch1(x, y, dir, _map);
                    watch1(x, y, (dir + 1) % 4, _map);
                    watch1(x, y, (dir + 2) % 4, _map);
                    watch1(x, y, (dir + 3) % 4, _map);
                    break;
            }
        }

        //사각지대 개수
        int cnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(_map[i][j] == '0') cnt++;
            }
        }
        answer = Math.min(answer, cnt);
    }

    static void watch1(int x, int y, int dir, char[][] _map) {

        while(true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) break;
            if(_map[nx][ny] == '6') break;
            if(_map[nx][ny] == '0'){
                _map[nx][ny] = '7';
            }
            x = nx;
            y = ny;
        }
    }
}
