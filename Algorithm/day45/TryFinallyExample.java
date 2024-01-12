package Algorithm.day45;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TryFinallyExample {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        String str = "자바가 좋아";
//        byte[] bytes = str.getBytes();
//        for (byte b : bytes) {
//            System.out.println(b);
//        }
//        System.out.println(new String(bytes));
    }

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

    public static void main22(String[] args) {
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

