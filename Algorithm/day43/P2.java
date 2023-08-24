package Algorithm.day43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2 {
    static int N, M;

    static class Station {
        int id;
        Station next;
        Station prev;

        Station(int id){
            this.id = id;
            next = null;
            prev = null;
        }
    }
    static class Stations{
        Station head;
        Station tail;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int id = Integer.parseInt(st.nextToken());
        }



    }
}
