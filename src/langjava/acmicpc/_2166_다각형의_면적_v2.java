package langjava.acmicpc;

import java.io.DataInputStream;
import java.io.IOException;

public class _2166_다각형의_면적_v2 {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        int[][] points = new int[N][2];
        for (int i = 0; i < N; i++) {
            points[i] = new int[]{
                    fr.nextInt(),
                    fr.nextInt()
            };
        }

        long sum = ccw(points[N - 1][0], points[N - 1][1], points[0][0], points[0][1]);
        for (int i = 0; i < N - 1; i++) {
            sum += ccw(points[i][0], points[i][1], points[i + 1][0], points[i + 1][1]);
        }


        System.out.println(String.format("%.1f", Math.abs(sum) / 2.0));
    }

    private static long ccw(long x2, long y2, long x3, long y3) {
        return x2 * y3 - x3 * y2;
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