package org.problems.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dictation_9317 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            String s1 = br.readLine();
            String s2 = br.readLine();
            int answer = 0;

            for(int j = 0; j < N; j++)
                if(s1.charAt(j) == s2.charAt(j))
                    answer++;

            System.out.println("#" + (i+1) + " " + answer);
        }
    }
}
