package Algorithm.day45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*0142326*/
public class P1 {

    private static final String[][] numbers = new String[][]{
        //0
        {
            "***", "* *", "* *", "* *", "***"
        },
        //1
        {
            "  *", "  *", "  *", "  *", "  *"
        },
        //2
        {
            "***", "  *", "***", "*  ", "***"
        },
        //3
        {
            "***", "  *", "***", "  *", "***"
        },
        //4
        {
            "* *", "* *", "***", "  *", "  *"
        },
        //5
        {
            "***", "*  ", "***", "  *", "***"
        },
        //6
        {
            "***", "*  ", "***", "* *", "***"
        },
        //7
        {
            "***", "  *", "  *", "  *", "  *"
        },
        //8
        {
            "***", "* *", "***", "* *", "***"
        },
        //9
        {
            "***", "* *", "***", "  *", "***"
        }
    };
    static int M_COL = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] map = new char[6][25];
        for(int i=0; i<5; i++){
            map[i] = br.readLine().toCharArray();
            M_COL = Math.max(M_COL, map[i].length);
        }

//        열이 3으로 나눠떨어지지 않을때 x
//        if(M_COL % 3 != 0){
//            System.out.println("BOOM");
//            return;
//        }
//        해당 숫자가 없을때 x

        String bomNumber = "";
        for(int j = 0; j < M_COL; j+=3){
            int num = solve(map, j);
//            System.out.println(num);
            if(num == -1) {
                System.out.println("BOOM!!");
                return;
            }
            bomNumber += num;
            j+=1;
        }
        int bNumber = Integer.parseInt(bomNumber);
        if(bNumber % 6 == 0){
            System.out.println("BEER!!");
        } else{
//            System.out.println(bNumber);
            System.out.println("BOOM!!");
        }
    }

    static int solve(char[][] map, int col){
        String[] tmp = new String[5];
        for(int i=0; i<5; i++){
            String str = "";
            for(int j=col; j < col + 3; j++){
                if(j >= M_COL) return -1;
                str += map[i][j];
            }
            tmp[i] = str;
        }

        for(int i=0; i<10; i++){
            String[] num = numbers[i];
            if(isSame(tmp, num)) return i;
        }
        return -1;
    }
    static boolean isSame(String[] tmp, String[] num){
        for(int i=0; i<5; i++){
            if(!tmp[i].equals(num[i])) return false;
        }
        return true;
    }


}
