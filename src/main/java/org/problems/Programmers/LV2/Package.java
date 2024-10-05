package org.problems.Programmers.LV2;

import java.util.Stack;

public class Package {
  public int solution(int[] order) {
    int answer = 0;

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < order.length; i++) {
      if(order[answer] == i + 1){
        answer++;
      } else if (!stack.isEmpty() && stack.peek() == order[answer]) {
        answer++;
        stack.pop();
        i--;
      }
      else {
        stack.push(i + 1);
      }

    }

    while(!stack.isEmpty()){
      if(stack.peek() == order[answer]){
        answer++;
        stack.pop();
      }
      else{
        break;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Package p = new Package();
//    int[] array = {4, 3, 1, 2, 5};
//    int[] array = {5, 4, 3, 2, 1};
    int[] array = {2, 1, 4, 3, 6, 5, 8, 7, 10, 9};
    System.out.println("p.solution(array) = " + p.solution(array));
  }
}
