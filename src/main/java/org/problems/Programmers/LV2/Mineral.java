package org.problems.Programmers.LV2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Mineral {
  final static int[][] Fatigue = {
          {1, 1, 1}, //다이아
          {5, 1, 1}, // 철
          {25, 5, 1} // 돌
  };
  final static int DIAMOND = 0;
  final static int IRON = 1;
  final static int STONE = 2;


  public int solution(int[] picks, String[] minerals) {
    int answer = Integer.MAX_VALUE;

    Queue<Case> q = new LinkedList<>();
    q.add(new Case(picks, 0, 0));

    while (q.peek().index != minerals.length) {
      Case c = q.poll();

      if(c.picks[DIAMOND] == 0 && c.picks[IRON] == 0 && c.picks[STONE] == 0){
        q.add(c);
        break;
      }

      if (c.picks[DIAMOND] > 0) {
        q.add(c.calculateFatigue(DIAMOND, minerals));
      }
      if (c.picks[IRON] > 0) {
        q.add(c.calculateFatigue(IRON, minerals));
      }
      if (c.picks[STONE] > 0) {
        q.add(c.calculateFatigue(STONE, minerals));
      }
    }

    while (!q.isEmpty()) {
      answer = Math.min(answer, q.poll().sum);
    }

    return answer;
  }

  class Case {
    int[] picks;
    int sum;
    int index;


    public Case(int[] picks, int sum, int index) {
      this.picks = picks;
      this.sum = sum;
      this.index = index;
    }

    public Case calculateFatigue(int pickel, String[] minerals) {
      int loopCount = Math.min(5, minerals.length - index);
      int newSum = sum;

      for (int i = index; i < index + loopCount; i++) {
        newSum += Fatigue[pickel][indexFatigue(minerals[i])];
      }

      int[] newPicks = Arrays.copyOf(picks, picks.length);
      newPicks[pickel]--;

      return new Case(newPicks, newSum, index + loopCount);
    }
  }

  public int indexFatigue(String mineral) {
    switch (mineral) {
      case "diamond":
        return DIAMOND;
      case "iron":
        return IRON;
      case "stone":
        return STONE;
    }

    return 3;
  }

  public static void main(String[] args) {
//    int[] picks = {1, 3, 2};
//    String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};

    int[] picks = {0, 1, 1};
    String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};

    Mineral m = new Mineral();
    System.out.println(m.solution(picks, minerals));
  }
}
