package Algorithm.day31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //문자의 자리 수에 따른 가중치를 부여해서 map에 저장    (ex: AAA -> map['A'] = 111)
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++){
            String numStr = br.readLine();
            int times = 1;
            //문자열을 뒤에서부터 탐색하면서 MAP에 자릿수별 가중치 부여해서 더해감
            for(int j = numStr.length()-1; j>=0; j--){
                map.put(numStr.charAt(j), map.getOrDefault(numStr.charAt(j), 0) + times);
                //자릿수에 따른 가중치 부여
                times *= 10;
            }
        }
        // MAP의 VALUE 값을 내림차순 으로 정렬
        List<Integer> valueList = new ArrayList<>(map.values());
        valueList.sort(Collections.reverseOrder());
        int ans = 0;
        //가장 큰 수인 9부터 차례대로 부여
        int t = 9;
        for (Integer integer : valueList) {
            ans += (t*integer);
            t--;
        }
        System.out.println(ans);
    }
}
