package Algorithm.day45;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryFinallyExample {

//    public static void main(String[] args) {

//        try{
//            throw new RuntimeException("try 블록에서 발생한 예외");
//        } finally {
//            try{
//                throw new RuntimeException("finally 블록에서 발생한 예외");
//            } catch (Exception e){
//                System.out.println(e.getMessage());
//            }
//        }
//    }


//    public static void main(String[] args) {
//        // try-with-resources 구문 사용
//        try (BufferedReader br = new BufferedReader(new FileReader("./Algorithm/day41/test.txt"))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
////            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("./Algorithm/day41/test.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

