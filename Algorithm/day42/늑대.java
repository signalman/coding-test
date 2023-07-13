package Algorithm.day42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 늑대 {
    static String input;
    static List<String> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        list = new ArrayList<>();

        for(int i=1; i<=13; i++){
            String tmp = "";
            for(int j=0; j<4; j++){
                for(int k = 0; k < i; k++){
                    switch (j){
                        case 0:
                            tmp += 'w';
                            continue;
                        case 1:
                            tmp += 'o';
                            continue;
                        case 2:
                            tmp += 'l';
                            continue;
                        case 3:
                            tmp += 'f';
                    }
                }
            }
            list.add(tmp);
        }

        boolean flag = false;
        while(true){
            for(int i=0; i<list.size(); i++){
                if (input.contains(list.get(i))) {
                    flag = true;
                    input = input.replace(list.get(i), "x");
                    break;
                }
            }
            if(!flag) break;
            flag = false;
        }
        boolean ans = true;
        for(int i=0; i<input.length(); i++){
            if (input.charAt(i) != 'x') {
                ans = false;
            }
        }
        System.out.println(ans == true ? 1 : 0);
    }


}
