package Algorithm.day48;

public class P1 {

    public int[] solution(int[][] arr) {
        int[] answer = solve(arr, 0, 0, arr.length);
        return answer;
    }
    public int[] solve(int[][] arr, int sx, int sy, int n){
        int[] ret = new int[2];
        boolean sameFlag = true;
        int tmp = arr[sx][sy];
        for(int i=sx; i<sx + n; i++){
            for(int j=sy; j<sy + n; j++){
                if(tmp != arr[i][j]) sameFlag = false;
            }
        }
        if(sameFlag){
            ret[tmp]++;
            return ret;
        }
        int[] arr1 = solve(arr, sx, sy, n / 2);
        int[] arr2 = solve(arr, sx, sy + n / 2, n / 2);
        int[] arr3 = solve(arr, sx + n / 2, sy, n / 2);
        int[] arr4 = solve(arr, sx + n / 2, sy + n / 2, n / 2);

        for(int i=0; i<2; i++){
            ret[i] += (arr1[i] + arr2[i] + arr3[i] + arr4[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        P1 p1 = new P1();
        int[] solution = p1.solution(
            new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}});
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
