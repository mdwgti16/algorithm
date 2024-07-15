package langjava.acmicpc;

import java.io.DataInputStream;
import java.io.IOException;

public class _2751_수_정렬하기_2_v2 {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        int[] A = new int[N];
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = fr.nextInt();
        }

        mergeSort(0, N - 1, A, res);
        StringBuilder sb = new StringBuilder();
        for (int n : A) {
            sb.append(n).append("\n");
        }
        System.out.println(sb);
    }

    private static void mergeSort(int s, int e, int[] A, int[] res) {
        if (s == e) {
            return;
        }

        int M = (s + e) / 2;
        mergeSort(s, M, A, res);
        mergeSort(M + 1, e, A, res);

        int i = s;
        int j = M + 1;
        for (int k = s; k <= e; k++) {
            if (j > e) {
                res[k] = A[i++];
            } else if (i > M) {
                res[k] = A[j++];
            } else if (A[i] > A[j]) {
                res[k] = A[j++];
            } else {
                res[k] = A[i++];
            }
        }

        for (int k = s; k <= e; k++) {
            A[k] = res[k];
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
