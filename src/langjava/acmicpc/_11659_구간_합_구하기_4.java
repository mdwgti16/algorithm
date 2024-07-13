package langjava.acmicpc;

import java.io.IOException;

public class _11659_구간_합_구하기_4 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int numberLength = readInt();
        int count = readInt();
        int[] sums = new int[numberLength + 1];
        for (int i = 0; i < numberLength; i++) {
            sums[i + 1] = sums[i] + readInt();
        }

        for (int k = 0; k < count; k++) {
            int i = readInt() - 1;
            int j = readInt();
            sb.append(sums[j] - sums[i]).append("\n");
        }

        System.out.println(sb);
    }

    static final int BUFFER_SIZE = 1 << 13;
    static byte[] buffer = new byte[BUFFER_SIZE];
    static int bufferLen, bufferIdx;

    static int readInt() throws IOException {
        byte b;
        int n = 0;
        while((b=read()) <= 32);
        do {
            n = (n<<3) + (n<<1) + (b&15);
        }while(isNumber(b=read()));

        return n;
    }

    static boolean isNumber(byte b) {
        return 47 < b && b < 58;
    }

    static byte read() throws IOException {
        if(bufferIdx == bufferLen) {
            bufferLen = System.in.read(buffer, bufferIdx=0, BUFFER_SIZE);
            if(bufferLen == -1) {
                buffer[0] = -1;
            }
        }
        return buffer[bufferIdx++];
    }
}
