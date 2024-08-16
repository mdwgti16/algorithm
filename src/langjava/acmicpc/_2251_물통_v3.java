package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2251_물통_v3 {
    private static boolean[] answers;
    private static int[] capacities = new int[3];
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        capacities[0] = Integer.parseInt(st.nextToken());
        capacities[1] = Integer.parseInt(st.nextToken());
        capacities[2] = Integer.parseInt(st.nextToken());
        visited = new boolean[capacities[0] + 1][capacities[1] + 1];

        answers = new boolean[capacities[2] + 1];
        check(new int[]{0, 0, capacities[2]});

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answers.length; i++) {
            if (answers[i]) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb);
    }

    private static void check(int[] waters) {
        if (visited[waters[0]][waters[1]]) {
            return;
        }
        visited[waters[0]][waters[1]] = true;
        if (waters[0] == 0) {
            answers[waters[2]] = true;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                int k = 3 - i - j;
                if (waters[i] > 0) {
                    if (waters[j] < capacities[j]) {
                        check(moveWater(i, j, k, waters));
                    }
                    if (waters[k] < capacities[k]) {
                        check(moveWater(i, k, j, waters));
                    }
                }
            }
        }
    }

    private static int[] moveWater(int i, int j, int k, int[] waters) {
        int[] temp = new int[3];
        int diff = Math.min(capacities[j] - waters[j], waters[i]);
        temp[i] = waters[i] - diff;
        temp[j] = waters[j] + diff;
        temp[k] = waters[k];

        return temp;
    }
}