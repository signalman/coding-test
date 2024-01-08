package Algorithm.ka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int ans = solve(nums);
        System.out.println(ans);
    }
    private static int solve(int[] nums){
        int ret = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            dp[i] = Integer.MAX_VALUE;
        dp[0] = nums[0];
        for (int i = 0; i < nums.length; i++) {

            int st = 0;
            int en = dp.length - 1;

            while(st < en){
                int mid = st + (en - st) / 2;
                //조건에 만족 -> 답은 왼쪽편
                if(dp[mid] >= nums[i]){
                    en = mid;
                }
                //조건에 만족 x => 답은 오른쪽 편
                else{
                    st = mid + 1;
                }
            }
            if(dp[st] > nums[i]) {
                dp[st] = nums[i];
                ret = Math.max(ret, st);
            }
        }
        return ret + 1;
    }
}
