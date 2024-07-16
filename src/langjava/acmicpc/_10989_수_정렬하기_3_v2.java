package langjava.acmicpc;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class _10989_수_정렬하기_3_v2 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        int M = 5;
        int K = 10;
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = fr.nextInt();
        }

        int[] temp = new int[N];
        for (int i = 0; i < M; i++) {
            int[] tempIndex = new int[K];

            int digit = (int) Math.pow(K, i);
            for (int j = 0; j < N; j++) {
                tempIndex[(A[j] / digit) % K]++;
            }

            for (int j = 1; j < K; j++) {
                tempIndex[j] += tempIndex[j - 1];
            }

            for (int j = N - 1; j >= 0; j--) {
                temp[tempIndex[(A[j] / digit) % K]-- - 1] = A[j];
            }

            for (int j = 0; j < N; j++) {
                A[j] = temp[j];
            }
        }

        for (int i = 0; i < N; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
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