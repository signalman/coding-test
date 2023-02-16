import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑 {

    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[] arr;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        ans = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Pair> stack = new Stack<>();
        for(int i=N; i>=1; i--){
            while(!stack.isEmpty() && stack.peek().x < arr[i]){
                ans[stack.peek().y] = i;
                stack.pop();
            }
            stack.add(new Pair(arr[i], i)); //값, 위치
        }
        while (!stack.isEmpty()) {
            ans[stack.pop().y] = 0;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);

    }
}
