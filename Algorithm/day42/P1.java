package Algorithm.day42;

import java.util.Arrays;

public class P1 {
    //3
    //3122312894879453420
    public static void main(String[] args) {
        int a = solve(3, "3122312832194879453420");
        System.out.println(a);
    }
    static int solve(int N, String arr){
        String target = "";
        int ans = 0;
        for(int i=1; i<=N; i++){
            target += i;
        }
        for(int i=0; i<arr.length() - N + 1; i++){
            String tmp = arr.substring(i, i + N);
            char[] chars = tmp.toCharArray();
            Arrays.sort(chars);
            String newTmp = new String(chars);
//            System.out.println(newTmp);
            if (newTmp.equals(target)) {
                ans = Integer.max(ans, Integer.parseInt(tmp));
            }
        }
        return ans;
    }

}
