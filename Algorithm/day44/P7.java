package Algorithm.day44;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P7 {

    static int L, n;
    static int[] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        L = Integer.parseInt(br.readLine());
        S = new int[L+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<L; i++){
            S[i] = Integer.parseInt(st.nextToken());
        }
        S[L] = 0;
        n = Integer.parseInt(br.readLine());
        Arrays.sort(S);

        if (Arrays.binarySearch(S, 0, L + 1, n) >= 0) { //찾았다면
            System.out.println(0);
            return;
        }

        int index = -1;
        for(int i=0; i<L; i++){
            if(n > S[i] && n < S[i+1]) index = i;
        }
        int lowerCnt = (n - S[index] - 1);
        int upperCnt = (S[index + 1] - n - 1);
        int answer = lowerCnt * upperCnt + lowerCnt + upperCnt;
        System.out.println(answer);



    }
}
