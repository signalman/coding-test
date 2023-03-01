//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Solution {
//
//    static int[][] magnet;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int T = Integer.parseInt(br.readLine());
//
//        for (int tc = 1; tc <= T; tc++) {
//
//            int K = Integer.parseInt(br.readLine());
//
//            magnet = new int[4][8];
//            for(int i=0; i<4; i++){
//                st = new StringTokenizer(br.readLine());
//                for(int j=0; j<8; j++){
//                    magnet[i][j] = Integer.parseInt(st.nextToken());
//                }
//            }
//
//            for(int i=0; i<K; i++){
//                st = new StringTokenizer(br.readLine());
//                int idx = Integer.parseInt(st.nextToken());
//                int dir = Integer.parseInt(st.nextToken());
//                idx--;
//                int[] near = new int[3];
//                for(int m = 0; m < 3; m++){
//                    if(magnet[m][2] == magnet[m+1][6]) near[m] = 0; //같은 극이면 0
//                    else near[m] = 1; //다른 극이면 1
//                }
//                solve(idx, dir, near);
//            }
//
//            int ans = 0;
//            ans += (magnet[0][0] + magnet[1][0] * 2 + magnet[2][0] * 4 + magnet[3][0] * 8);
//            System.out.println("#" + tc+ " " + ans);
//        }
//    }
//
//    private static void solve(int idx, int dir, int[] near) {
//        switch(idx){
//            case 0:
//                rot(idx, dir);
//                if(near[0] != 1) break;
//                rot(idx + 1, -dir);
//                if(near[1] != 1) break;
//                rot(idx + 2, dir);
//                if(near[2] != 1) break;
//                rot(idx + 3, -dir);
//                break;
//            case 1:
//                rot(idx, dir);
//                if(near[0] == 1) rot(idx - 1, -dir);
//                if(near[1] != 1) break;
//                rot(idx + 1, -dir);
//                if(near[2] != 1) break;
//                rot(idx + 2, dir);
//                break;
//            case 2:
//                rot(idx, dir);
//                if(near[2] == 1) rot(idx + 1, -dir);
//                if(near[1] != 1) break;
//                rot(idx - 1, -dir);
//                if(near[0] != 1) break;
//                rot(idx - 2, dir);
//                break;
//            case 3:
//                rot(idx, dir);
//                if(near[2] != 1) break;
//                rot(idx - 1, -dir);
//                if(near[1] != 1) break;
//                rot(idx - 2, dir);
//                if(near[0] != 1) break;
//                rot(idx - 3, -dir);
//                break;
//        }
//    }
//
//    //그냥 해당 자석 돌리기
//    private static void rot(int idx, int dir) {
//        //시계
//        if(dir == 1){
//            int tmp = magnet[idx][7];
//            for(int i=6; i>=0; i--){
//                magnet[idx][i+1] = magnet[idx][i];
//            }
//            magnet[idx][0] = tmp;
//        }
//        //반시계
//        else{
//            int tmp = magnet[idx][0];
//            for(int i=0; i<7; i++){
//                magnet[idx][i] = magnet[idx][i+1];
//            }
//            magnet[idx][7] = tmp;
//        }
//    }
//}
