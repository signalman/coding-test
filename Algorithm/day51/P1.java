package Algorithm.day51;

public class P1 {
    public int solution(int n, int[][] results) {
        int answer = 0;

        int[][] score = new int[n + 1][n + 1];
        for(int[] r : results){
            score[r[0]][r[1]] = 1;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    if(score[j][i] == 1 && score[i][k] == 1){
                        score[j][k] = 1;
                    }
                }
            }
        }

        for(int i=1; i<=n; i++){
            int count = 0;
            for(int j=1; j<=n; j++){
                if(score[i][j] == 1 || score[j][i] == 1) count++;
            }
            if(count == n - 1) answer++;
        }

        return answer;
    }
}
