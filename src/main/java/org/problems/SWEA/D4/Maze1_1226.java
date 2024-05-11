package org.problems.SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Maze1_1226 {
    static int[] x = {1, -1, 0, 0};
    static int[] y = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            int T = Integer.parseInt(br.readLine());
            int[][] maze = new int[16][16];
            int[][] visited = new int[16][16];
            Vertex start = null;
            Vertex end = null;
            int answer = 0;

            for (int j = 0; j < 16; j++) {
                String line = br.readLine();
                for (int k = 0; k < 16; k++) {
                    maze[j][k] = line.charAt(k) - '0';
                    if (line.charAt(k) == '1')
                        visited[j][k] = 1;
                    else if (line.charAt(k) == '2')
                        start = new Vertex(j, k);
                    else if (line.charAt(k) == '3')
                        end = new Vertex(j, k);
                }
            }

            answer = bfs(maze, visited, start, end);

            System.out.println("#" + T + " " + answer);
        }
    }

    public static int bfs(int[][] maze, int[][] visitied, Vertex start, Vertex end) {
        Queue<Vertex> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            Vertex v = q.poll();
            visitied[v.x][v.y] = 1;
            if (v.x == end.x && v.y == end.y)
                return 1;
            for (int i = 0; i < 4; i++) {
                if (maze[v.x + x[i]][v.y + y[i]] != 1 && visitied[v.x + x[i]][v.y + y[i]] == 0)
                    q.offer(new Vertex(v.x + x[i], v.y + y[i]));
            }
        }

        return 0;
    }

    static class Vertex {
        int x;
        int y;

        public Vertex(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
