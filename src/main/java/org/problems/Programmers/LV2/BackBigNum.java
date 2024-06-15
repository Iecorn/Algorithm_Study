package org.problems.Programmers.LV2;

import java.util.Stack;

public class BackBigNum {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> s = new Stack<>();

        s.push(0);


        for (int i = 1; i < numbers.length; i++) {
            while (!s.isEmpty() && numbers[s.peek()] < numbers[i]) {
                answer[s.pop()] = numbers[i];
            }
            s.push(i);
        }

        // -1
        for (int i = 0; i < numbers.length; i++)
            if (answer[i] == 0)
                answer[i] = -1;

        return answer;
    }

    public static void main(String[] args) {
        BackBigNum b = new BackBigNum();
        int[] nums = {9, 1, 5, 3, 6, 2};
        for (int i : b.solution(nums)) {
            System.out.println(i);
        }
    }
}
