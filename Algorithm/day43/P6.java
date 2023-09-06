//package Algorithm.day43;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class P6 {
//
//    static int T, W;
//    static int[] tree;
//    static int[][] dp;
//    /*
//        dp[i][j] = i번째 자두는 먹었고 현재까지 j만큼 움직여서 총 먹은 자두
//    */
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        T = Integer.parseInt(st.nextToken());
//        W = Integer.parseInt(st.nextToken());
//
//        tree = new int[T + 5];
//        dp = new int[T][W + 5];
//
//        for(int i=0; i<T; i++){
//            tree[i] = Integer.parseInt(br.readLine()) - 1;
//        }
//
//        //dp[i][j] = i번째 자두를 먹었고 현재까지 j만큼 움직임
//        if(tree[0] == 0) dp[0][0] = 1;
//
//        for(int i=0; i<T-1; i++){
//            for(int j=0; j<=W; j++){
//                if (tree[i + 1] == tree[i]) { //같은곳에 또 떨어질때
//                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + 1);
//                } else{
//                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j] + 1);
//                }
//                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
//                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j + 1]);
//            }
//        }
//
//        int ans = 0;
//        for(int i=0; i<T; i++){
//            for(int j=0; j<=W; j++){
////                ans = Math.max(dp[i][j], ans);
//                System.out.print("args = " + dp[i][j]);
//            }
//            System.out.println();
//        }
////        System.out.println(ans);
//    }
//}
