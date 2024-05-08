package org.problems.SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mode_1204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] scores = new int[101];
            int maxIndex = 0;
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 1000; j++)
                scores[Integer.parseInt(st.nextToken())] += 1;

            for (int j = 0; j < 101; j++)
                if (scores[j] >= scores[maxIndex])
                    maxIndex = j;

            System.out.println("#" + N + " " + maxIndex);
        }
    }
}
