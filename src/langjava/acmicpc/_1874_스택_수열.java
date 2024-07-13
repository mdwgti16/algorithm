package langjava.acmicpc;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class _1874_스택_수열 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int top = sc.nextInt();
        int i = 1;
        int j = 1;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        while (!stack.isEmpty() || i <= n) {
            if (i <= top) {
                sb.append("+").append(" ");
                stack.push(i);

                if (j < n && i == top) {
                    top = sc.nextInt();
                    stack.pop();
                    sb.append("-").append(" ");
                    j++;
                }

                i++;
            } else {
                int pop = stack.pop();
                sb.append("-").append(" ");

                if (pop != top) {
                    sb = new StringBuilder("NO");
                    break;
                }

                if (j < n) {
                    top = sc.nextInt();
                    j++;
                }
            }
        }

        System.out.println(sb);
    }
}