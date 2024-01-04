package Algorithm.day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TT {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String text = br.readLine();
        String pattern = br.readLine();

        List<Integer> matches = rabinKarp(text, pattern);
        sb.append(matches.size()).append('\n');
        for (int match : matches) {
            sb.append(match).append(" ");
        }
        System.out.println(sb);
    }

    private static List<Integer> rabinKarp(String text, String pattern) {
        List<Integer> positions = new ArrayList<>();
        int tLength = text.length();
        int pLength = pattern.length();
        long patternHash = 0, textHash = 0, power = 1;

        for (int i = 0; i < pLength; i++) {
            patternHash = (patternHash * 256 + pattern.charAt(i)) % MOD;
            textHash = (textHash * 256 + text.charAt(i)) % MOD;
            if (i < pLength - 1) {
                power = (power * 256) % MOD;
            }
        }

        for (int i = 0; i <= tLength - pLength; i++) {
            if (patternHash == textHash) {
                boolean match = true;
                for (int j = 0; j < pLength; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    positions.add(i + 1);  // 1-indexed position
                }
            }

            if (i < tLength - pLength) {
                textHash = (256 * (textHash - text.charAt(i) * power) + text.charAt(i + pLength)) % MOD;
                if (textHash < 0) textHash += MOD;
            }
        }

        return positions;
    }
}
