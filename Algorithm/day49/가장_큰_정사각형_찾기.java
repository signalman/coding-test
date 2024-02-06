package Algorithm.day49;

public class 가장_큰_정사각형_찾기 {
    public int solution(int[][] board)
    {
        int answer = 0;
        int dp[][] = new int[board.length][board[0].length];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){

                if(board[i][j] == 0) continue;
                if(i - 1 >= 0 && j - 1 >= 0) {
                    // dp[i][j] = Collections.min(List.of(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])) + 1;
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
                else dp[i][j] = 1;
                answer = Math.max(dp[i][j], answer);
            }
        }
        return answer * answer;
    }
}
