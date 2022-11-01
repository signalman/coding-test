package Algorithm.sg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class P1 {
    static class alien implements Comparable{
        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }



    class Solution {
        public String[] solution(String[] history, String[][] option, String keyword) {
            String[] answer = {};

            alien[] aliens = new alien[2];
            for(int i=0; i< 2; i++){
                aliens[i] = new alien();
            }

            Arrays.sort(aliens);

            for(int i=0; i<history.length; i++){
                if (option[i] == null) {

                }
                else{

                }
            }




            return answer;
        }
    }
}
