package langjava.acmicpc;

import java.io.IOException;

public class _1940_주몽_v3 {
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int m = readInt();

        int[] nums = new int[n];
        boolean[] isIn = new boolean[10_000_001];
        for (int i = 0; i < n; i++) {
            int k = readInt();
            nums[i] = k;
            isIn[k] = true;
        }

        int ans = 0;
        for (int k : nums) {
            if (m - k > 0 && isIn[m - k]) {
                ans++;
            }
        }

        System.out.println(ans / 2);
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
