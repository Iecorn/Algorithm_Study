package org.problems.BackJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Cram_14728
public class StormHit_14728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][T + 1];
        int[] t = new int[N + 1];
        int[] s = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            t[i] = Integer.parseInt(st.nextToken());
            s[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= T; j++) {
                if (j >= t[i])
                    dp[i][j] = Math.max(s[i] + dp[i - 1][j - t[i]], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }

        }
        System.out.println(dp[N][T]);
    }
}
