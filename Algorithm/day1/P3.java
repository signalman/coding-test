package Algorithm.day1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P3 {


    static int comp(String s1, String s2){

        List<Integer> split1 = Arrays.stream(s1.split("\\.")).sequential().map(s -> Integer.parseInt(s)).collect(
            Collectors.toList());
        List<Integer> split2 = Arrays.stream(s2.split("\\.")).sequential().map(s -> Integer.parseInt(s)).collect(
            Collectors.toList());

        int year1 = split1.get(0);
        int year2 = split2.get(0);
        int month1 = split1.get(1);
        int month2 = split2.get(1);
        int date1 = split1.get(2);
        int date2 = split2.get(2);

        if (year1 != year2) {
            return Integer.compare(year1, year2);
        }
        if(month1 != month2){
            return Integer.compare(month1, month2);
        }
        return Integer.compare(date1, date2);
    }


    public static void main(String[] args) {

        String[] stringArr = new String[5];
        stringArr[0] = "2023.06.01";
        stringArr[1] = "2023.01.05";
        stringArr[2] = "2023.03.01";
        stringArr[3] = "2022.03.09";
        stringArr[4] = "2023.01.01";

        Arrays.sort(stringArr, (s1, s2) -> comp(s1, s2));

        for (String s : stringArr) {
            System.out.println(s);
        }
    }
}
