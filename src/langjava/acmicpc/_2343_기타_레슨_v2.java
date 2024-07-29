package langjava.acmicpc;

import java.io.DataInputStream;
import java.io.IOException;

public class _2343_기타_레슨_v2 {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        int M = fr.nextInt();
        int[] times = new int[N];
        int start = 0;
        int end = 0;

        for (int i = 0; i < N; i++) {
            times[i] = fr.nextInt();
            start = Math.max(start, times[i]);
            end += times[i];
        }

        while (start <= end) {
            int middle = (start + end) / 2;
            int count = 1;
            int sum = 0;

            for (int i = 0; i < N; i++) {
                if (sum + times[i] > middle) {
                    sum = times[i];
                    count++;
                } else {
                    sum += times[i];
                }
            }

            if (count > M) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        System.out.println(start);
    }

    public static class FastReader {
        private final DataInputStream din;
        private final int BUFFER_SIZE = 1 << 21;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[BUFFER_SIZE]; // input line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    break;
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = (ret << 3) + (ret << 1) + (c & 15);
            } while ((c = read()) > 32);

            return neg ? ~ret + 1 : ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }
    }
}