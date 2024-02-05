package Algorithm.day49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 원본_배열_만들기 {
    static List<Integer> answer = new ArrayList<>();

    public static int[] solution(int N, int[] sumArray){ //2^N개

        backtracking(0, 0, N, new ArrayList<>(), sumArray);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void backtracking(int depth, int sum, int N, List<Integer> ret, int[] sumArray){
        if(ret.size() > 0 && Arrays.stream(sumArray).allMatch(i -> i != sum) || depth >= sumArray.length) return;
        if(ret.size() == N) {
            answer = new ArrayList<>(ret);
            return;
        }

        //안넣기
        backtracking(depth + 1, sum, N, ret, sumArray);
        //넣기
        ret.add(sumArray[depth]);
        backtracking(depth + 1, sum + sumArray[depth], N , ret, sumArray);
        ret.remove(ret.size() - 1);
    }


    public static void main(String[] args) {

        int[] sumArray = new int[]{1, 7, 8, 8, 9, 15, 16};
        int N = 3;
        int[] array = solution(N, sumArray);
        List<Integer> collect = Arrays.stream(array)
                                      .boxed()
                                      .toList();
        boolean equals = collect.equals(List.of(1, 7, 8));
        System.out.println(equals);


    }
}
