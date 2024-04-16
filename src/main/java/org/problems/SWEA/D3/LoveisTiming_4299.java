package org.problems.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LoveisTiming_4299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int D = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int result = (D - 11) * 24 * 60 + (H - 11) * 60 + (M - 11);

            if (result < 0)
                result = -1;

            System.out.println("#" + (i + 1) + " " + (result));
        }
    }
}