package langjava.acmicpc;

import java.io.IOException;
import java.util.Arrays;

public class _1940_주몽_v2 {
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int m = readInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = readInt();
        }

        Arrays.sort(nums);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                if (sum == m) {
                    ans++;
                    break;
                } else if (sum > m) {
                    break;
                }
            }
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
