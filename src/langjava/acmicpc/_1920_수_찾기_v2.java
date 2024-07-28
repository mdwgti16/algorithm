package langjava.acmicpc;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _1920_수_찾기_v2 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] AN;
    private static int N;

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        AN = new int[N];

        for (int i = 0; i < N; i++) {
            AN[i] = fr.nextInt();
        }

        int M = fr.nextInt();
        int[] AM = new int[M];

        for (int i = 0; i < M; i++) {
            AM[i] = fr.nextInt();
        }

        Arrays.sort(AN);

        for (int i = 0; i < M; i++) {
            DFS(0, N - 1, AM[i]);
        }

        bw.flush();
    }

    private static void DFS(int s, int e, int k) throws IOException {
        int m = (s + e) / 2;

        if (AN[m] == k) {
            bw.write("1\n");
            return;
        }
        if (s >= e) {
            bw.write("0\n");
            return;
        }

        if (AN[m] > k) {
            DFS(s, m - 1, k);
        } else {
            DFS(m + 1, e, k);
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