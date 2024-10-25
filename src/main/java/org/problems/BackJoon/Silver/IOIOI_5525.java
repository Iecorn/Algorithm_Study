package org.problems.BackJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOIOI_5525 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    char[] S = br.readLine().trim().toCharArray();
//    String S = br.readLine().trim();
    int[] memo = new int[M];
    int answer = 0;

//    String P = "IOI";
//
//    for (int i = 1; i < N; i++) {
//      P += "OI";
//    }

//    StringBuilder sb = new StringBuilder("IOI");
//
//    for (int i = 1; i < N; i++) {
//      sb.append("OI");
//    }
//
//    String P = sb.toString();

    for (int i = 1; i < M - 1; i++) {
      if(S[i] == 'O' &&  S[i+1] == 'I') {
        memo[i + 1] = memo[i - 1] + 1;

        if (memo[i + 1] >= N && S[i - 2 * N + 1] == 'I')
          answer++;
      }
    }

//    for (int i = 0; i <= M - P.length(); i++) {
//      if(S.substring(i, i + P.length()).equals(P)){
//        answer += 1;
//      }
//    }

    System.out.println(answer);
  }
}
