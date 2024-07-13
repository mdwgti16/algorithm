package langjava.acmicpc;

import java.io.IOException;

public class _10986_나머지_합 {
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int m = readInt();

        long[] sums = new long[n + 1];
        long[] counts = new long[m];
        long answer = 0;
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + readInt();
            int r = (int) (sums[i] % m);
            if (r == 0) {
                answer++;
            }
            counts[r]++;
        }

        for (int i = 0; i < m; i++) {
            if (counts[i] > 1) {
                answer += counts[i] * (counts[i] - 1) / 2;
            }
        }
        System.out.println(answer);
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
