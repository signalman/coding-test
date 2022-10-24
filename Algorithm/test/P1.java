package Algorithm.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class P1 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        //이름과 idx매칭
        Map<String, Integer> nameMatching = new HashMap<>();
        for(int i=0; i<id_list.length; i++){
            nameMatching.put(id_list[i], i);
        }

        //key: 신고당한사람, value: 신고 한 사람
        Map<String, HashSet> reportList = new HashMap<>();
        for (String s : report) {
            String[] a = s.split(" ");
            if(!reportList.containsKey(a[1])){
                HashSet<String> set = new HashSet<>();
                set.add(a[0]);
                reportList.put(a[1], set);
            }
            else{
                reportList.get(a[1]).add(a[0]);
            }
        }
        for (String s : reportList.keySet()) {
            HashSet hashSet = reportList.get(s);
            if (hashSet.size() >= k) {
                for (Object o : hashSet) {
                    answer[nameMatching.get(o)]++;
                }
            }

        }


        return answer;
    }
}
