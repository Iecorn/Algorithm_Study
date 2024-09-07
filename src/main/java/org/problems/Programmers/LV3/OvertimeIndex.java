package org.problems.Programmers.LV3;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class OvertimeIndex {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long answer = 0;
        for (int work : works) {
            pq.add(work);
        }

        while(n > 0){
            if(pq.isEmpty())
                break;
            int v= pq.poll()-1;
            n--;
            if(v > 0)
                pq.add(v);

        }

        for (Integer out : pq) {
            answer += Math.pow(out,2);
        }

        return answer;
    }


    public static void main(String[] args) {
        OvertimeIndex s = new OvertimeIndex();
        int[] arr = {1,1};
        System.out.println(s.solution(3, arr));
    }
}
