package org.problems.BackJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CoupangMan_5972 {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(to, weight));
            graph.get(to).add(new Edge(from, weight));
        }

        Dijkstra(graph);
    }

    static class Edge implements Comparable<Edge> {
        int vertex;
        int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void Dijkstra(ArrayList<ArrayList<Edge>> graph){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        int[] distance = new int[N+1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        pq.offer(new Edge(1,0));

        while(!pq.isEmpty()){
            Edge current = pq.poll();

            if(visited[current.vertex]) continue;
            visited[current.vertex] = true;

            for (Edge e : graph.get(current.vertex)) {
                if(!visited[e.vertex] && distance[e.vertex] > distance[current.vertex] + e.weight){
                    distance[e.vertex] = distance[current.vertex] + e.weight;
                    pq.offer(new Edge(e.vertex, distance[e.vertex]));
                }
            }
        }

        System.out.println(distance[N]);
    }
}
