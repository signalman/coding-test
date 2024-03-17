package Algorithm.day55;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2 {
    public int[] solution(String[] info, String[] query) {
        List<Integer> answer = new ArrayList<>();
        Map<String, List<Integer>> db = new HashMap<>();
        init(db);

        for (String s : info) {
            String[] split = s.split(" ");
            pushDb(split, db);
        }
        for (String s : db.keySet()) {
            db.get(s).sort(Comparator.naturalOrder());
        }

        for (String s : query) {
            String[] split = s.replace("and ", "").split(" ");
            int count = findMembers(split, db);
            answer.add(count);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private int findMembers(String[] split, Map<String, List<Integer>> db) {
        String query = split[0] + split[1] + split[2] + split[3];
        int score = Integer.parseInt(split[4]);

        List<Integer> list = db.get(query);
        if(list.isEmpty()) return 0;

        int st = 0;
        int en = list.size();

        while(st < en){
            int mid = (st + en) / 2;

            if(list.get(mid) >= score) en = mid;
            else st = mid + 1;
        }
        return list.size() - st;
    }

    private void pushDb(String[] split, Map<String, List<Integer>> db) {
        List<List<String>> unit = new ArrayList<>();
        for (int i = 0; i < split.length - 1; i++) {
            if (split[i].equals("-")) {
                unit.add(List.of("-"));
            } else {
                unit.add(List.of("-", split[i]));
            }
        }
        dfs("", 0, unit, db, Integer.parseInt(split[split.length - 1]));
    }

    private void dfs(String tmp, int index, List<List<String>> unit, Map<String, List<Integer>> db, int score) {
        if(index == 4){
            db.get(tmp).add(score);
            return;
        }
        for(int i=0; i<unit.get(index).size(); i++){
            dfs(tmp + unit.get(index).get(i), index + 1, unit, db, score);
        }
    }

    private void init(Map<String, List<Integer>> db) {
        String[][] unit = new String[][]{{"cpp", "java", "python", "-"}, {"backend", "frontend", "-"}, {"junior", "senior", "-"}, {"chicken", "pizza", "-"}};
        dfs("", 0, unit, db);
    }

    private void dfs(String tmp, int index, String[][] unit, Map<String, List<Integer>> db) {
        if(index == 4) {
            db.put(tmp, new ArrayList<>());
            return;
        }
        for(int i=0; i<unit[index].length; i++){
            dfs(tmp + unit[index][i], index + 1, unit, db);
        }
    }
}
