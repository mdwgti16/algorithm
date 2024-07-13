package langjava.acmicpc;

import java.io.IOException;

public class _2018_수들의_합_5 {
    public static void main(String[] args) throws IOException {
        int N = readInt();
        int ans = 0;

        for (int i = 1, t; (t = i * (i + 1) / 2) <= N; i++) {
            if ((N - (i * (i + 1) / 2)) % i == 0) ans++;
        }

        System.out.println(ans);
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
