package Algorithm.day50;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;

public class L2 {

    int[][] segments = new int[][]{
        {0, 1, 2, 3, 4, 5},
        {1, 2},
        {0, 1, 3, 4, 6},
        {0, 1, 2, 3, 6},
        {1, 2, 5, 6},
        {0, 2, 3, 5, 6},
        {0, 2, 3, 4, 5, 6},
        {0, 1, 2, 5, 6},
        {0, 1, 2, 3, 4, 5, 6},
        {0, 1, 2, 3, 5, 6}
    };

    int[] solution(String[] arr){
        List<Integer> ans = new ArrayList<>();
        for(String number: arr){
            int ret = 0;
            BitSet[] bitSets = new BitSet[number.length()];

            for(int i=0; i<number.length(); i++){
                bitSets[i] = new BitSet();
                int[] segment = segments[number.charAt(i) - '0'];
                for (int i1 : segment) {
                    bitSets[i].set(i1);
                }
            }

            HashSet<String> set = new HashSet<>();
            for (int s = 0; s < 7; s++) {
                String cur = "";

                for (BitSet bitSet : bitSets) {
                    cur += bitSet.get(s) ? "1" : "0";
                }
                String zero = "0".repeat(bitSets.length);
                if(cur.equals(zero)) continue;
                if(set.add(cur)) {
                    ret++;
                }
            }
            ans.add(ret);
        }
        return ans.stream()
                  .mapToInt(i -> i)
                  .toArray();
    }

    public static void main(String[] args) {
        L2 l2 = new L2();
        String[] arr = new String[]{"29471500", "6813427", "0123456789"};
        int[] solution = l2.solution(arr);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
