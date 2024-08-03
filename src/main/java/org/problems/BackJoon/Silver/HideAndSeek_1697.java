package org.problems.BackJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek_1697 {
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bfs(N, K);

    }

    public static void bfs(int N, int K) {
        Queue<Location> q = new LinkedList<>();
        q.add(new Location(N, 0));

        while (!q.isEmpty()) {
            Location l = q.poll();

            if (l.value == K) {
                System.out.println(l.cnt);
                break;
            } else if (l.value < K) {
                if(l.value*2 < 100001 && !visited[l.value*2]){
                    visited[l.value*2] = true;
                    q.add(new Location(l.value*2, l.cnt+1));
                }
                if(l.value+1 < 100001 && !visited[l.value+1]){
                    visited[l.value+1] = true;
                    q.add(new Location(l.value+1, l.cnt+1));
                }

                if(l.value-1 > 0 && !visited[l.value-1]){
                    visited[l.value-1] = true;
                    q.add(new Location(l.value-1, l.cnt+1));
                }
            } else {
                if(!visited[l.value-1]){
                    visited[l.value-1] = true;
                    q.add(new Location(l.value-1, l.cnt+1));
                }
            }
        }
    }
}

class Location {
    int value;
    int cnt;

    public Location(int value, int cnt) {
        this.value = value;
        this.cnt = cnt;
    }
}
