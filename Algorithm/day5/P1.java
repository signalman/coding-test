import java.util.LinkedList;
import java.util.ListIterator;
public class P1 {

    int H, W, length;
    LinkedList<Character>[] memo;
    int[][] countAlphabet;
    int[] cursor;

    void init(int H, int W, char mStr[])
    {
        this.H = H;
        this.W = W;

        memo = new LinkedList[H];
        for(int i = 0; i < H; i++) {
            memo[i] = new LinkedList<>();
            countAlphabet = new int[H][26];
        }

        length = 0;
        for(int i = 0; mStr[i] != '\0'; i++) {
            memo[i/W].addLast(mStr[i]);
            countAlphabet[i/W][mStr[i]-'a']++;
            length++;
        }

        cursor = new int[] {0, 0};
    }

    void insert(char mChar)
    {
        int h = cursor[0];
        int w = cursor[1];
        memo[h].add(w, mChar);
        countAlphabet[h][mChar-'a']++;

        for(int i = cursor[0]; i < H; i++) {
            if(memo[i].size() <= W) {
                break;
            }
            char last = memo[i].pollLast();
            countAlphabet[i][last-'a']--;
            memo[i+1].addFirst(last);
            countAlphabet[i+1][last-'a']++;
        }

        if(++w == W) {
            h++;
            w = 0;
        }

        cursor[0] = h;
        cursor[1] = w;
        length++;
    }

    char moveCursor(int mRow, int mCol)
    {
        mRow--; mCol--;
        if(length > mRow * W + mCol) {
            cursor[0] = mRow;
            cursor[1] = mCol;
            return memo[mRow].get(mCol);
        }

        cursor[0] = length/W;
        cursor[1] = length%W;
        return '$';
    }

    int countCharacter(char mChar)
    {
        int count = 0;
        if(memo[cursor[0]].size() == 0) {
            return 0;
        }
        ListIterator<Character> it = memo[cursor[0]].listIterator(cursor[1]);
        while(it.hasNext()) {
            if(it.next() == mChar) {
                count++;
            }
        }
        for(int h = cursor[0] + 1; h < H; h++) {
            count += countAlphabet[h][mChar - 'a'];
        }

        return count;
    }
}
