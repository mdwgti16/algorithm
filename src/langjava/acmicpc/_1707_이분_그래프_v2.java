package langjava.acmicpc;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _1707_이분_그래프_v2 {
    private static List<Integer>[] graphs;

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int K = fr.nextInt();

        for (int i = 0; i < K; i++) {
            int V = fr.nextInt();
            int E = fr.nextInt();

            graphs = new List[V + 1];

            for (int j = 1; j <= V; j++) {
                graphs[j] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                int n = fr.nextInt();
                int e = fr.nextInt();

                graphs[n].add(e);
                graphs[e].add(n);
            }

            int[] checks = new int[V + 1];
            boolean isBipartite = true;
            for (int j = 1; j <= V; j++) {
                if (checks[j] == 0) {
                    isBipartite &= isBipartite(j, checks);
                }
            }
            System.out.println(isBipartite ? "YES" : "NO");
        }

    }

    private static boolean isBipartite(int i, int[] checks) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        checks[i] = 1;

        while (!q.isEmpty()) {
            Integer n = q.poll();
            int check = checks[n];

            List<Integer> graph = graphs[n];
            if (graph != null) {
                for (Integer v : graph) {
                    if (check == checks[v]) {
                        return false;
                    }

                    if (checks[v] == 0) {
                        checks[v] = check * -1;
                        q.add(v);
                    }
                }
            }
        }

        return true;
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