package Algorithm.day41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P8 {
    static int a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(br.readLine());
        b=   Integer.parseInt(br.readLine());;
        System.out.println(a+b);
    }
}
