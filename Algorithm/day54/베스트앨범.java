package Algorithm.day54;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {

        //장르 카운트
        Map<String, Integer> genreCount = new HashMap<>();
        for(int i=0; i<genres.length; i++){
//            genreCount.put(genres[i], genreCount.getOrDefault(genres[i], 0) + plays[i]);
            genreCount.merge(genres[i], plays[i], Integer::sum);
        }

        //각 장르별 플레이
        Map<String, Map<Integer, Integer>> playCount = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            playCount.computeIfAbsent(genres[i], k -> new HashMap<>()).put(i, plays[i]);
        }

        List<String> genresOrderByDesc = genreCount.keySet().stream()
                                                   .sorted(Comparator.comparing(s -> genreCount.get(s)).reversed())
                                                   .toList();
        List<Integer> answer = new ArrayList<>();

        for(String genre: genresOrderByDesc){
            Map<Integer, Integer> idAndPlays = playCount.get(genre);
            List<Integer> keys = idAndPlays.keySet()
                                           .stream()
                                           .sorted(Comparator.comparing(
                                                                 (Integer i) -> idAndPlays.get(i))
                                                             .reversed()
                                                             .thenComparing(i -> i))
                                           .limit(2)
                                           .toList();
            answer.addAll(keys);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        //값이 없으면 추가, 있다면 더하기
        map1.merge("Kevin", 1, Integer::sum);

        //value가 초기화가 필요할때 사용
        Map<String, Map<Integer, Integer>> map2 = new HashMap<>();
        map2.computeIfAbsent("Kevin", k -> new HashMap<>()).put(1, 1);
    }
}
