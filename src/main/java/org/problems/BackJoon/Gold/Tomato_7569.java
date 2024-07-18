package org.problems.BackJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato_7569 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());


        int[][][] boxes = new int[H][N][M];

        boolean check = true;
        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < M; k++) {
                    int n = Integer.parseInt(st.nextToken());
                    if (n == 1) {
                        q.add(new Point(k, j, i, 0));
                    } else if (check && n == 0) {
                        check = false;
                    }
                    boxes[i][j][k] = n;
                }
            }
        }

        if (check)
            System.out.println(0);
        else {
            int answer = bfs(boxes, q);
            if (checkZero(boxes))
                System.out.println(-1);
            else {
                System.out.println(answer);
            }
        }
    }


    public static int bfs(int[][][] boxes, Queue<Point> q) {
        // 1 익음 , 0 = 익X, -1 = 빈칸
        int max = Integer.MIN_VALUE;

        //check (up down front rear left right)
        while (!q.isEmpty()) {
            Point p = q.poll();

            max = Math.max(max, p.day);

            Point up = new Point(p.x, p.y, p.z + 1, p.day + 1);
            Point down = new Point(p.x, p.y, p.z - 1, p.day + 1);
            Point front = new Point(p.x, p.y - 1, p.z, p.day + 1);
            Point rear = new Point(p.x, p.y + 1, p.z, p.day + 1);
            Point left = new Point(p.x - 1, p.y, p.z, p.day + 1);
            Point right = new Point(p.x + 1, p.y, p.z, p.day + 1);

            if (0 <= up.z && up.z < boxes.length && boxes[up.z][up.y][up.x] == 0) {
                boxes[up.z][up.y][up.x] = 1;
                q.offer(up);
            }
            if (0 <= down.z && down.z < boxes.length && boxes[down.z][down.y][down.x] == 0) {
                boxes[down.z][down.y][down.x] = 1;
                q.offer(down);
            }
            if (0 <= front.y && front.y < boxes[0].length && boxes[front.z][front.y][front.x] == 0) {
                boxes[front.z][front.y][front.x] = 1;
                q.offer(front);
            }
            if (0 <= rear.y && rear.y < boxes[0].length && boxes[rear.z][rear.y][rear.x] == 0) {
                boxes[rear.z][rear.y][rear.x] = 1;
                q.offer(rear);
            }
            if (0 <= left.x && left.x < boxes[0][0].length && boxes[left.z][left.y][left.x] == 0) {
                boxes[left.z][left.y][left.x] = 1;
                q.offer(left);
            }
            if (0 <= right.x && right.x < boxes[0][0].length && boxes[right.z][right.y][right.x] == 0) {
                boxes[right.z][right.y][right.x] = 1;
                q.offer(right);
            }
        }
        return max;
    }

    public static boolean checkZero(int[][][] boxes) {
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes[0].length; j++) {
                for (int k = 0; k < boxes[0][0].length; k++) {
                    if (boxes[i][j][k] == 0) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

class Point {
    int x; // 가로
    int y; // 세로
    int z; // 높이
    int day; // 지난 날짜

    public Point(int x, int y, int z, int day) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.day = day;
    }
}


////print
//        for (int i = 0; i < boxes.length; i++) {
//        for (int j = 0; j < boxes[0].length; j++) {
//        for (int k = 0; k < boxes[0][0].length; k++) {
//        System.out.print(boxes[i][j][k] + " ");
//        }
//        System.out.println();
//        }
//        }
