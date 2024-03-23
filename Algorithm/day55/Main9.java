package Algorithm.day55;

public class Main9 {

    public int solve(int[] scores, int cap, int k, int m){

        //현재 내 등수
        int curRank = 0;
        for(int i=0; i<scores.length; i++){
            if(scores[i] > k) curRank++;
        }
        curRank++;
        
        int toWin = m - curRank; //재껴야 하는 사람들
        int divScore = 0;

        for(int i=1; i<=toWin; i++){
            divScore += scores[curRank - 1 - i];
        }

        int index = scores.length - 1;
        while(divScore >= 0 || index >= curRank - 1){
            int diff = k - scores[index];
            divScore -= diff;
            index--;
            toWin++;
        }
        if (divScore <= 0) return toWin;
        return -1;
    }

    public static void main(String[] args) {
        int[] scores = new int[]{95, 90, 80, 80, 80, 70, 70, 70, 30, 10};
        int cap = 100;
        int k = 70;
        int m = 4;

        Main9 main9 = new Main9();
        int solve = main9.solve(scores, cap, k, m);
        System.out.println(solve);
    }
}
