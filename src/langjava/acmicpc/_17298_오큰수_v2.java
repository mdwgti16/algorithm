package langjava.acmicpc;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class _17298_오큰수_v2 {
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = readInt();
        }

        int[] res = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int k = nums[i];

            while (!deque.isEmpty() && nums[deque.getLast()] < k) {
                res[deque.removeLast()] = k;
            }

            deque.addLast(i);
        }

        while (!deque.isEmpty()) {
            res[deque.removeLast()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : res) {
            sb.append(i).append(" ");
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