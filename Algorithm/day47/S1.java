package Algorithm.day47;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1 {

    static int[] minTree;
    static int[] maxTree;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        array = new int[N];
        for(int i=0; i<N; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        minTree = new int[N * 4];
        maxTree = new int[N * 4];

        init(1, 0, N - 1);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int ql = Integer.parseInt(st.nextToken()) - 1;
            int qr = Integer.parseInt(st.nextToken()) - 1;

            int min = findMin(1, 0, N-1, ql, qr);
            int max = findMax(1, 0, N-1, ql, qr);
            sb.append(min + " " + max + "\n");
        }
        System.out.print(sb);
    }


    static void init(int node, int leftIndex, int rightIndex){

        if(leftIndex == rightIndex){
            minTree[node] = array[leftIndex];
            maxTree[node] = array[leftIndex];
            return;
        }
        int mid = (leftIndex + rightIndex) / 2;

        init(node * 2, leftIndex, mid);
        init(node * 2 + 1, mid + 1, rightIndex);

        minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
        maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
    }

    static int findMax(int node, int leftIndex, int rightIndex, int queryLeft, int queryRight){

        if(queryLeft > rightIndex || queryRight < leftIndex) {
            return 0;
        }
        if(queryLeft <= leftIndex && queryRight >= rightIndex){
            return maxTree[node];
        }

        int mid = (leftIndex + rightIndex) / 2;

        int lMax = findMax(node * 2, leftIndex, mid, queryLeft, queryRight);
        int rMax = findMax(node * 2 + 1, mid + 1, rightIndex, queryLeft, queryRight);

        return Math.max(lMax, rMax);
    }

    static int findMin(int node, int leftIndex, int rightIndex, int queryLeft, int queryRight){
        if(queryLeft > rightIndex || queryRight < leftIndex) {
            return Integer.MAX_VALUE;
        }
        if(queryLeft <= leftIndex && queryRight >= rightIndex){
            return minTree[node];
        }

        int mid = (leftIndex + rightIndex) / 2;

        int lMin = findMin(node * 2, leftIndex, mid, queryLeft, queryRight);
        int rMin = findMin(node * 2 + 1, mid + 1, rightIndex, queryLeft, queryRight);

        return Math.min(lMin, rMin);
    }

}
