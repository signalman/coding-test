package Algorithm.day55;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Main2 {

    //문자열을 숫자로 매핑시키기
// cpp 0, java 1, python 2
// backend 0, frontend 1
// junior 0, senior 1
// chicken 0, pizza 1
//score 1 ~ 100000
    class Solution {

        Map<String, Integer> hash = Map.of("cpp", 0, "java", 1, "python", 2, "backend", 0, "frontend", 1, "junior", 0, "senior", 1, "chicken", 0, "pizza", 1);

        public int[] solution(String[] info, String[] query) {
            List<Integer> answer = new ArrayList<>();
            int[][] infos = new int[info.length][2]; //문자열 점수, 점수

            //infos에 넣기
            for(int i=0; i<info.length; i++){
                String[] sp = info[i].split(" ");
                infos[i] = toNumber(sp, hash);
            }
            //정렬하기
            Arrays.sort(infos, Comparator.comparing((int[] o) -> o[0]).thenComparing(o -> o[1]));
            System.out.println(Arrays.deepToString(infos));
            System.out.println("+++++++++");
            for(String q: query){
                q = q.replace(" and ", " ");
                int[] range = queryToRange(q); //01010, 01111, 100점
                System.out.println(Arrays.toString(range));
                //binarySearch 수행
                int lo = lowerBound(infos, range);
                //binarySearch 수행
                int hi  = upperBound(infos, range);
                // System.out.println(hi + " " + lo);
                answer.add(hi - lo);
            }

            return answer.stream().mapToInt(i -> i).toArray();
        }

        int lowerBound(int[][] array, int[] range){

            int st = 0;
            int en = array.length - 1;

            while(st < en){

                int mid = (st + en) / 2;
                //조건 만족
                if(array[mid][0] >= range[0] && array[mid][1] >= range[2]){
                    en = mid;
                }
                else{
                    st = mid + 1;
                }
            }
            return st;
        }

        int upperBound(int[][] array, int[] range){

            int st = 0;
            int en = array.length - 1;

            while(st < en){

                int mid = (st + en ) / 2;
                //조건 만족
                if(array[mid][0] > range[1]){
                    en = mid;
                }
                else{
                    st = mid + 1;
                }
            }
            return st;
        }

        int[] toNumber(String[] split, Map<String, Integer> hash){

            String binary = "";
            for(int i=0; i<split.length -1; i++){
                binary += hash.get(split[i]).toString();
            }
            return new int[]{Integer.parseInt(binary, 3), Integer.parseInt(split[split.length - 1])};
        }
        //해당 쿼리가 범위를 나타내도록 만드는 함수
        int[] queryToRange(String query){
            String[] split = query.split(" ");
            String mn = "";
            String mx = "";

            //java/ backend/ - /pizza/ 110
            for(int i=0; i<split.length - 1; i++){
                if(split[i].equals("-")){
                    mn += "0";
                    mx += "1";
                } else{
                    mn += hash.get(split[i]).toString();
                    mx += hash.get(split[i]).toString();
                }
            }
            return new int[]{Integer.parseInt(mn, 3), Integer.parseInt(mx, 3), Integer.parseInt(split[split.length - 1])};
        }
    }
}
