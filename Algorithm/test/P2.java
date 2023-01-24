package Algorithm.test;
import java.util.Scanner;
public class P2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // n * n 크기 배열 선언 ( 지도 )
        int[][] map = new int[n][n];

        // 지도 정보 입력 받기
        for ( int i = 0 ; i < n ; i++ ) {
            for ( int j=0 ; j <n ; j++ ) {
                map[i][j] = sc.nextInt();
            }
        }

        // 최대값 저장
        int maxDistance = 0;

        for ( int i=0 ; i <n ; i++ ) {
            for ( int j=0 ; j < n ; j++ ) {

                // 지금 위치가 섬인지 검사
                if ( map[i][j] == 1 ) {

                    // 섬이면 현재 위치로부터 사방탐색 하여 가로 또는 세로에 있는 섬과 거리 측정, 최대값 저장

                    // 동쪽이 1인지 검사
                    for (int d = 1; d < n - j ; d++) {
                        if ( map[i][j + d] == 1) {
                            maxDistance = Math.max( maxDistance , d);
                            break;
                        }
                    }

                    // 서쪽이 1인지 검사
                    for (int d = 1; d <= j ; d++) {
                        if ( map[i][j - d] == 1 ) {
                            maxDistance = Math.max( maxDistance , d);
                            break;
                        }
                    }

                    // 북쪽이 1인지 검사
                    for (int d = 1; d <= i ; d++) {
                        if ( map[i-d][j] == 1 ) {
                            maxDistance = Math.max( maxDistance , d );
                            break;
                        }
                    }

                    // 남쪽이 1인지 검사
                    for (int d = 1; d < n - i; d++) {
                        if ( map[i+d][j] == 1) {
                            maxDistance = Math.max( maxDistance , d);
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(maxDistance);

    }
}
