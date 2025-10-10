package org.problems.Programmers.LV3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DoublePQ {
  public int[] solution(String[] operations) {
    PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> minQ = new PriorityQueue<>();

    StringTokenizer st;

    for (String operation : operations) {
      st = new StringTokenizer(operation, " ");
      String sign = st.nextToken();
      int num = Integer.parseInt(st.nextToken());

      if(sign.equals("D") && maxQ.isEmpty())
        continue;

      if (sign.equals("I")) {
        maxQ.offer(num);
        minQ.offer(num);
      } else if (sign.equals("D") && num == 1) {
        Integer max = maxQ.poll();
        minQ.remove(max);
      } else {
        Integer min = minQ.poll();
        maxQ.remove(min);
      }
    }


    if (maxQ.isEmpty()) return new int[]{0, 0};
    else return new int[]{maxQ.poll(), minQ.poll()};
  }

  public static void main(String[] args) {
    String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
    String[] operations2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
    String[] operations3 = {"I 1", "I 2", "D 1", "D -1", "I 3", "I 4", "D 1"};
    DoublePQ q = new DoublePQ();
    int[] solution = q.solution(operations);
    System.out.println(solution[0]);
    System.out.println(solution[1]);
  }
}
