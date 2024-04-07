package Algorithm.day56;

public class Main2 {
    public int solution(String t, String p) {
        int answer = 0;

        for(int i=0; i<=t.length() - p.length(); i++){
            String subs = t.substring(i, i + p.length());
            if(Long.parseLong(subs) <= Long.parseLong(p)) answer++;
        }

        return answer;
    }
}
