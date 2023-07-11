//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//
//	//출력문을 저장할 StringBuilder 생성
//	static StringBuilder sb = new StringBuilder("");
//
//	//길이 N에 대한 i행 j열의 값에 대해 판별하는 함수
//	static void starOrSpace(int i, int j, int N) {
//
//		//프랙탈의 가운데 부분은 공백을 넣는다.
//		if(i / N % 3 == 1 && j / N % 3 == 1) sb.append(" ");
//
//		//
//		else if(N == 1) sb.append("*");
//
//		//
//		else starOrSpace(i, j, N/3);
//	}
//
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) {
//				starOrSpace(i, j, N);
//			}
//			sb.append('\n');
//		}
//		System.out.println(sb);
//	}
//}
