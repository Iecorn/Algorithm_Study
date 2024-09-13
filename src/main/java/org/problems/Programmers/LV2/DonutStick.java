package org.problems.Programmers.LV2;

import java.util.*;

public class DonutStick {

    //n은 정점
    //점 n개 간선 n개 도넛
    //점 n개 간선 n-1개 막대
    //점 2n+1 개 간선 2n+2 8
    //보내기만하고 들어오는 간선이 없는 노드가 시작 노드
    public int[] solution(int[][] edges) {
        Map<Integer, Integer> from = new HashMap<>();
        Map<Integer, Integer> to = new HashMap<>();
        int[] answer = new int[4];

        for (int[] edge : edges) {
            from.put(edge[0], from.getOrDefault(edge[0], 0) + 1);
            to.put(edge[1], to.getOrDefault(edge[1], 0) + 1);
        }

        for (int f : from.keySet()) {
            if (from.get(f) > 1) {
                if (!to.containsKey(f)) {
                    answer[0] = f;
                } else {
                    answer[3] += 1;
                }
            }
        }

        for (int t : to.keySet()) {
            if (!from.containsKey(t)) {
                answer[2] += 1;
            }
        }
        answer[1] = from.get(answer[0]) - (answer[2] + answer[3]);
        return answer;
    }

//    public int[] solution(int[][] edges) {
//        int[] answer = new int[4]; // start donut stick 8
//
//        int[] info = findStart(edges); // {max node, start}
//        int max_node = info[0];
//        answer[0] = info[1];
//        int start_node = info[1];
//        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
//
//        for (int i = 0; i < max_node + 1; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < edges.length; i++) {
//            graph.get(edges[i][0]).add(edges[i][1]); // from to
//        }
//
//        int graphcnt = graph.get(start_node).size();
//
//
//        for (int i = 0; i < graphcnt; i++) {
//            boolean[] visited = new boolean[info[0] + 1];
//            int start = graph.get(start_node).get(i);
//            Queue<Integer> q = new LinkedList<>(); // insert from
//            q.add(start);
//
//            while (!q.isEmpty()) {
//                int from = q.poll();
//                if (visited[from]) {
//                    continue;
//                }
//
//                visited[from] = true;
//
//                if (graph.get(from).isEmpty()) {
//                    answer[2]++;
//                    break;
//                } else if (graph.get(from).size() >= 2) {
//                    answer[3]++;
//                    break;
//                }
//                for (Integer to : graph.get(from)) {
//                    q.add(to);
//                }
//            }
//        }
//
//        answer[1] = graphcnt - (answer[2] + answer[3]);
//
//        return answer;
//    }
//
//    // 최대 노드 갯수랑 시작 노드 찾는 메소드
//    public int[] findStart(int[][] edge) {
//        int[] answer = new int[2]; // max, start
//        boolean[] to = new boolean[1000001];
//
//        for (int i = 0; i < edge.length; i++) {
//            answer[0] = Math.max(answer[0], edge[i][0]);
//            to[edge[i][1]] = true;
//        }
//
//        for (int i = 1; i < answer[0] + 1; i++) {
//            if (to[i] == false) {
//                answer[1] = i;
//                break;
//            }
//        }
//
//        return answer;
//    }


    public static void main(String[] args) {
        DonutStick d = new DonutStick();
//        int[][] array = {
//                {4, 11},
//                {1, 12},
//                {8, 3},
//                {12, 7},
//                {4, 2},
//                {7, 11},
//                {4, 8},
//                {9, 6},
//                {10, 11},
//                {6, 10},
//                {3, 5},
//                {11, 1},
//                {5, 3},
//                {11, 9},
//                {3, 8}
//        };

        int[][] array = {
                {2, 3},
                {4, 3},
                {1, 1},
                {2, 1}
        };

        d.solution(array);
    }
}
