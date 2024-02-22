package Algorithm.day51;

public class 자물소와열쇠 {
    public boolean solution(int[][] key, int[][] lock) {

        int M = key.length;
        int N = lock.length;

        int[][] expandedLock = new int[N * 3][N * 3];
        for (int i = N; i < 2 * N; i++) {
            for (int j = N; j < 2 * N; j++) {
                expandedLock[i][j] = lock[i - N][j - N];
            }
        }

        int r = 0;
        while(r < 4){

            for(int i=0; i <= 3 * N - M; i++){
                for(int j=0; j<= 3 * N - M; j++){
                    if(open(i, j, M, key, expandedLock)) return true;
                }
            }
            r++;
            key = rotate(key);
        }

        return false;
    }

    boolean open(int x, int y, int M, int[][] key, int[][] lock){

        int N = lock.length;
        int[][] _lock = new int[N / 3][N / 3];
        for (int i = 0; i < _lock.length; i++) {
            for (int j = 0; j < _lock.length; j++) {
                _lock[i][j] = lock[i + N / 3][j + N / 3];
            }
        }

        for (int i = x; i < x + M; i++) {
            for (int j = y; j < y + M; j++) {
                if(i >= N / 3 && i < N / 3 * 2 && j >= N / 3 && j < N / 3 * 2) {
                    _lock[i - N / 3][j - N / 3] = _lock[i - N / 3][j - N / 3] ^ key[i - x][j - y];
                }
            }
        }
        for (int i = 0; i < _lock.length; i++) {
            for (int j = 0; j < _lock.length; j++) {
                if (_lock[i][j] == 0) return false;
            }
        }
        return true;
    }

    int[][] rotate(int[][] array){

        int[][] ret = new int[array.length][array[0].length];
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++){
                ret[i][j] = array[j][array.length - i - 1];
            }
        }
        return ret;
    }
}
