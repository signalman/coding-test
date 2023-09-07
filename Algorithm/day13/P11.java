package Algorithm.day13;

import java.util.ArrayList;
import java.util.List;

public class P11 {

    public static void main(String[] args) {

        int s = calculate(1, 3, 4, 5, 1, 123, 123);
        System.out.println(s);

        ArrayList<Integer> arrayList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

    }

    static int calculate(int ...values){
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

}
