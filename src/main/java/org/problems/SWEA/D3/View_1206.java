package org.problems.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class View_1206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] Buildings = new int[N];
            int sum = 0;
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++)
                Buildings[j] = Integer.parseInt(st.nextToken());

            for (int j = 2; j < N-2; j++)
                sum += View(Buildings, j);

            System.out.println("#" + (i+1) + " " + sum);
        }
    }

    public static int View(int[] Buildings, int i) {
        int left = Math.max(Buildings[i-2], Buildings[i-1]);
        int right = Math.max(Buildings[i+1], Buildings[i+2]);
        int max = Math.max(left, right);

        if (Buildings[i] > max)
            return Buildings[i]-max;

        return 0;
    }
}
