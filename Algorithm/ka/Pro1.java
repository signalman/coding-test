package Algorithm.ka;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Pro1 {

    public static void main(String[] args) {

        Pro1 pro1 = new Pro1();
        int[][] arr = new int[][]{{4, 2, 4, -3, -1}, {-1, -2, 2, 1}, {-1, 2, 2, 1}};
        for(int[] a: arr){
            int ans = pro1.solve(a);
            System.out.println(ans);
        }
    }
    int solve(int[] arr){

        int totalSum = totalSum(arr);
        int[] subSum = subSum(arr);
        Map<Integer, Integer> table1 = new HashMap<>();
        Map<Integer, Integer> table2 = new HashMap<>();
        Arrays.stream(arr).forEach(i -> table2.put(i, table2.getOrDefault(i, 0) + 1));

        int answer = 0;
        for(int i=0; i<arr.length; i++){
            table1.put(arr[i], table1.getOrDefault(arr[i], 0) + 1);
            table2.put(arr[i], table2.get(arr[i]) - 1);
            int s1 = subSum[i];
            int s2 = totalSum - s1;
            for(int j=-9; j<=9; j++){
                int target = (s1 - s2) / 2 + j;
                if(target == j || table1.get(target) == null || table2.get(j) == null) continue;
                answer += ((table1.get(target) * table2.get(j))) % (1e9 + 7);
            }
        }
        return answer;
    }
    int totalSum(int[] arr){
        int ret = 0;
        for(int i : arr){
            ret += i;
        }
        return ret;
    }
    int[] subSum(int[] arr){
        int[] ret = new int[arr.length];
        ret[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            ret[i] = ret[i-1] + arr[i];
        }
        return ret;
    }
}
