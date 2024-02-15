package Algorithm.day50;

public class 진법변환 {

    public static void main(String[] args) {
        String binary = "101";
        Integer integer = Integer.valueOf(binary, 16);
        System.out.println(integer);
    }
}
