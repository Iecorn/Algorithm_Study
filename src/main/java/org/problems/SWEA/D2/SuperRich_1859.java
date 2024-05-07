package org.problems.SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SuperRich_1859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i < T+1; i++) {
            int N = Integer.parseInt(br.readLine());
            long[] prices = new long[N];
            long answer = 0;
            long max = 0;
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++)
                prices[j] = Integer.parseInt(st.nextToken());

            for(int j = N-1; j >= 0; j--) {
                max = Math.max(max, prices[j]);
                answer += max > prices[j] ? max - prices[j] : 0;
            }

            System.out.println("#"+i+" " + answer);
        }
    }
}
