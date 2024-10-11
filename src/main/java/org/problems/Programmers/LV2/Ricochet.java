package org.problems.Programmers.LV2;

import java.util.LinkedList;
import java.util.Queue;

public class Ricochet {
  static int xSize = 0;
  static int ySize = 0;
  public int solution(String[] board) {
    int start_x = 0;
    int start_y = 0;
    xSize = board[0].length();
    ySize = board.length;

    // findR
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length(); j++) {
        if (board[i].charAt(j) == 'R') {
          start_x = j;
          start_y = i;
          break;
        }
      }
    }

    int answer = bfs(start_x, start_y, board);

    return answer;
  }

  public int bfs(int start_x, int start_y, String[] board) {
    boolean[][] visited = new boolean[ySize][xSize];

    Queue<Robot> q = new LinkedList<>();
    q.add(new Robot(start_x, start_y, 0));

    // bfs
    while (!q.isEmpty()) {
      Robot robot = q.poll();
      visited[robot.y][robot.x] = true;

      // check G
      if (board[robot.y].charAt(robot.x) == 'G')
        return robot.count;

      // check U D R L
      if (robot.y - 1 >= 0 && board[robot.y - 1].charAt(robot.x) != 'D') {
        int move = robot.up(board);
        if (!visited[robot.y - move][robot.x])
          q.add(new Robot(robot.x, robot.y - move, robot.count + 1));
      }
      if (robot.y + 1 < ySize && board[robot.y + 1].charAt(robot.x) != 'D') {
        int move = robot.down(board);
        if (!visited[robot.y + move][robot.x])
          q.add(new Robot(robot.x, robot.y + move, robot.count + 1));
      }
      if (robot.x - 1 >= 0 && board[robot.y].charAt(robot.x - 1) != 'D') {
        int move = robot.left(board);
        if (!visited[robot.y][robot.x - move])
          q.add(new Robot(robot.x - move, robot.y, robot.count + 1));
      }
      if (robot.x + 1 < xSize && board[robot.y].charAt(robot.x + 1) != 'D') {
        int move = robot.right(board);
        if (!visited[robot.y][robot.x + move])
          q.add(new Robot(robot.x + move, robot.y, robot.count + 1));
      }
    }


    return -1;
  }

  public class Robot {
    int x;
    int y;
    int count;

    public Robot(int x, int y, int count) {
      this.x = x;
      this.y = y;
      this.count = count;
    }

    public int up(String[] board) {
      int weight = 1;

      while (this.y - (weight + 1) >= 0 && board[this.y - (weight + 1)].charAt(this.x) != 'D') {
        weight += 1;
      }

      return weight;
    }

    public int down(String[] board) {
      int weight = 1;

      while (this.y + (weight + 1) < ySize && board[this.y + (weight + 1)].charAt(this.x) != 'D') {
        weight += 1;
      }

      return weight;
    }

    public int left(String[] board) {
      int weight = 1;

      while (this.x - (weight + 1) >= 0 && board[this.y].charAt(this.x - (weight + 1)) != 'D') {
        weight += 1;
      }

      return weight;
    }

    public int right(String[] board) {
      int weight = 1;

      while (this.x + (weight + 1) < xSize && board[this.y].charAt(this.x + (weight + 1)) != 'D') {
        weight += 1;
      }

      return weight;
    }
  }

  public static void main(String[] args) {
    String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};

    Ricochet robot = new Ricochet();
    robot.solution(board);
  }
}
