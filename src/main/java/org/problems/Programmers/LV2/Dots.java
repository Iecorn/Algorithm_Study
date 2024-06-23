package org.problems.Programmers.LV2;

public class Dots {
    public long solution(int k, int d) {
        long answer = 1;

        // X, Y Line
        for (int i = k; i <= d; i += k) {
            answer += 2;
        }

        for (int i = k; i < d; i += k) {
            long max = (long) Math.sqrt(Math.pow(d,2) - Math.pow(i,2));
            answer += max/k;
        }

        return answer;
    }

    public static void main(String[] args) {
        Dots d = new Dots();
        System.out.println(d.solution(2,4));
    }
}
