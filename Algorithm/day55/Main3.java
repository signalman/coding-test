package Algorithm.day55;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main3 {

    public int[] solution(String[] info, String[] query) {
        List<Integer> answer = new ArrayList<>();
        Map<String, List<Integer>> infos = new HashMap<>();

        for (String s1 : new String[]{"cpp", "java", "python", "-"}) {
            for (String s2 : new String[]{"backend", "frontend", "-"}) {
                for (String s3 : new String[]{"junior", "senior", "-"}) {
                    for (String s4 : new String[]{"chicken", "pizza", "-"}) {
                        infos.put(s1 + s2 + s3 + s4, new ArrayList<>());
                    }
                }
            }
        }
        for (String str : info) {
            String[] s = str.split(" ");
            for (String s1 : new String[]{s[0], "-"}) {
                for (String s2 : new String[]{s[1], "-"}) {
                    for (String s3 : new String[]{s[2], "-"}) {
                        for (String s4 : new String[]{s[3], "-"}) {
                            infos.get(s1 + s2 + s3 + s4).add(Integer.parseInt(s[4]));
                        }
                    }
                }
            }
        }

        for (String str : query) {
            String[] s = str.replace(" and", "").split(" ");
            String q = s[0] + s[1] + s[2] + s[3];
            int score = Integer.parseInt(s[4]);

            List<Integer> list = infos.get(q);
            int st = 0;
            int en = list.size();

            while(st < en){
                int mid = (st + en) / 2;

                if(list.get(mid) < score){
                    st = mid + 1;
                } else{
                    en = mid;
                }
                answer.add(list.size() - st);
            }
        }
        return answer.stream()
                     .mapToInt(i -> i)
                     .toArray();
    }

}
