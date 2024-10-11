package org.problems.Programmers.LV1;

import java.util.HashMap;
import java.util.Map;

public class Lotto {
  public int[] solution(int[] lottos, int[] win_nums) {
    int[] answer = new int[2];

    int zero_count = 0;
    int correct_count = 0;

    Map<Integer, Boolean> win = new HashMap<>();
    for (int winNum : win_nums) {
      win.put(winNum, true);
    }

    for (int lotto : lottos) {
      if (win.getOrDefault(lotto, false))
        correct_count++;
      else if (lotto == 0)
        zero_count++;
    }

    System.out.println("zero_count = " + zero_count);
    System.out.println("correct_count = " + correct_count);

    answer[0] = getReward(correct_count + zero_count);
    answer[1] = getReward(correct_count);

    return answer;
  }

  public int getReward(int count) {
    int reward = 6;
    if (count >= 6)
      reward = 1;
    else if (count == 5)
      reward = 2;
    else if (count == 4)
      reward = 3;
    else if (count == 3)
      reward = 4;
    else if (count == 2)
      reward = 5;
    else
      reward = 6;

    return reward;
  }

  public static void main(String[] args) {
    Lotto l = new Lotto();
//    int[] lottos = {44, 1, 0, 0, 31, 25};
//    int[] win_nums = {31, 10, 45, 1, 6, 19};

    int[] lottos = {44, 1, 0, 0, 31, 25};
    int[] win_nums = {31, 10, 45, 1, 6, 19};

    int[] solution = l.solution(lottos, win_nums);
    for (int i : solution) {
      System.out.println(i);
    }
  }
}
