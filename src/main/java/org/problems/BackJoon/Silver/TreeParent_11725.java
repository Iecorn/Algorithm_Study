package org.problems.BackJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TreeParent_11725 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] parent = new int[N+1];
    boolean[] visited = new boolean[N+1];
    visited[0] = true;

    // 그래프 초기화
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < N+1; i++) {
      graph.add(new ArrayList<>());
    }

    StringTokenizer st;

    // 정점 입력
    for (int i = 0; i < N-1; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      graph.get(from).add(to);
      graph.get(to).add(from);
    }

    Queue<Integer> q = new LinkedList<>();
    q.add(1);

    //bfs 시작
    while(!q.isEmpty()){
      Integer current = q.poll();

      if(visited[current]){
        continue;
      }

      visited[current] = true;
      ArrayList<Integer> nodes = graph.get(current);

      for (Integer i : nodes) {
        if(!visited[i]){
          parent[i] = current;
          q.add(i);
        }
      }
    }

    for (int i = 2; i < N+1 ; i++) {
      System.out.println(parent[i]);
    }
  }
}
