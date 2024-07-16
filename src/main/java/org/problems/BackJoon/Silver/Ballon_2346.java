package org.problems.BackJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Ballon_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> list = new ArrayDeque<>();
        Deque<Integer> index = new ArrayDeque<>();
        ArrayList<Integer> answer = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //init index
        for (int i = 0; i < N; i++)
            index.addLast(i + 1);
        //init list
        for (int i = 0; i < N; i++)
            list.addLast(Integer.parseInt(st.nextToken()));

        answer.add(index.pollFirst());

        while (!list.isEmpty()) {
            int next = list.pollFirst();

            if (index.size() == 1) {
                answer.add(index.pollFirst());
                break;
            }

            if (next > 0)
                for (int i = 0; i < next - 1; i++) {
                    list.addLast(list.pollFirst());
                    index.addLast(index.pollFirst());
                }
            else
                for (int i = 0; i < Math.abs(next); i++) {
                    list.addFirst(list.pollLast());
                    index.addFirst(index.pollLast());
                }

            answer.add(index.pollFirst());
        }

        for (int i = 0; i < N; i++) {
            System.out.print(answer.get(i) + " ");
        }
    }
}
