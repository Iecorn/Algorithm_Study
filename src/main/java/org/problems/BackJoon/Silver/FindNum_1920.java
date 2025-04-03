package org.problems.BackJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FindNum_1920 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    HashMap<Integer, Boolean> map = new HashMap<>();
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    for (int i = 0; i < N; i++) {
      map.put(Integer.parseInt(st.nextToken()), true);
    }

    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine(), " ");

    for (int i = 0; i < M; i++) {
      if (map.getOrDefault(Integer.parseInt(st.nextToken()), false)) {
        System.out.println(1);
      } else {
        System.out.println(0);
      }
    }
  }
}
