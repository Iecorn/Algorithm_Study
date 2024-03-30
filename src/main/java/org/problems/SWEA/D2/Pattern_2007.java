package org.problems.SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pattern_2007 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());



        for (int i = 0; i < T; i++){
            String str = br.readLine();
            int answer = 1;

            while(answer < str.length()){
                String word1 = str.substring(0, answer);
                String word2 = str.substring(answer, answer*2);

                if(word1.contains(word2))
                    break;

                answer++;
            }
            System.out.println("#" + (i+1) + " " + answer);
        }
    }
}
