package Algorithm.day49;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Test {

    //1, 1, 2, 5, 6, 6, 7
    //1, 1, 5
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sumOfSubSet = new int[(1 << N)];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i=0; i<sumOfSubSet.length; i++){
            sumOfSubSet[i] = Integer.parseInt(st.nextToken());
            sum += sumOfSubSet[i];
        }
        sum /= (1 << N - 1);

        dfs(new ArrayList<>(), 0, sum, N);
    }

    public static void dfs(List<Integer> tmp, int tmpSum, int sum, int n){
        if(tmp.size() == n && tmpSum == sum){

//            //모든 부분집합 동일 판단.
            return;

        }

        for(int i=1; i < sum; i++){
            tmp.add(i);
            dfs(tmp, tmpSum + i, sum - i, n);
            tmp.remove(tmp.size() - 1);
        }
    }
}
