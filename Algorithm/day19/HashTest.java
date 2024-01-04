package Algorithm.day19;

import java.util.Arrays;
import java.util.HashMap;

public class HashTest {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("HI", 3);
        HashMap<String, Integer> _map = new HashMap<>();
        _map.put("HI", 3);
        System.out.println(map.equals(_map));

        int[] array = new int[]{1, 3, 5};
        int[] _array = new int[]{1, 3, 5};
        System.out.println(array.equals(_array));
        System.out.println(Arrays.equals(array, _array));

        int[] arr = new int[]{20, 20, 20, 30, 40, 50};

        int i = Arrays.binarySearch(arr, 20);
        System.out.println(i);

    }
}
