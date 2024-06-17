package org.problems.Programmers.LV2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PowerGrid {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int from = wires[i][0];
            int to = wires[i][1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for (int i = 0; i < n-1; i++) {
            int sum = Union(graph, wires[i][0], wires[i][1]);

            answer = Math.min(answer, Math.abs(n-sum*2));
        }

        return answer;
    }

    public int Union(ArrayList<ArrayList<Integer>> graph, int from, int to) {
        int union = 0;
        int[] visited = new int[graph.size()];

        Queue<Integer> q = new LinkedList<>();
        q.add(from);

        while (!q.isEmpty()) {
            int start = q.poll();
            visited[start] = 1;
            for (int i = 0; i < graph.get(start).size(); i++) {
                int end = graph.get(start).get(i);
                boolean first = (start == from && end == to);
                boolean second = (start == to && end == from);
                boolean result = first || second;
                if (visited[end] == 0 && !result) {
                    q.offer(graph.get(start).get(i));
                }
            }
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 1)
                union += 1;
        }

        return union;
    }

    public static void main(String[] args) {
        PowerGrid powerGrid = new PowerGrid();
        int[][] coordinates = {
                {1, 2},
                {2, 3},
                {3, 4}
//                {1, 2},
//                {2, 7},
//                {3, 7},
//                {3, 4},
//                {4, 5},
//                {6, 7}
//                {1, 3},
//                {2, 3},
//                {3, 4},
//                {4, 5},
//                {4, 6},
//                {4, 7},
//                {7, 8},
//                {7, 9}
        };
        System.out.println(powerGrid.solution(4, coordinates));
    }
}
