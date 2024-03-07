package Algorithm.day54;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
}
