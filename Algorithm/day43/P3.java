package Algorithm.day43;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class P3 {

    static List<Integer> list;
    public static void main(String[] args) {
        list = new LinkedList<>();
        for(int i=0 ;i<10; i++){
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }


        Map<String, Integer> map = new HashMap<>();
        map.put("hi", 3);
        map.put("hello", 2);

        Iterator<Entry<String, Integer>> iterator1 = map.entrySet()
                                                        .iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next().getValue());
        }
    }
}
