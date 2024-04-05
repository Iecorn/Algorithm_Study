package org.problems.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CutLog_14692 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            long N = Long.parseLong(br.readLine());
            if (N%2 == 0)
                System.out.println("#" + (i+1) + " Alice");
            else
                System.out.println("#" + (i+1) + " Bob");
        }

    }
}
