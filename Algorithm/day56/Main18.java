package Algorithm.day56;

public class Main18 {

    public String solution(String phone_number) {
        StringBuilder answer = new StringBuilder();
        int n = phone_number.length();
        int count = 0;
        for(int i=n-1; i>=0; i--){
            if(count < 4){
                answer.insert(0, phone_number.charAt(i));
                count++;
            }
            else answer.insert(0, "*");
        }
        return answer.toString();
    }
}
