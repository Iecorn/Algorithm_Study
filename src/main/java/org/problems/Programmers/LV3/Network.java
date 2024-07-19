package org.problems.Programmers.LV3;

import java.util.LinkedList;
import java.util.Queue;

public class Network {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n];

        while(true){
            int node = checkVisited(visited);

            if (node == -1)
                break;
            else{
                q.add(node);
            }


            bfs(computers, q, visited);
            answer ++;
        }

        return answer;
    }

    public int checkVisited(int[] visited){
        for (int i = 0; i < visited.length ; i++) {
            if(visited[i] == 0){
                return i;
            }
        }

        return -1;
    }

    public void bfs(int[][] computers, Queue<Integer> q, int[] visited){
        while(!q.isEmpty()){
            int node = q.poll();
            visited[node] = 1;

            for (int i = 0; i < computers[0].length; i++) {
                if(visited[i] == 0 && computers[node][i] == 1 && i != node){
                    q.add(i);
                }
            }
        }
    }


    public static void main(String[] args) {
         Network n = new Network();
        int[][] array = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
//                {
//                {1, 1, 0},
//                {1, 1, 0},
//                {0, 0, 1}
//        };

        System.out.println(n.solution(3, array));
    }
}
