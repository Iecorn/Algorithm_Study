package org.problems.BackJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class PutOperator_14888 {

    static int[] operators = new int[4]; // + - × ÷
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(numbers);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void dfs(int[] numbers) {
        Stack<Value> s = new Stack<>();
        s.push(new Value(1, numbers[0]));

        while (!s.isEmpty()) {
            Value v = s.pop();

            if (v.idx == N) {
                MAX = Math.max(MAX, v.value);
                MIN = Math.min(MIN, v.value);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                if (operators[i] - v.used[i] > 0) {
                    switch (i) {
                        case 0:
                            s.push(new Value(v.idx + 1, v.value + numbers[v.idx], v.used, i));
                            break;
                        case 1:
                            s.push(new Value(v.idx + 1, v.value - numbers[v.idx], v.used, i));
                            break;
                        case 2:
                            s.push(new Value(v.idx + 1, v.value * numbers[v.idx], v.used, i));
                            break;
                        case 3:
                            s.push(new Value(v.idx + 1, v.value / numbers[v.idx], v.used, i));
                            break;
                    }
                }
            }
        }
    }
}

class Value {
    int idx;
    int value;
    int[] used;

    public Value(int idx, int value) {
        this.idx = idx;
        this.value = value;
        this.used = new int[4];
    }

    public Value(int idx, int value, int[] used, int i) {
        this.idx = idx;
        this.value = value;
        this.used = used.clone();
        this.used[i] += 1;
    }
}
