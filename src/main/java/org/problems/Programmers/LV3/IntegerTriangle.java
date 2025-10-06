package org.problems.Programmers.LV3;

import java.util.Arrays;

public class IntegerTriangle {
  public int solution(int[][] triangle) {
    int level = triangle.length;
    int[][] dp = new int[500][500];


    dp[0][0] = triangle[0][0];

    for (int i = 1; i < level; i++) {
      int index = triangle[i].length;

      for (int j = 0; j < index; j++) {
        if(j == 0){
          dp[i][0] = triangle[i][0] + dp[i-1][j];
        } else if (j == index - 1) {
          dp[i][j] = triangle[i][j] + dp[i-1][j-1];
        } else {
          dp[i][j] = Math.max(triangle[i][j] + dp[i-1][j-1], triangle[i][j] + dp[i-1][j]);
        }
      }
    }

    int[] result = Arrays.stream(dp[level - 1]).toArray();
    Arrays.sort(result);
    return result[result.length-1];
  }

  public static void main(String[] args) {
    int[][] arr = {
            {7},
            {3, 8},
            {8, 1, 0},
            {2, 7, 4, 4},
            {4, 5, 2, 6, 5}
    };
    IntegerTriangle t = new IntegerTriangle();
    System.out.println(t.solution(arr));
  }
}
