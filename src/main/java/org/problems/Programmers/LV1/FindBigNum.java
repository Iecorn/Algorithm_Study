package org.problems.Programmers.LV1;

public class FindBigNum {
    public int[] solution(int[][] array) {
        int[] answer = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < array[0].length; j++) {
                max = Math.max(max, array[i][j]);
            }
            answer[i] = max;
        }

        return answer;
    }
}
