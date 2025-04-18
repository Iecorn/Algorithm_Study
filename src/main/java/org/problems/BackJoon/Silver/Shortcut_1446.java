package org.problems.BackJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Shortcut_1446 {
  static int ANSWER = 0;

  static class Edge implements Comparable<Edge>{
    int vertex, weight;

    public Edge(int vertex, int weight) {
      this.vertex = vertex;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
      return this.weight - o.weight;
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int D = Integer.parseInt(st.nextToken());

    int[][] arr = new int[N][3];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < 3; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[] dp = new int[D+1];

    for (int i = 0; i < D+1; i++) {
      dp[i] = i;
    }

    for (int i = 1; i < D+1; i++) {
      dp[i] = Math.min(dp[i], dp[i-1]+1);
      for (int j = 0; j < N; j++) {
        if(arr[j][1] == i){
          dp[i] = Math.min(dp[i], dp[arr[j][0]] + arr[j][2]);
        }
      }
    }

    System.out.println(dp[D]);
  }
}
