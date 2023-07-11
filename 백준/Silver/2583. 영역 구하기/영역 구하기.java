//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//
//    static int M, N, K;
//    static int[][] map;
//    static List<Integer> answer;
//    static int[] dx = {1, -1, 0, 0};
//    static int[] dy = {0, 0, -1, 1};
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        M = Integer.parseInt(st.nextToken());
//        N = Integer.parseInt(st.nextToken());
//        K = Integer.parseInt(st.nextToken());
//        map = new int[N][M];
//
//        while(K-- > 0){
//            int[] nums = new int[4];
//            st = new StringTokenizer(br.readLine());
//            for(int i=0; i<4; i++){
//                nums[i] = Integer.parseInt(st.nextToken());
//            }
//            for(int i=nums[0]; i<nums[2]; i++){
//                for(int j=nums[1]; j<nums[3]; j++){
//                    map[i][j] = 1;
//                }
//            }
//        }
//
//        answer = new ArrayList<>();
//        bfs();
//        Collections.sort(answer);
//        System.out.println(answer.size());
//        for (Integer i : answer) {
//            System.out.print(i + " ");
//        }
//    }
//
//    private static void bfs() {
//        Queue<int[]> queue = new ArrayDeque<>();
//        boolean[][] vis = new boolean[N][M];
//
//        for(int i=0; i<N; i++){
//            for(int j=0; j<M; j++){
//                if(map[i][j] == 1 || vis[i][j]) continue;
//                queue.add(new int[]{i, j});
//                vis[i][j] = true;
//                int area = 1;
//                while (!queue.isEmpty()) {
//                    int[] cur = queue.poll();
//
//                    for(int dir = 0; dir < 4; dir++){
//                        int nx = cur[0] + dx[dir];
//                        int ny = cur[1] + dy[dir];
//                        if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
//                        if(vis[nx][ny] || map[nx][ny] == 1) continue;
//                        queue.add(new int[]{nx, ny});
//                        vis[nx][ny] = true;
//                        area++;
//                    }
//                }
//                answer.add(area);
//            }
//        }
//    }
//}
