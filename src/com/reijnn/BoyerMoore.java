package com.reijnn;

/**
 * Created by niels on 07/07/2017.
 */
class BoyerMoore {
    private int[] right;
    private String pat;

    BoyerMoore(String pat) { // Compute skip table.
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        right = new int[R];
        for (int c = 0; c < R; c++)
            right[c] = -1; // -1 for chars not in pattern
        for (int j = 0; j < M; j++) // rightmost position for
            right[pat.charAt(j)] = j; // chars in pattern
    }

    String search(String txt) {
        int N = txt.length();
        int M = pat.length();
        int skip, compares = 0, count = 0;
        for (int i = 0; i <= N - M; i += skip) {
            skip = 0;
            for (int j = M - 1; j >= 0; j--) {
                compares++;
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    skip = Math.max(1, j - right[txt.charAt(i + j)]);
                    break;
                }
            }
            if (skip == 0) {
                count++;
                skip++;
            }
        }
        return "Pattern: " + pat + " Compares: " + compares + " Word count: " + count;
    }
}