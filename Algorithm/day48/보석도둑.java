package Algorithm.day48;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 보석도둑 {

    public int[] solution(String[] gems) {
        int[] answer = new int[]{0, gems.length};

        Map<String, Integer> count = new HashMap<>();

        Set<String> set = new HashSet<>();
        for(String gem: gems){
            set.add(gem);
        }
        int st = 0;
        int en = 0;
        int len = gems.length;
        int n = set.size(); //보석 종류 수
        count.put(gems[st], 1);

        while(st < gems.length && en < gems.length){

            //종류 만족
            if(count.keySet().size() == n){
                if((len > en - st) || (len == en - st && st < answer[0])){
                    len = en - st;
                    answer[0] = st;
                    answer[1] = en;
                }
                //st지우기
                count.put(gems[st], count.get(gems[st]) - 1);
                if(count.get(gems[st]) == 0) count.remove(gems[st]);
                st++;
            }
            //만족x
            else{
                en++;
                if(en < gems.length)
                    count.put(gems[en], count.getOrDefault(gems[en], 0) + 1);
            }
        }
        return new int[]{answer[0] + 1, answer[1] + 1};
    }
}
