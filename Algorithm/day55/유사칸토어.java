package Algorithm.day55;

import java.util.stream.LongStream;

public class 유사칸토어 {

    int answer = 0;
    public int solution(int n, long l, long r) {
        return (int)LongStream.range(l - 1, r).map(i -> dfs(i)).sum();
    }
    int dfs(long i){
        if(i % 5 == 2) return 0;
        if(i < 5) return 1;
        return dfs(i / 5);
    }
}
