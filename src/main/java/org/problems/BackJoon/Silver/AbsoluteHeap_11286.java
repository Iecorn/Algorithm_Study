package org.problems.BackJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class AbsoluteHeap_11286 {

  static class Number {
    int original;
    int absolute;

    public Number(Integer original) {
      this.original = original;
      this.absolute = Math.abs(original);
    }

    @Override
    public String toString() {
      return String.valueOf(original);
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Number> pq = new PriorityQueue<>(
            (a, b) -> {
              if (a.absolute == b.absolute) {
                // 절댓값이 같으면 원래 값으로 정렬
                return Integer.compare(a.original, b.original);
              }
              return Integer.compare(a.absolute, b.absolute);
            }
    );

    for (int i = 0; i < N; i++) {
      int input = Integer.parseInt(br.readLine());

      if(input == 0){
        Number output = pq.poll();

        if(output == null){
          System.out.println(0);
        }
        else
          System.out.println(output);
      }
      else
        pq.offer(new Number(input));
    }
  }
}
