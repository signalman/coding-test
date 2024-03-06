package Algorithm.day53;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main1 {

    public static List<List<Integer>> subset;

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        subset = new ArrayList<>();


        solve(array, 0, new ArrayList<>());
        Collections.sort(subset, Comparator.comparing(List::size));
        System.out.println(subset);
        StringBuilder sb = new StringBuilder(3);
        String stgr = "";
        int a = 3;
    }

    public static void solve(int[] array, int cur, List<Integer> tmp){

        if (cur == array.length) {
            subset.add(new ArrayList<>(tmp));
            return;
        }

        tmp.add(array[cur]);
        solve(array, cur + 1, tmp);
        tmp.remove(tmp.size() - 1);
        solve(array, cur + 1, tmp);
    }

}
