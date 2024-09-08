package org.problems.Programmers.LV2;

import java.util.LinkedList;
import java.util.Queue;

public class CovertNum {
    public int solution(int x, int y, int n) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[1000001];

        q.add(new Node(y, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            visited[node.weight] = true;

            if (node.weight == x) {
                return node.number;
            }
            if (node.weight - n >= 0 && !visited[node.weight - n] && node.weight - n >= x) {
                q.add(new Node(node.weight - n, node.number + 1));
            }
            if (node.weight % 2 == 0 && !visited[node.weight / 2] && node.weight / 2 >= x) {
                q.add(new Node(node.weight / 2, node.number + 1));
            }
            if (node.weight % 3 <= 0 && !visited[node.weight / 3] && node.weight / 3 >= x) {
                q.add(new Node(node.weight / 3, node.number + 1));
            }
        }

        return -1;
    }

    class Node {
        int weight;
        int number;

        public Node(int weight, int number) {
            this.weight = weight;
            this.number = number;
        }
    }

    public static void main(String[] args) {

    }
}
