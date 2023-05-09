import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 스도쿠 {

    static int[][] map;
    static int[] rowVis;
    static int[] colVis;
    static int[] boxVis;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        rowVis = new int[9];
        colVis = new int[9];
        boxVis = new int[9];

        for(int i=0; i<9; i++) {
            String line = br.readLine();
            for(int j=0; j<9; j++){
                map[i][j] = line.charAt(j) - '0';
                if(map[i][j] != 0) {
                    rowVis[i] |= (1<<map[i][j]);
                    colVis[j] |= (1<<map[i][j]);
                    boxVis[(i / 3) * 3 + j/3] |= (1<<map[i][j]);
                }
            }
        }
        dfs(0);
    }

    private static void print() {
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    private static void dfs(int numIdx) {

        if(flag) return;
        if(numIdx == 81){
            print();
            flag = true;
            return;
        }
        int i = numIdx / 9;
        int j = numIdx % 9;
        if(map[i][j] == 0){
            for(int v=1; v<=9; v++){
                if((rowVis[i] & (1<<v)) == 0 && (colVis[j] & (1<<v)) == 0 && (boxVis[i/3*3+j/3] & (1<<v)) == 0){
                    rowVis[i] |= (1<<v);
                    colVis[j] |= (1<<v);
                    boxVis[i/3*3+j/3] |= (1<<v);
                    map[i][j] = v;
                    if(flag) return;
                    dfs(numIdx + 1);
                    map[i][j] = 0;
                    rowVis[i] &= ~(1<<v);
                    colVis[j] &= ~(1<<v);
                    boxVis[i/3*3+j/3] &= ~(1<<v);
                }
            }
        }
        else dfs(numIdx+1);
    }
}
