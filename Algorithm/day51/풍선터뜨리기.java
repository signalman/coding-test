package Algorithm.day51;

public class 풍선터뜨리기 {

    public int solution(int[] a) {
        int answer = 0;
        int[] leftMin = new int[a.length]; //i를 기준으로 왼쪽의 최솟값 저장
        int[] rightMin = new int[a.length]; //i를 기준으로 오른쪽의 최솟값 저장

        for(int i=0; i<a.length; i++){
            leftMin[i] = Integer.MAX_VALUE;
            if(i -1 >= 0)
                leftMin[i] = Math.min(leftMin[i-1], a[i-1]);
        }
        for(int i=a.length - 1; i >= 0; i--){
            rightMin[i] = Integer.MAX_VALUE;
            if(i + 1 < a.length)
                rightMin[i] = Math.min(rightMin[i + 1], a[i + 1]);
        }

        for(int i=0; i<a.length; i++){
            if(i == 0 || i == a.length - 1) continue;
            if(a[i] > leftMin[i] && a[i] > rightMin[i]) answer++;
        }
        return a.length - answer;
    }

}
