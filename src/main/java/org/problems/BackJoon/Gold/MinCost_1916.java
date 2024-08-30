package org.problems.BackJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MinCost_1916 {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Edge(to, w));
//            graph.get(to).add(new Edge(from, w));
        }

        st = new StringTokenizer(br.readLine(), " " );
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Dijkstra(graph, start, end);
    }


    static class Edge implements Comparable<Edge>{
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

    public static void Dijkstra(ArrayList<ArrayList<Edge>> graph, int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        int[] distance = new int[N+1];

        pq.offer(new Edge(start, 0));
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        while(!pq.isEmpty()){
            Edge current = pq.poll();

            if(visited[current.vertex]) continue;
            visited[current.vertex] = true;

            for (Edge e : graph.get(current.vertex)) {
                if(!visited[e.vertex] && distance[e.vertex] > distance[current.vertex] + e.weight){
                    distance[e.vertex] = distance[current.vertex] + e.weight;
                    pq.add(new Edge(e.vertex, distance[e.vertex]));
                }
            }
        }


        System.out.println(distance[end]);
    }
}
