package Algorithm.day55;

import java.util.Arrays;
import java.util.Comparator;
import org.jetbrains.annotations.NotNull;

public class Main {

    public class Node implements Comparable<Node>{
        int score1;
        int score2;

        @Override
        public int compareTo(@NotNull Node o) {
            if(this.score1 == o.score1){
                return Integer.compare(this.score2, o.score2);
            }
            return Integer.compare(this.score1, o.score2);
        }
    }

    public static void main(String[] args) {
        int[][] array = new int[3][2];
        Arrays.sort(array, Comparator.comparing((int[] a) -> a[0]).thenComparing(a -> a[1]));
    }
}
