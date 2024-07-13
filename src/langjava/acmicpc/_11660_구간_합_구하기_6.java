package langjava.acmicpc;

import java.io.IOException;

public class _11660_구간_합_구하기_6 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int n = readInt();
        int m = readInt();

        int[][] sums = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sums[i][j] = readInt() + sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            int x1 = readInt();
            int y1 = readInt();
            int x2 = readInt();
            int y2 = readInt();

            sb.append(sums[x2][y2] - sums[x2][y1 - 1] - sums[x1 - 1][y2] + sums[x1 - 1][y1 - 1]).append("\n");
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
