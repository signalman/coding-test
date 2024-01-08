package Algorithm.ka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
* LIS의 풀이법 해결과정
* 1. 완전탐색 -> 입력 문자열에 부분 문자열을 모두 구하여 가장 긴 것을 고른다. 2^n
* 2. 메모이제이션 활용 - dp
* 3. 이분 탐색
* */
public class LIS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
//        int ans = LIS_BRUTEFORCE(nums, 0, new ArrayList<>()); //완전탐색을 이용한 풀이 O(2^N)
//        int ans = LIS_DP(nums); //dp를 사용한 풀이  O(N^2)
        int ans = LIS_BINARY_SEARCH(nums);
        System.out.println(ans);
    }

    /*
    * O(NlogN)
    * 이분탐색을 이용한 풀이
    * dp[k] : 길이가 k인 LIS 중 '가장 마지막 원소가 최소'가 되는 값을 기록한다.
    *
    * 이분탐색 시 mid 값은 st, en은 조건에 만족하도록 조정하면서 while문을 진행해야함.
    * ex) 조건에 만족하고 찾는 값이 왼쪽에 있다면 en = mid
    * ex) 조건에 만족하지 않고 찾는 값이 오른쪽에 있다면 st = mid + 1 
    *  *** +1 여부는 조건에 만족하는지 안 하는지 여부로 결정 ***
    * */
    private static int LIS_BINARY_SEARCH(int[] nums){
        int ret = 0;
        int[] dp = new int[nums.length ];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {

            //dp테이블에서 채워진 값들을 탐색하며 갱신한다.
            int st = 0;
            int en = nums.length;

            while(st != en){
                int mid = st + (en - st) / 2;
                //조건에 만족하고 찾는 값은 왼쪽에 있음
                if(dp[mid] >= nums[i]) en = mid;
                //조건에 만족하지 않고 찾는 값은 오른쪽에 있음
                else st = mid + 1;
            }
            //nums : 10 20 30 11 12 13 14
            //nums[i]: 11
            //dp   : 10 20 30 INF INF INF INF
            //dp   : 10 11 30 INF INF INF INF
            dp[st] = Math.min(dp[st], nums[i]);

            //찾아진 index 중 가장 큰 것들 갱신하며 저장
            ret = Math.max(ret, st);
        }
        return ret + 1;
    }

    /*
    * O(N^2)
    * DP를 이용한 풀이
    * dp[k] : 1 ~ k 까지 중 k 번째 숫자를 마지막에 사용한 LIS
    * */
    private static int LIS_DP(int[] nums) {

        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        Arrays.sort(dp);
        return dp[nums.length - 1];
    }

    /*
    * O(2^N) 풀이
    * 재귀 - 완전 탐색을 이용한 풀이
    * i번째 수를 넣는 경우/ 안 넣는 경우
    * */
    private static int LIS_BRUTEFORCE(int[] nums, int depth, List<Integer> tmp){
        if(depth == nums.length){
            return tmp.size();
        }
        int ans = -1;
        if(tmp.isEmpty()){
            tmp.add(nums[depth]);
            ans = Math.max(ans, LIS_BRUTEFORCE(nums, depth + 1, tmp));
            tmp.remove(tmp.size() - 1);
            ans = Math.max(ans, LIS_BRUTEFORCE(nums, depth + 1, tmp));
        }

        else if(nums[depth] > tmp.get(tmp.size() - 1)){
            tmp.add(nums[depth]);
            ans = Math.max(ans, LIS_BRUTEFORCE(nums, depth + 1, tmp));
            tmp.remove(tmp.size() - 1);
        }
        else{
            ans = Math.max(ans, LIS_BRUTEFORCE(nums, depth + 1, tmp));
        }
        return ans;
    }
}
