package org.problems.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MemoryRestore_1289 {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int answer = 0;
            int before = 0;
            String num = br.readLine();
            for(int j = 0; j < num.length(); j++) {
                int current = num.charAt(j) - '0';
                if(before != current) {
                    before = current;
                    answer++;
                }
            }

            System.out.println("#" + (i+1) + " " + answer);
        }

    }
}
