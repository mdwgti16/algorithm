package langjava.acmicpc;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _18352_특정_거리의_도시_찾기_v2 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static List<Integer>[] graph;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        int M = fr.nextInt();
        int K = fr.nextInt();
        int X = fr.nextInt();

        graph = new List[N + 1];
        visited = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            visited[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            graph[fr.nextInt()].add(fr.nextInt());
        }

        BFS(X, K);
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i] == K) {
                bw.write(i + "\n");
                sum++;
            }
        }

        if (sum == 0) {
            bw.write("-1");
        }
        bw.flush();
    }


    private static void BFS(int x, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x]++;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (Integer e : graph[node]) {
                if (visited[e] == -1) {
                    visited[e] = visited[node] + 1;
                    queue.add(e);
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