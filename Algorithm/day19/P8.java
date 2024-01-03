package Algorithm.day19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P8 {
    static int MERGE_INDEX = -1;
    static int VALUE_INDEX = -1;
    
    static int[][] mergeTable = new int[50][50];
    static List<int[]>[] mergeList = new List[2000]; //같은 값을 가지면 merge
    static String[][] valueTable = new String[50][50];
    static Map<String, Integer> valueMap = new HashMap<>(); //String-Integer 변환을 위함
    static List<int[]>[] valueList = new List[2000];

    public void updateCell(int r, int c, String value){
        String beforeValue = valueTable[r][c];
        int idx = valueMap.get(beforeValue);
        int key = -1;
        if(valueMap.containsKey(value)){
            key = valueMap.get(value);
        }
        else{
            valueMap.put(value, ++VALUE_INDEX);
            key = VALUE_INDEX;
        }
        //병합된 셀일때
        if(mergeTable[r][c] != 0){
            //병합 셀들 값 변경
            for(int[] cell: mergeList[mergeTable[r][c]]){
                valueList[idx].remove(new int[]{cell[0], cell[1]});
                valueTable[cell[0]][cell[1]] = value;
                valueList[key].add(new int[]{cell[0], cell[1]});
            }
        }
        //병합되지 않은 셀일때
        else{
            valueList[idx].remove(new int[]{r, c});
            valueTable[r][c] = value;
            valueList[key].add(new int[]{r, c});
        }

    }
    public void updateValue(String value1, String value2){
        int beforeIndex = valueMap.get(value1);
        int afterIndex = valueMap.containsKey(value2) ? valueMap.get(value2) : ++VALUE_INDEX;

        for(int[] cell: valueList[beforeIndex]){
            valueList[afterIndex].add(cell);
            valueTable[cell[0]][cell[1]] = value2;
        }
        valueList[beforeIndex].clear();
    }

    public void mergeCell(int r1, int c1, int r2, int c2){
        if(r1 == r2 && c1 == c2) return;
        String value = valueTable[r1][c1];
        if(value.equals("")){
            value = valueTable[r2][c2];
        }
        ++MERGE_INDEX;
        int m1 = mergeTable[r1][c1];
        int m2 = mergeTable[r2][c2];

        for(int[] cell: mergeList[m1]){
            mergeList[MERGE_INDEX].add(cell);
            mergeTable[cell[0]][cell[1]] = MERGE_INDEX;
            valueTable[cell[0]][cell[1]] = value;
        }
        for(int[] cell: mergeList[m2]){
            mergeList[MERGE_INDEX].add(cell);
            mergeTable[cell[0]][cell[1]] = MERGE_INDEX;
            valueTable[cell[0]][cell[1]] = value;
        }
    }
    public void unmergeCell(int r, int c){
        int m = mergeTable[r][c];
        String beforeValue = valueTable[r][c];
        for(int[] cell: mergeList[m]){
            mergeTable[cell[0]][cell[1]] = 0;
            valueTable[cell[0]][cell[1]] = "";
            mergeList[m].removeIf(ints -> (ints[0] == r && ints[1] == c));
        }
        valueTable[r][c] = beforeValue;
        mergeList[m].add(new int[]{r, c});
    }
    public void printCell(int r, int c){
        String value = valueTable[r][c].equals("") ? "EMPTY": valueTable[r][c];
        System.out.println(value);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.stream().toArray();
    }
}
