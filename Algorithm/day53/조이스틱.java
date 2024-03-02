package Algorithm.day53;

public class 조이스틱 {
    int answer = 987654321;
    public int solution(String name) {
        int n = name.length();
        int[] pressBtn = new int[n];
        int toBeUpdated = 0;
        for(int i=0; i<n; i++){
            pressBtn[i] = Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));
            if(pressBtn[i] != 0) toBeUpdated++;
        }
        solve(0, pressBtn, toBeUpdated, 0);
        return answer;
    }

    void solve(int index, int[] pressBtn, int toBeUpdated, int count){

        if(toBeUpdated == 0){
            answer = Math.min(count, answer);
            return;
        }

        for(int i=0; i<pressBtn.length; i++){
            if(pressBtn[i] == 0) continue;
            //변경
            int tmp = pressBtn[i];
            int diff = Math.abs(index - i);
            int minDist = Math.min(diff, pressBtn.length - diff);
            pressBtn[i] = 0;
            solve(i, pressBtn, toBeUpdated - 1, count + tmp + minDist);
            pressBtn[i] = tmp;
        }
    }
}
