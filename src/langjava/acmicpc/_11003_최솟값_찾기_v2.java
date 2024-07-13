package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _11003_최솟값_찾기_v2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        Deque<int[]> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.getLast()[1] > v) {
                stack.removeLast();
            }

            stack.addLast(new int[]{i, v});

            if (stack.getFirst()[0] <= i - l) {
                stack.removeFirst();
            }

            sb.append(stack.getFirst()[1]).append(" ");
        }

        System.out.println(sb);
    }
}
