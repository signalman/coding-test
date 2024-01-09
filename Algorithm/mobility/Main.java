package Algorithm.mobility;

public class Main {

    public static void main(String[] args) {

        String s1 = Integer.toBinaryString(5);
        System.out.println(s1);
        s1 = "0b" + s1;


        int i1 = (1<<15) + 1;
        System.out.println(i1);
//        int i2 = 5;
        System.out.println((short) i1);
        short s = (short) (i1 % (1<<16));
        int num = (1<<31)-1;
        System.out.println(num);

        Integer num1 = (1<<31);
        System.out.println(num1);

        int a = -5;
        System.out.println(a % 5);
    }
}
