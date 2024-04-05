package org.problems.SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinAdd_17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            int min = 99999999;

            for (int j = 1; j < str.length(); j++) {
                int a = Integer.parseInt(str.substring(0,j));
                int b = Integer.parseInt(str.substring(j, str.length()));
                min = Math.min(min, a+b);
            }

            System.out.println("#" + (i+1) + " " + min);

        }

    }
}


