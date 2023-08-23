package Algorithm.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P7 {

    static int N, M;
    static int[] loc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        loc = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            loc[i] = Integer.parseInt(st.nextToken());
        }

        int mnHeight = 0;
        if (M == 1) {
            System.out.println(N);
            return;
        }

        for(int i=0; i<loc.length; i++){
            if(i == 0){
                mnHeight = Integer.max(mnHeight, loc[i]);
            }
            else if(i == loc.length - 1){
                mnHeight = Integer.max(mnHeight, (N - loc[i]));
            }
            else{
                mnHeight = (loc[i+1] - loc[i]) % 2 == 0 ? Integer.max(mnHeight, (loc[i+1] - loc[i])/2) : Integer.max(mnHeight, (loc[i+1] - loc[i])/2 + 1);
            }
        }
        System.out.println(mnHeight);
    }
}
