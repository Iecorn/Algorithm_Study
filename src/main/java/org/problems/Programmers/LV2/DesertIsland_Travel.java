package org.problems.Programmers.LV2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class DesertIsland_Travel {

  static class Location {
    int x;
    int y;

    public Location(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static int[] movex = {1, -1, 0, 0};
  static int[] movey = {0, 0, 1, -1};

  static char map[][];

  static boolean[][] visited;

  public int[] solution(String[] maps) {
    ArrayList<Integer> answer = new ArrayList<>();
    map = new char[maps.length][maps[0].length()];
    visited = new boolean[maps.length][maps[0].length()];

    for (int i = 0; i < maps.length; i++) {
      map[i] = maps[i].toCharArray();
    }

    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[0].length; j++) {
        if (!visited[i][j] && map[i][j] != 'X') {
          answer.add(bfs(i, j));
        }
      }
    }

    if (answer.size() == 0) {
      answer.add(-1);
    }

    Collections.sort(answer);

    return answer
            .stream()
            .mapToInt(Integer::intValue)
            .toArray();
  }

  public int bfs(int x, int y) {
    int sum = 0;
    Queue<Location> q = new LinkedList<>();
    q.add(new Location(x, y));
    visited[x][y] = true;
    while (!q.isEmpty()) {
      Location current = q.poll();
      sum += map[current.x][current.y] - '0';

      for (int i = 0; i < 4; i++) {
        int nx = current.x + movex[i];
        int ny = current.y + movey[i];

        if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length)
          continue;
        if (!visited[nx][ny] && map[nx][ny] != 'X') {
          visited[nx][ny] = true;
          q.offer(new Location(nx, ny));
        }
      }
    }
    return sum;
  }


  public static void main(String[] args) {
    String[] maps = {"X591X", "X1X5X", "X231X", "1XXX1"};

    DesertIsland_Travel c = new DesertIsland_Travel();
    int[] solution = c.solution(maps);
    for (int i = 0; i < solution.length; i++) {
      System.out.println(solution[i]);
    }
  }
}
