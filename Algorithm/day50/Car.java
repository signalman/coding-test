package Algorithm.day50;

import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Car {

    public int solution(String[][] relation) {
        int answer = 0;
        PriorityQueue<BitSet> pq = new PriorityQueue<>(Comparator.comparing(BitSet::cardinality));
        containAll(pq, relation);
        while(!pq.isEmpty()){

            BitSet keySet = pq.poll();
            if(isCandidateKey(keySet, relation)){
                pq.removeIf(bs -> contain(keySet, bs));
                answer++;
            }
        }

        return answer;
    }

    void containAll(Collection<BitSet> pq, String[][] relation){
        int end = (1 << relation[0].length);
        for (int i = 1; i < end; i++) {
            BitSet c = BitSet.valueOf(new long[]{i});
            pq.add(c);
        }
    }

    boolean isCandidateKey(BitSet bitset, String[][] relation){
        Set<String> keySet = new HashSet<>();
        String[] combinedKey = combine(bitset, relation);
        for (String key : combinedKey) {
            if(!keySet.add(key)) return false;
        }
        return true;
    }

    private String[] combine(BitSet bitset, String[][] relation) {
        int nCols = relation[0].length;
        int nRows = relation.length;
        String[] keys = new String[nRows];
        for (int i = 0; i < nRows; i++) {
            keys[i] = "";
        }

        for (int j = 0; j < nCols; j++) {
            if(!bitset.get(j)) continue;
            for (int i = 0; i < nRows; i++) {
                keys[i] += relation[i][j] + "_";
            }
        }
        return keys;
    }

    boolean contain(BitSet parent, BitSet bitSet) {
        BitSet clone = (BitSet) bitSet.clone();
        clone.and(parent);
        return clone.equals(bitSet);
    }

    /*
    *
    * public int solution(String[][] relation) {
        int answer = 0;
        int nCols = relation[0].length;

        Queue<BitSet> queue = new PriorityQueue<>(Comparator.comparing(BitSet::cardinality));
        addAllCases(queue, nCols);

        while (!queue.isEmpty()) {
            BitSet colCase = queue.remove();

            if (isCandidateKey(relation, colCase)) {
                queue.removeIf(bs -> contains(bs, colCase));
                answer += 1;
            }
        }

        return answer;
    }

    private boolean isCandidateKey(String[][] relation, BitSet colCase) {
        String[] combinedKeys = combineKeys(relation, colCase);
        Set<String> keys = new HashSet<>();
        for (String key : combinedKeys) {
            if (!keys.add(key)) {
                return false;
            }
        }
        return true;
    }

    private String[] combineKeys(String[][] relation, BitSet colCase) {
        int nRows = relation.length;
        int nCols = relation[0].length;

        String[] keys = new String[nRows];
        for (int r = 0; r < nRows; r++) {
            keys[r] = "";
        }

        for (int c = 0; c < nCols; c++) {
            if (!colCase.get(c)) {
                continue;
            }

            for (int r = 0; r < nRows; r++) {
                keys[r] += relation[r][c] + "_";
            }
        }
        return keys;
    }

    private boolean contains(BitSet parent, BitSet colCase) {
        BitSet bs = (BitSet) colCase.clone();
        bs.and(parent);
        return bs.equals(colCase);
    }

    private void addAllCases(Collection<BitSet> list, int nCols) {
        int end = 1 << nCols;
        for (int i = 1; i < end; i++) {
            BitSet c = BitSet.valueOf(new long[] { i });
            list.add(c);
        }
    }
    *
    * */

}
