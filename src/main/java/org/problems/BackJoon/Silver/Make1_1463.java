package org.problems.BackJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Make1_1463 {
    static boolean[] visited = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        bfs(N);
    }

    public static void bfs(int N) {
        Queue<Counter> q = new LinkedList<>();
        q.add(new Counter(N, 0));

        while (!q.isEmpty()) {
            Counter c = q.poll();

            if (c.value == 1) {
                System.out.println(c.cnt);
                break;
            }
            if (c.value % 3 == 0 && !visited[c.value / 3]) {
                visited[c.value / 3] = true;
                q.add(new Counter(c.value / 3, c.cnt + 1));
            }
            if (c.value % 2 == 0 && !visited[c.value / 2]) {
                visited[c.value / 2] = true;
                q.add(new Counter(c.value / 2, c.cnt + 1));
            }
            q.add(new Counter(c.value - 1, c.cnt + 1));
        }
    }
}

class Counter {
    int value;
    int cnt;

    public Counter(int value, int cnt) {
        this.value = value;
        this.cnt = cnt;
    }
}
