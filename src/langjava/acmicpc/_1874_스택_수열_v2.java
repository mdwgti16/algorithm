package langjava.acmicpc;

import java.io.IOException;
import java.util.Stack;

public class _1874_스택_수열_v2 {
    public static void main(String[] args) throws IOException {
        int n = readInt();

        int top = readInt();
        int i = 1;
        int j = 1;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        while (!stack.isEmpty() || i <= n) {
            if (i <= top) {
                sb.append("+").append(" ");
                stack.push(i);

                if (j < n && i == top) {
                    top = readInt();
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
                    top = readInt();
                    j++;
                }
            }
        }

        System.out.println(sb);
    }


    static final int BUFFER_SIZE = 1 << 13;
    static byte[] buffer = new byte[BUFFER_SIZE];
    static int bufferLen, bufferIdx;

    static int readInt() throws IOException {
        byte b;
        int n = 0;
        while ((b = read()) <= 32) ;
        do {
            n = (n << 3) + (n << 1) + (b & 15);
        } while (isNumber(b = read()));

        return n;
    }

    static boolean isNumber(byte b) {
        return 47 < b && b < 58;
    }

    static byte read() throws IOException {
        if (bufferIdx == bufferLen) {
            bufferLen = System.in.read(buffer, bufferIdx = 0, BUFFER_SIZE);
            if (bufferLen == -1) {
                buffer[0] = -1;
            }
        }
        return buffer[bufferIdx++];
    }
}