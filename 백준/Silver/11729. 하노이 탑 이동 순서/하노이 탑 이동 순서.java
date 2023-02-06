import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder("");
	
	static int hanoi(int N, int st, int en) {
		if(N==1) {
			sb.append(st).append(" ").append(en).append('\n');
			return 1;
		}
		int nen = 0;
		for(int i=1; i<=3; i++) {
			if(i != st && i != en) nen = i;
		}
		return hanoi(N-1, st, nen)+ hanoi(1, st, en) + hanoi(N-1, nen, en);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(hanoi(N, 1, 3));
		System.out.println(sb);
	}
}
