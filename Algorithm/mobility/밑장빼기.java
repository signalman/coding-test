package Algorithm.mobility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
/*
* 
* 재귀로 풀어서 시간복잡도 보기
* */
public class 밑장빼기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.stream(arr).forEach(num -> deque.addLast(num));
//        solve(deque, false, 0);
        int ans = solve(arr);
        System.out.println(ans);
    }

    static int solve(int[] arr){
        int originEvenSum = 0;
        for(int i=0; i<arr.length; i++){
            if(i % 2 == 0){
                originEvenSum += arr[i];
            }
        }
        int ans = originEvenSum;
        int last = arr[arr.length - 1];
        for(int i = arr.length - 2; i >= 0; i--){
            if(i % 2 == 1){
                originEvenSum = originEvenSum - last + arr[i];
                ans = Math.max(ans, originEvenSum);
            }
            else{
                originEvenSum = originEvenSum - arr[i] + last;
                ans = Math.max(ans, originEvenSum);
            }
        }
        return ans;
    }

//    static void solve(Deque<Integer> deque, boolean trick, int ret){
//        if (deque.isEmpty()) {
//            ans = Math.max(ans, ret);
//            return;
//        }
//        //정상
//        int first = deque.pollFirst();
//        int second = deque.pollFirst();
//        solve(deque, trick, ret + first);
//        deque.addFirst(second);
//        deque.addFirst(first);
//
//        if (!trick) { //밑장 , 정상
//            first = deque.pollFirst();
//            int last = deque.pollLast();
//            solve(deque, trick, ret + first); //정상, 밑장
//            solve(deque, trick, ret + last); //밑장, 정상
//            deque.addFirst(first);
//            deque.addLast(last);
//        }
//    }


}
