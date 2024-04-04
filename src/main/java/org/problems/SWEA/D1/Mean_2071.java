package org.problems.SWEA.D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mean_2071 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            double sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++)
                sum += Integer.parseInt(st.nextToken());

            System.out.println("#" + (i+1) + " " + Math.round(sum/10));
        }


    }
}
