package org.problems.BackJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin_9084 {
    static int T, N, M, coin[];
    static long dp[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++) {
            N = Integer.parseInt(br.readLine());
            coin = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++) coin[i] = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(br.readLine());

            dp = new long[M+1];
            dp[0] = 1;
            for(int i=1;i<=N;i++) {
                for(int j=coin[i];j<=M;j++) dp[j] += dp[j-coin[i]];
            }
            sb.append(dp[M]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int T = Integer.parseInt(br.readLine());
//        for (int i = 0; i < T; i++) {
//            int N = Integer.parseInt(br.readLine());
//            int[] coins = new int[N + 1];
//            st = new StringTokenizer(br.readLine(), " ");
//            for (int j = 1; j <= N; j++) {
//                coins[j] = Integer.parseInt(st.nextToken());
//            }
//            int M = Integer.parseInt(br.readLine());
//
//            long[] dp = new long[M + 1];
//
//            for (int j = 1; j <= N; j++) {
//                for (int k = 1; k <= M; k++) {
//                    if (k - coins[j] > 0) dp[k] = dp[k] + dp[k - coins[j]];
//                    else if (k - coins[j] == 0) dp[k]++;
//                }
//            }
//            System.out.println(dp[M]);
//        }
//    }
}