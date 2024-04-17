package org.problems.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SexagenaryCycle_19185 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String[] Nwords = br.readLine().split(" ");
            String[] Mwords = br.readLine().split(" ");

            int Q = Integer.parseInt(br.readLine());

            System.out.print("#" + (i + 1));
            for (int j = 0; j < Q; j++) {
                int year = Integer.parseInt(br.readLine());
                int nIndex = (year % N) - 1 == -1 ? N - 1 : (year % N) - 1;
                int mIndex = (year % M) - 1 == -1 ? M - 1 : (year % M) - 1;

                System.out.print(" " + Nwords[nIndex] + Mwords[mIndex]);
            }
            System.out.println();
        }
    }
}
