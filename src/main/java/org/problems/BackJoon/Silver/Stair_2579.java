package org.problems.BackJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Stair_2579 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] data = new int[n+1];
    for(int i=1; i<n+1; i++) {
      data[i]  = Integer.parseInt(br.readLine());
    }

    // 1. 한 계단 혹은 두 계단씩 오름
    // 2. 연속된 세 개의 계단 x (시작점 포함 x, 시작점 0)
    // 3. 마지막 계단 필수
    int[] dp = new int[n+1];
    if(n==1) {
      dp[1] = data[1];
    }else if(n==2) {
      dp[2] = data[2] + data[1];
    }else {
      dp[1] = data[1];
      dp[2] = data[2] + data[1];
      dp[3] = Math.max(data[1] + data[3], data[2] + data[3]);

      for(int i=4; i<n+1; i++) {
        // 1. 두 계단 + 한 계단 오른 경우
        // 2. 한 번에 두 계단 오른 경우
        dp[i] = Math.max(dp[i-3] + data[i] + data[i-1], dp[i-2] + data[i]);
      }
    }
    System.out.println(dp[n]);
  }

//  static Queue<Progress> q = new LinkedList<>();
//  static int[] scores;
//  static List<Integer> results;
//
//  static class Progress{
//    int index;
//    int sum;
//
//    public Progress(int index, int sum) {
//      this.index = index;
//      this.sum = sum;
//    }
//  }
//
//  public static void main(String[] args) throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    int N = Integer.parseInt(br.readLine());
//    scores = new int[N];
//    results = new LinkedList<>();
//
//    for (int i = 0; i < N; i++) {
//      scores[i] = Integer.parseInt(br.readLine());
//    }
//
//    // 12, 2 2가지 방법
//    q.add(new Progress(0, scores[0]));
//    q.add(new Progress(1, scores[1]));
//
//    while(!q.isEmpty()){
//      Progress current = q.poll();
//
//      if(current.index == N-1){
//        results.add(current.sum);
//        continue;
//      }
//
//      if(current.index + 3 < N){
//        q.add(oneTwo(current.index, current.sum));
//      }
//      if(current.index + 2 < N){
//        q.add(two(current.index, current.sum));
//      }
//      if(N-current.index == 1){
//        results.add(current.sum + scores[N-1]);
//      }
//    }
//
//
//    Collections.sort(results, Collections.reverseOrder());
//
//    System.out.println(results.get(0));
//  }
//
//  public static Progress oneTwo(int index, int sum){
//    int result = sum + scores[index+1] + scores[index+3];
//    return new Progress(index + 3, result);
//  }
//
//  public static Progress two(int index, int sum){
//    int jumpOne = sum + scores[index+2];
//    return new Progress(index + 2, jumpOne);
//  }
}
