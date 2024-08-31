package org.problems.BackJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Coffee_22115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[K+1];
        int[] caffeine = new int[N+1];
        caffeine[0] = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            caffeine[i] = Integer.parseInt(st.nextToken());
        }

        //카페인 작은 순서대로
        Arrays.sort(caffeine);
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= N ; i++) {
            for (int j = K; j >= 0; j--) {
                if (j - caffeine[i] >= 0 && dp[j-caffeine[i]] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j-caffeine[i]] + 1);
            }
        }
        System.out.println(dp[K] > K ? -1 : dp[K]);
    }
}
