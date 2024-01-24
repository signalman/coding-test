package Algorithm.day48;

import java.util.Arrays;

public class Bit {

    public static void main(String[] args) {

        int controlBit = 0;
        controlBit |= (1 << 20);

        for(int i=0; i<32; i++){
            if((controlBit & (1 << i)) > 0){
                System.out.println(i);
            }
        }
        int a = 21;
        System.out.println(~a);

        int[] array = new int[]{2, 4, 4, 5, 5, 5, 9};
        int i = Arrays.binarySearch(array, 1);
        System.out.println(i);

    }
}
