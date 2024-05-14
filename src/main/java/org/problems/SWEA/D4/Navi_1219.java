package org.problems.SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Navi_1219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int T = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            Graph g = new Graph(100);
            for(int j = 0; j < L; j++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                g.addEdge(from, to);
            }

            System.out.println("#" + T + " " + g.DFS(0));
        }

    }

    public static class Graph{
        private int v;
        private ArrayList<ArrayList<Integer>> graph;

        Graph(int v){
            this.v =v;
            this.graph = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < this.v; i++)
                this.graph.add(new ArrayList<Integer>());
        }

        void addEdge(int from, int to) {
            this.graph.get(from).add(to);
        }

        int DFS(int start) {
            boolean[] visited = new boolean[this.v];
            Stack<Integer> s = new Stack<>();
            s.push(start);

            while(!s.empty()) {
                int node = s.pop();
                if(!visited[node]) {
                    visited[node] = true;
                    ListIterator<Integer> iter = this.graph.get(node).listIterator();
                    while(iter.hasNext()) {
                        int n = iter.next();
                        if(n == 99)
                            return 1;
                        else if(!visited[n])
                            s.push(n);
                    }
                }
            }
            return 0;
        }
    }
}
