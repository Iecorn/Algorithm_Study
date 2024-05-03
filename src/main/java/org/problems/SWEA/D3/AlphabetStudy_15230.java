package org.problems.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlphabetStudy_15230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String alphabets = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < T; i++) {
            int answer = 0;
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                if(alphabets.charAt(j) == str.charAt(j))
                    answer++;
                else
                    break;
            }
            System.out.println("#" + (i+1) + " " + answer);
        }
    }
}
