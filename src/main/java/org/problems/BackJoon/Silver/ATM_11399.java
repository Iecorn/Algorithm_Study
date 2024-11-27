package org.problems.BackJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ATM_11399 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    List<Integer> P = new ArrayList<>();

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    for (int i = 0; i < N; i++) {
      P.add(Integer.parseInt(st.nextToken()));
    }

    Collections.sort(P);

    int answer = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N - i; j++) {
        answer += P.get(j);
      }
    }

    System.out.println(answer);

  }
}
