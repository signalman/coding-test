package Algorithm.ka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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

        solve(nums);
    }
    private static void solve(int[] nums){
        int ret = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            dp[i] = Integer.MAX_VALUE;
        dp[0] = nums[0];

        int[] tracking = new int[nums.length];
        tracking[0] = 0;
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
            if(dp[st] >= nums[i]) {
                dp[st] = nums[i];
                tracking[i] = st;
                ret = Math.max(ret, st);
            }
        }
//        Stack<Integer> stack = new Stack<>();
//        int findIndex = ret;
//        for(int i=nums.length - 1; i>=0; i--){
//            if(tracking[i] == findIndex){
//                stack.add(nums[i]);
//                findIndex--;
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        sb.append(ret + 1).append("\n");
//        while (!stack.isEmpty()) {
//            int cur = stack.pop();
//            sb.append(cur).append(" ");
//        }
//        System.out.print(sb);

        List<Integer> ans = new ArrayList<>();
        int findIndex = ret;
        for(int i=nums.length - 1; i>=0; i--){
            if(tracking[i] == findIndex){
                ans.add(nums[i]);
                findIndex--;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ret + 1).append("\n");
        for(int i=ans.size()-1; i>=0; i--){
            sb.append(ans.get(i)).append(" ");
        }
        System.out.print(sb);

    }
}
