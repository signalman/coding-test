package Algorithm.day49;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OriginalArrayFinder {

    static final int N = 3;

    public static void findOriginalArray(int[] sumArray) {
        Set<List<Integer>> results = new HashSet<>(); // 결과를 저장할 집합
        backtrack(sumArray, 0, new ArrayList<>(), results);

        // 결과 출력
        for (List<Integer> result : results) {
            if(result.size() == N){
                System.out.println(result);
            }
        }
    }

    private static void backtrack(int[] sumArray, int start, List<Integer> current, Set<List<Integer>> results) {
        int currentSum = calculateSum(current);

        // 현재 경로의 합이 sumArray에 포함되어 있고, 유니크한 결과인 경우 결과에 추가
        for (int sum : sumArray) {
            if (sum == currentSum && !results.contains(new ArrayList<>(current))) {
                results.add(new ArrayList<>(current));
            }
        }

        // 재귀 종료 조건
        if (start == sumArray.length) {
            return;
        }

        for (int i = start; i < sumArray.length; i++) {
            // 현재 원소를 추가하고 백트래킹
            current.add(sumArray[i]);
            backtrack(sumArray, i + 1, current, results);
            // 백트래킹 후 현재 원소 제거
            current.remove(current.size() - 1);
        }
    }

    private static int calculateSum(List<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] sumArray = {1, 1, 2, 5, 6, 6, 7};
        findOriginalArray(sumArray);
    }
}
