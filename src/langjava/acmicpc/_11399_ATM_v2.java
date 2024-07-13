package langjava.acmicpc;

import java.io.IOException;

public class _11399_ATM_v2 {
    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            int k = readInt();

            int j = i - 1;
            while (j >= 0) {
                if (P[j] <= k) {
                    break;
                }
                P[j + 1] = P[j];
                j--;
            }

            P[j + 1] = k;
        }

        int sum = 0;
        int res = 0;
        for (int i : P) {
            sum = sum + i;
            res += sum;
        }
        System.out.println(res);
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