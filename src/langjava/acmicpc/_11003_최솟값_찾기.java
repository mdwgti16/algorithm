package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _11003_최솟값_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int p = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.getLast()] > nums[i]) {
                stack.removeLast();
            }

            stack.addLast(i);

            if (stack.getFirst() <= i - l) {
                stack.removeFirst();
            }

            sb.append(nums[stack.getFirst()]).append(" ");
        }

        System.out.println(sb);
    }
}
