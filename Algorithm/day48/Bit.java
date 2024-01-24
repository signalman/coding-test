package Algorithm.day48;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Bit {

    public static List<Integer> hexagonPattern(int n) {
        if (n == 1) {
            return Arrays.asList(1);
        }

        int nRows = 4 * n - 3;
        List<Deque<Integer>> rows = new ArrayList<>();

        for (int i = 0; i < nRows; i++) {
            rows.add(new ArrayDeque<>());
        }

        int lineDim = n - 1;
        int crtNum = 1;
        int startRow = 0;

        while (n > 0) {
            int crtRow = startRow;

            if (lineDim == 0) {
                rows.get(crtRow).add(crtNum);
                break;
            }

            for (int lineNo = 0; lineNo < 6; lineNo++) {
                for (int i = 0; i < lineDim; i++) {
                    if (crtRow >= nRows) {
                        continue;
                    }

                    if (lineNo < 3) {
                        rows.get(crtRow).addLast(crtNum);
                    } else {
                        rows.get(crtRow).addFirst(crtNum);
                    }

                    crtNum++;

                    if (lineNo == 1) {
                        crtRow += 2;
                    } else if (lineNo == 4) {
                        crtRow -= 2;
                    } else if (lineNo < 3) {
                        crtRow++;
                    } else {
                        crtRow--;
                    }
                }
            }

            n--;
            lineDim--;
            startRow += 2;
        }

        List<Integer> result = new ArrayList<>();
        for (Deque<Integer> row : rows) {
            result.addAll(row);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> pattern = hexagonPattern(2);
        for (int num : pattern) {
            System.out.print(num + " ");
        }
    }

}
