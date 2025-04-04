package org.problems.BackJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MiroSearch_2178 {

  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};

  static class Progress {
    int x;
    int y;
    int move;

    public Progress(int x, int y, int move) {
      this.x = x;
      this.y = y;
      this.move = move;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int answer = 0;

    // 미로 저장
    int[][] MIRO = new int[N + 1][M + 1];
    for (int i = 1; i < N + 1; i++) {
      String[] split = br.readLine().split("");
      for (int j = 1; j < M + 1; j++) {
        MIRO[i][j] = Integer.parseInt(split[j - 1]);
      }
    }

    Queue<Progress> q = new LinkedList<>();
    boolean[][] visited = new boolean[N + 1][M + 1];
    for (int i = 0; i < N + 1; i++) {
      visited[i][0] = true;
    }
    for (int i = 1; i < M + 1; i++) {
      visited[0][i] = true;
    }
    visited[1][1] = true;

    q.add(new Progress(1, 1, 0));

    while (!q.isEmpty()) {
      Progress p = q.poll();
      visited[p.x][p.y] = true;

      if (p.x == N && p.y == M) {
        answer = p.move;
        break;
      }

      for (int i = 0; i < 4; i++) {
        int nx = p.x + dx[i];
        int ny = p.y + dy[i];

        if (nx == 0 || nx == N + 1 || ny == 0 || ny == M + 1) {
          continue;
        }
        if(MIRO[nx][ny] == 0){
          continue;
        }
        if(visited[nx][ny]){
          continue;
        }
        q.add(new Progress(nx, ny, p.move+1));
        visited[nx][ny] = true;
      }
    }

    System.out.println(answer + 1);
  }
}
