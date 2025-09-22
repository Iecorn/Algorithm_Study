package org.problems.Programmers.LV2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SelfJoy {
  static boolean[] visited;

  public int solution(int[] cards) {
    List<Integer> numbers = new LinkedList<>();
    int length = cards.length;
    visited = new boolean[length];

    for (int i = 0; i < length; i++) {
      if (!visited[i]) {
        numbers.add(openBox(cards, i+1, 0));
      }
    }

    Collections.sort(numbers, Collections.reverseOrder());

    if(numbers.size() < 2)
      return 0;

    return numbers.get(0)*numbers.get(1);
  }

  public int openBox(int[] cards, int index, int num) {
    if (visited[index - 1]) {
      return num;
    }

    visited[index - 1] = true;
    return openBox(cards, cards[index-1], num + 1);
  }

  public static void main(String[] args) {
    int[] array = {8, 6, 3, 7, 2, 5, 1, 4};
    SelfJoy s = new SelfJoy();

    s.solution(array );
  }
}
