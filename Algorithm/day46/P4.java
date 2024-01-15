package Algorithm.day46;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P4 {

    static final String ENTER = "\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        for(int i=0; i<n; i++){
            numbers.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(numbers);
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number).append(ENTER);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
