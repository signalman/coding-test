package Algorithm.day54;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main3 {
    public static void main(String[] args) {
        List<String> names = List.of("hoin", "hoin", "ff", "ta", "heelo", "heelo");
        List<Integer> score = List.of(1, 2, 1, 12, 123, 321);

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i< names.size(); i++){
            map.merge(names.get(i), score.get(i), Integer::sum);
        }

    }
}
