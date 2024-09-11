package langjava.acmicpc;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _2252_줄_세우기_v2 {
    private static List<Integer>[] graph;
    private static int[] phases;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        int M = fr.nextInt();


        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        phases = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int n = fr.nextInt();
            int e = fr.nextInt();
            phases[e]++;
            graph[n].add(e);
        }

        boolean isDone = false;
        while (!isDone) {
            isDone = true;
            for (int i = 1; i <= N; i++) {
                if (phases[i] == 0) {
                    isDone = false;
                    BFS(i);
                }
            }
        }

        System.out.println(sb);
    }

    public static void BFS(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while (!q.isEmpty()) {
            Integer n = q.poll();
            phases[n]--;
            sb.append(n + " ");
            List<Integer> edges = graph[n];
            if (edges != null) {
                for (Integer e : edges) {
                    phases[e]--;
                    if (phases[e] == 0) {
                        q.add(e);
                    }
                }
            }
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