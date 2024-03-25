package Algorithm.day55;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;

public class Main12 {


    public static void main(String[] args) {
        Dictionary<String, String> d = new Hashtable<>();
        Map<String, String> map = new HashMap<>(123, 0.75f);

        int i = Integer.valueOf(3).hashCode();
        int i1 = Double.valueOf(2.2)
                       .hashCode();
        long l = Double.doubleToLongBits(2.123);
        Objects.hashCode(Integer.valueOf(123));
        int hash = Objects.hash(1, 2, 3);
        int h = Objects.hashCode(new int[]{1, 2, 3});
        System.out.println(hash + " " + h);
    }


}
