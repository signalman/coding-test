package Algorithm.day35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_6808_규영이와인영이의카드게임_신호인 {

    static int[] inCard;
    static int[] kyuCard;
    static int lose;
    static int win;

    static void dfs(int visit, int index){
        if(index == 9){
            //처리로직
            //총합171
            int score = 0;
            for(int i=0; i<9; i++){
                if(inCard[i] > kyuCard[i]) score += (inCard[i]+kyuCard[i]);
            }
            if(score > 171 - score) lose++;
            else if(score < 171 - score) win++;
            return;
        }
        for(int i=1; i<=18; i++){
            if((visit & (1<<i)) > 0) continue;
            inCard[index] = i;
            dfs(visit|(1<<i), index + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        //테스트케이스만큼 반복
        for(int tc =1; tc<=T; tc++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            kyuCard = new int[9];
            inCard = new int[9];
            int inNum = 0;
            for(int i=0; i<9; i++){
                kyuCard[i] = Integer.parseInt(st.nextToken()); //규영이가 받은 카드 목록
                inNum |= (1<<kyuCard[i]); //규영이가 받은 카드 체크
            }
            win = 0;
            lose = 0;
            dfs(inNum, 0);
            sb.append("#").append(tc).append(" ")
                    .append(win).append(" "). append(lose)
                    .append("\n");
        }
        System.out.println(sb);
    }
}
