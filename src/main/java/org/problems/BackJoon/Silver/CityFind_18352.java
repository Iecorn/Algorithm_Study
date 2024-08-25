package org.problems.BackJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CityFind_18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());


        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, 1));
        }

        dijkstra(graph, X, K);
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void dijkstra(ArrayList<ArrayList<Node>> graph, int start, int K) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[graph.size() + 1];
        int[] distance = new int[graph.size() + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (visited[current.vertex]) continue;
            visited[current.vertex] = true;

            for (Node n : graph.get(current.vertex)) {
                if (!visited[n.vertex] && distance[n.vertex] > distance[current.vertex] + 1) {
                    distance[n.vertex] = distance[current.vertex] + 1;
                    pq.offer(new Node(n.vertex, distance[n.vertex]));
                }
            }
        }

        boolean isfind = false;

        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == K) {
                System.out.println(i);
                isfind = true;
            }
        }

        if (!isfind)
            System.out.println(-1);
    }
}
