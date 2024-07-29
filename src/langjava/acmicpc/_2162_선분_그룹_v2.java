package langjava.acmicpc;

import java.io.DataInputStream;
import java.io.IOException;

public class _2162_선분_그룹_v2 {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        int[][] lines = new int[N][4];
        parent = new int[N];
        int[] counts = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            lines[i] = new int[]{
                    fr.nextInt(),
                    fr.nextInt(),
                    fr.nextInt(),
                    fr.nextInt()
            };
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isCross(lines[i][0], lines[i][1], lines[i][2], lines[i][3],
                        lines[j][0], lines[j][1], lines[j][2], lines[j][3])) {
                    union(i, j);
                }
            }
        }

        int lineCount = 0;
        int maxSize = 0;
        for (int i : parent) {
            counts[find(i)]++;
        }

        for (int i = 0; i < N; i++) {
            if (counts[i] > 0) {
                lineCount++;
                maxSize = Math.max(maxSize, counts[i]);
            }
        }

        System.out.println(lineCount + "\n" + maxSize);
    }

    private static boolean isCross(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int l1 = ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4);
        int l2 = ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2);

        return (l1 == -1 && l2 == -1) || (l1 <= 0 && l2 <= 0 &&
                Math.min(x1, x2) <= Math.max(x3, x4) && Math.min(x3, x4) <= Math.max(x1, x2) &&
                Math.min(y1, y2) <= Math.max(y3, y4) && Math.min(y3, y4) <= Math.max(y1, y2));
    }

    private static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long temp = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);
        if (temp > 0) {
            return 1;
        } else if (temp < 0) {
            return -1;
        } else {
            return 0;
        }
    }


    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x != y) {
            parent[y] = x;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
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