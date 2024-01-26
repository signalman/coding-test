package Algorithm.day48;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Practice {
/* int[] 를
* String replaceAll()
* String.format()
    *
    * 글자 갯수만큼 붙이기
* char[] -> String
* String -> char[]
* StringBuilder -> String
* StringBuilder 제거, 갯수만큼 붙이기
*
    * Collections
* Map, Set 함수
* int[] -> LIst<Integer>
*/
    public class Node{

    @Override
    public int hashCode() {
        return 1;
    }
}
    public static void main(String[] args) {

        //replaceAll
        String ex1 = "good, good, good person";
        ex1 = ex1.replace("good", "fine");
        System.out.println(ex1);

        ex1 = ex1.replaceAll("good", "fine");
        System.out.println(ex1);


        StringBuilder sb1 = new StringBuilder("가");
        StringBuilder sb2 = new StringBuilder("1999나");
        int a = 3, b = 5;
        if (sb1.compareTo(sb2) < 0) {
            System.out.println("첫번째가 더 빨라요");
        }

        String ex2 = "hello";
        ex2 = String.format("%10s", ex2).replace(' ', '-');
        System.out.println(ex2);

        int[] array = new int[]{1, 3, 2, 1};
        List<Integer> list = Arrays.stream(array)
                                   .boxed()
                                   .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder("hello");
        StringBuilder replace = sb.replace(1, 2, "");
        String ss = "f  ekfje  kelfjel";
        String replace1 = ss.replace(" ", "");
        System.out.println(replace1);

    }
}
