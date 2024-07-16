package org.problems.Programmers.LV0;

import java.util.Arrays;

public class MakeMax2 {
    public int solution(int[] numbers) {

        Arrays.sort(numbers);
        int max1 = numbers[0]*numbers[1];
        int max2 = numbers[numbers.length-1]*numbers[numbers.length-2];

        return Math.max(max1,max2);
    }
}
