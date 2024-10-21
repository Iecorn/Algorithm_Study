package org.problems.BackJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Minecraft_18111 {
  static int N, M, B, up, down;
  static int[][] areas;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());


    areas = new int[N][M];
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int min_time = Integer.MAX_VALUE;
    int max_height = 0;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++) {
        int n = Integer.parseInt(st.nextToken());
        areas[i][j] = n;
        min = Math.min(min, n);
        max = Math.max(max, n);
      }
    }

    for (int i = min; i <= max; i++) {
      if (checkUD(i))
        continue;

      int time = up + down * 2;
      if (time <= min_time) {
        min_time = time;
        max_height = i;
      }
    }

    System.out.println(min_time + " " + max_height);
  }

  public static boolean checkUD(int h) {
    down = 0;
    up = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (h > areas[i][j])
          up += Math.abs(h - areas[i][j]);
        else if (h < areas[i][j])
          down += Math.abs(h - areas[i][j]);
      }
    }

    if (up > down + B)
      return true;
    return false;
  }
}
