package Algorithm.day19;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SegmentTree {

    static int n;
    static int[] a, maxTree, minTree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int test = 1; test <= t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append("#").append(test).append(" ");
            a = new int[n];
            maxTree = new int[4 * n];
            minTree = new int[4 * n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            init(1, 0, n - 1);

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int query = Integer.parseInt(st.nextToken());
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());

                if (query == 0) {
                    update(1, 0, n - 1, left, right);
                } else if (query == 1) {
                    int max = queryMax(1, 0, n - 1, left, right - 1);
                    int min = queryMin(1, 0, n - 1, left, right - 1);
                    sb.append(max - min).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    // 세그먼트 트리 초기화
    public static void init(int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            maxTree[node] = a[nodeLeft];
            minTree[node] = a[nodeLeft];
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;

        init(
            node * 2,
            nodeLeft,
            mid
        );

        init(
            node * 2 + 1,
            mid + 1,
            nodeRight
        );

        maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
        minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
    }

    // 세그먼트 트리 갱신
    public static void update(int node, int nodeLeft, int nodeRight, int queryIndex, int value) {
        if (queryIndex < nodeLeft || nodeRight < queryIndex) {
            return;
        }

        if (nodeLeft == nodeRight) {
            maxTree[node] = value;
            minTree[node] = value;
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;

        update(
            node * 2,
            nodeLeft,
            mid,
            queryIndex,
            value
        );

        update(
            node * 2 + 1,
            mid + 1,
            nodeRight,
            queryIndex,
            value
        );

        maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
        minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
    }

    // 최대값 쿼리
    public static int queryMax(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight) {
        if (queryRight < nodeLeft || nodeRight < queryLeft) {
            return 0;
        }

        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            return maxTree[node];
        }

        int mid = (nodeLeft + nodeRight) / 2;
        int leftMax = queryMax(
            node * 2,
            nodeLeft,
            mid,
            queryLeft,
            queryRight
        );
        int rightMax = queryMax(
            node * 2 + 1,
            mid + 1,
            nodeRight,
            queryLeft,
            queryRight
        );

        return Math.max(leftMax, rightMax);
    }

    // 최소값 쿼리
    static int queryMin(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight) {
        if (queryLeft > nodeRight || queryRight < nodeLeft) {
            return Integer.MAX_VALUE;
        }

        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            return minTree[node];
        }

        int mid = (nodeLeft + nodeRight) / 2;
        int leftMin = queryMin(
            node * 2,
            nodeLeft,
            mid,
            queryLeft,
            queryRight
        );
        int rightMin = queryMin(
            node * 2 + 1,
            mid + 1,
            nodeRight,
            queryLeft,
            queryRight
        );

        return Math.min(leftMin, rightMin);
    }

}
