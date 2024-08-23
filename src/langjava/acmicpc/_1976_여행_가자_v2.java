package langjava.acmicpc;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.StringTokenizer;

public class _1976_여행_가자_v2 {
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        int M = fr.nextInt();
        parents = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (fr.nextInt() == 1) {
                    union(i, j);
                }
            }
        }

        int parent = find(fr.nextInt());
        int j = 1;
        for (; j < M; j++) {
            if (find(fr.nextInt()) != parent) {
                break;
            }
        }

        System.out.println(j == M
                ? "YES"
                : "NO");
    }

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x != y) {
            parents[y] = parents[x];
        }
    }

    private static int find(int n) {
        if (parents[n] == n) {
            return n;
        } else {
            return parents[n] = find(parents[n]);
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