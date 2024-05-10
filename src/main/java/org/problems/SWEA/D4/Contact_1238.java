package org.problems.SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Contact_1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 1; i < 11; i++) {
            int[][] graph = new int[101][101];
            boolean[] visited = new boolean[101];
            List<Vertex> vertexs = new ArrayList<Vertex>();

            st = new StringTokenizer(br.readLine(), " ");
            int L = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < L / 2; j++) {
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                graph[s][e] = 1;
            }

            bfs(graph, vertexs, start);

            System.out.println("#" + i + " " + findMax(vertexs));
        }
    }

    public static void bfs(int[][] graph, List<Vertex> vertexs, int start) {
        Queue<Vertex> q = new LinkedList<>();
        boolean[] visited = new boolean[101];
        int distMax = Integer.MIN_VALUE;
        visited[start] = true;
        q.offer(new Vertex(start, 0));

        while (!q.isEmpty()) {
            Vertex v = q.poll();
            boolean flag = false;

            if(distMax < v.dist){
                distMax = v.dist;
                vertexs.clear();
            }

            for (int i = 1; i < 101; i++) {
                if (graph[v.vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(new Vertex(i, v.dist + 1));
                    flag = true;
                }
            }
            if (!flag)
                vertexs.add(v);
        }
    }

    //    public static void dfs(int[][] graph, boolean[] visited, List<Vertex> vertexs, int start, int dist) {
//        visited[start] = true;
//        boolean flag = false;
//        for (int i = 1; i < 101; i++) {
//            if (graph[start][i] == 1 && !visited[i]) {
//                dfs(graph, visited, vertexs, i, dist + 1);
//                System.out.println(dist);
//                flag = true;
//            }
//        }
//        if (!flag)
//            vertexs.add(new Vertex(start, dist));
//    }
//
    public static int findMax(List<Vertex> vertexs) {
        int vertexMax = Integer.MIN_VALUE;

        for (Vertex v : vertexs)
            vertexMax = Math.max(vertexMax, v.vertex);

        return vertexMax;
    }

    static class Vertex {
        int vertex;
        int dist;

        public Vertex(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }
    }
}
