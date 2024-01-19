package Algorithm.day46;

public class Main4 {

    static long solution(long num){
        char[] tmp = String.valueOf(num + 1).toCharArray();
        for(int i=0; i<tmp.length; i++){
            if(tmp[i] == '0') tmp[i] = '1';
        }
        return Long.parseLong(String.valueOf(tmp));
    }

    public int[] solution(int[] arrA, int[] arrB) {
        int arrA_idx = 0, arrB_idx = 0;
        int arrA_len = arrA.length;
        int arrB_len = arrB.length;
        int answer[] = new int[arrA_len + arrB_len];
        int answer_idx = 0;
        while(arrA_idx < arrA_len && arrB_idx < arrB_len){
            if(arrA[arrA_idx] < arrB[arrB_idx])
                answer[answer_idx++] = arrA[arrA_idx++];
            else
                answer[answer_idx++] = arrB[arrB_idx++];
        }
        while(arrA_idx < arrA_len)
        answer[answer_idx++] = arrA[arrA_idx++];
        while(arrB_idx < arrB_len)
        answer[answer_idx++] = arrB[arrB_idx++];
        return answer;
    }

    public int[] solution(int N, int[] votes) {
        int voteCounter[] = new int[11];
        for (int i = 0; i < votes.length; i++) {
            voteCounter[votes[i]] += 1;
        }
        int maxVal = 0;
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (maxVal < voteCounter[i]) {
                maxVal = voteCounter[i];
                cnt = 1;
            }
            else if(maxVal == voteCounter[i]){
                cnt += 1;
            }
        }
        int answer[] = new int[cnt];
        for (int i = 1, idx = 0; i <= N; i++){
            if (voteCounter[i] == maxVal) {
                answer[idx] = voteCounter[i];
                idx += 1;
            }
        }
        return answer;
    }



    public int func(int record){
        if(record == 0) return 1;
        else if(record == 1) return 2;
        return 0;
    }

//    public int solution(int[] recordA, int[] recordB){
//        int cnt = 0;
//        for(int i = 0; i < recordA.length; i++){
//            if(recordA[i] == recordB[i])
//                continue;
//            else if(recordA[i] == func(recordB[i]))
//                cnt = cnt + 3;
//            else
//                cnt = cnt - 1;
//        }
//        return cnt;
//    }




    public static void main(String[] args) {
        System.out.println(solution(9949999));
    }
}
