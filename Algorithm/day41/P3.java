package Algorithm.day41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P3 {

    static int N, M;
    static List<Integer> books;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        books = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            books.add(Integer.parseInt(st.nextToken()));
        }
        books.add(0);
        Collections.sort(books);

        int pivot = 0;
        for(int i=0; i<N+1; i++){
            if(books.get(i) == 0) pivot = i;
        }

        int ans = 0;
        for(int i=0; i<pivot; i+=M){
            ans += Math.abs(books.get(i)) * 2;
        }

        for(int i=N; i>pivot; i-=M){
            ans += Math.abs(books.get(i)) * 2;
        }

        int mx = Collections.max(
                books.stream()
                        .map(i->Math.abs(i))
                        .collect(Collectors.toList())
        );


//        int mx = 0;
        for(int i=0; i<N+1; i++){
            mx = Math.max(mx, Math.abs(books.get(i)));
        }
        ans -= mx;
        System.out.println(ans);
    }
}

