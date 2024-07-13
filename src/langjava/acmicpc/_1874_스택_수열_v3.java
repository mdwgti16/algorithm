package langjava.acmicpc;

import java.io.IOException;

public class _1874_스택_수열_v3 {
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int[] stack = new int[n];
        StringBuilder sb = new StringBuilder();

        int top = 0;
        int number = 1;
        for (int i = 0; i < n; i++) {
            int k = readInt();
            while (number <= k) {
                stack[top++] = number++;
                sb.append("+\n");
            }

            if (stack[--top] != k) {
                System.out.println("NO");
                return;
            }

            sb.append("-\n");
        }

        while (--top != -1) {
            sb.append("-\n");
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