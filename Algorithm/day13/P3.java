package Algorithm.day13;

public class P3 {

    public static void main(String[] args) {

        String S1 = "Hello";
        String S2 = "Hello";
        String S3 = new String("Hello");

        System.out.println(S1 == S2);
        System.out.println(S1 == S3);
        System.out.println(S1.equals(S3));
        System.out.println(S2.equals(S3));
    }
}
