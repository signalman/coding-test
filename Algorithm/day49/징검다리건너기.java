package Algorithm.day49;

public class 징검다리건너기 {

    int[] maxTree;
    int[] stones;

    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        this.maxTree = new int[stones.length * 4];
        this.stones = stones;
        init(1, 0, stones.length - 1);

        for(int i=0; i <= stones.length-k; i++){
            answer = Math.min(answer, max(1, 0, stones.length -1, i, i + k - 1));
        }
        return answer;
    }

    public void init(int node, int left, int right){
        if(left == right){
            maxTree[node] = stones[left];
            return;
        }

        int mid = (left + right)/ 2;
        init(node * 2, left, mid);
        init(node * 2 + 1, mid + 1, right);
        maxTree[node] = Math.max(maxTree[node * 2], maxTree[node*2 + 1]);
    }

    public int max(int node, int left, int right, int queryLeft, int queryRight){

        if(queryRight < left || queryLeft > right) return 0;
        if(queryLeft <= left && right <= queryRight) return maxTree[node];

        int mid = (left + right) / 2;
        int leftMax = max(node * 2, left, mid, queryLeft, queryRight);
        int rightMax = max(node * 2 + 1, mid + 1, right, queryLeft, queryRight);
        return Math.max(leftMax, rightMax);
    }
}
