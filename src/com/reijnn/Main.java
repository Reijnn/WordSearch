package com.reijnn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by niels on 07/07/2017.
 */
public class Main {
    private static String[] words = new String[]{"watergracht", "een", "gitaar", "ook", "niemand", "nu",
            "dom", "of", "boom", "viool"};

    public static void main(String[] args) throws IOException {
        //Read text from file
        BufferedReader input = new BufferedReader(new FileReader(System.getProperty("user.home") + "/Desktop/tekst"));
        StringBuilder stringBuilder = new StringBuilder();

        for (String line; (line = input.readLine()) != null; ) {
            stringBuilder.append(line);
        }
        input.close();

        //Search words with KMP
        for (String word : words) {
            KMP kmp = new KMP(word);
            System.out.println(kmp.search(stringBuilder.toString()));
        }

        //Search words with BoyerMoore
        for (String word : words) {
            BoyerMoore boyer = new BoyerMoore(word);
            System.out.println(boyer.search(stringBuilder.toString()));
        }
    }
}
