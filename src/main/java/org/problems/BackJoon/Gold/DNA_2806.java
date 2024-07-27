package org.problems.BackJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DNA_2806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String dna = br.readLine();

        int answer = 0;
        char before = 'A';

        for (int i = N-1; i >= 0; i--) {
            char current = dna.charAt(i);
            if(current != before){
                if(i-1 >= 0 && current != dna.charAt(i-1)){
                    answer++;
                }
                else if(i-1>= 0 && current == dna.charAt(i-1)){
                    before = current;
                    answer++;
                }
                else {
                    before = current;
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
