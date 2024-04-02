package org.problems.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringString_17319 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String answer;

            String word1 = str.substring(0,n/2);
            String word2 = str.substring(n/2, n);

            if(word1.equals(word2))
                answer = "Yes";
            else
                answer = "No";

            System.out.println("#" + (i+1) + " " + answer);
        }
    }
}
