package org.problems.SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Russia_4613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] flag = new int[N][3]; // W, B, R

            for (int j = 0; j < N; j++) {
                String str = br.readLine();
                for (int k = 0; k < M; k++) {
                    switch (str.charAt(k)) {
                        case 'W':
                            flag[j][0] += 1;
                            break;
                        case 'B':
                            flag[j][1] += 1;
                            break;
                        case 'R':
                            flag[j][2] += 1;
                            break;
                    }
                }
            }

            int min = Integer.MAX_VALUE;

            //W
            for (int j = 1; j < N-1; j++) {
                //B
                for (int k = 1; k < N-j; k++) {
                    int sum = 0;
                    //R
                    for (int l = 0; l < j; l++)
                        sum += M - flag[l][0];
                    for (int l = j; l < j+k; l++)
                        sum += M -flag[l][1];
                    for (int l = j+k; l < N; l++)
                        sum += M - flag[l][2];
                    min = Math.min(min, sum);
                }
            }
            System.out.println("#" + (i + 1) + " " + (min));
        }
    }
}
