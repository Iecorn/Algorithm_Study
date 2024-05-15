package org.problems.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sum_1209 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 10; i++) {
            int T = Integer.parseInt(br.readLine());
            int[][] arrays = new int[100][100];
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < 100;j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int k = 0; k < 100; k++) {
                    arrays[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println("#" + T + " " + findMax(arrays));
        }

    }

    public static int findMax(int[][] arrays) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        //row
        for(int i = 0; i < 100; i++) {
            sum = 0;
            for(int j = 0; j < 100; j++) {
                sum += arrays[i][j];
            }
            max = Math.max(sum,max);
        }
        //col
        for(int i = 0; i < 100; i++) {
            sum = 0;
            for(int j = 0; j < 100; j++) {
                sum += arrays[j][i];
            }
            max = Math.max(sum,max);
        }
        //cross
        sum = 0;
        for(int i = 0; i < 100; i++) {
            sum += arrays[i][i];
        }
        max = Math.max(max, sum);
        sum = 0;
        for(int i = 0; i < 100; i++) {
            sum += arrays[i][99-i];
        }
        max = Math.max(max, sum);

        return max;
    }
}
