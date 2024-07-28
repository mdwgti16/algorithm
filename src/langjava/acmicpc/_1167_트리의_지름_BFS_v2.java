package langjava.acmicpc;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.*;

public class _1167_트리의_지름_BFS_v2 {
    static class Node {
        int e;
        long v;

        public Node(int e, long v) {
            this.e = e;
            this.v = v;
        }
    }

    private static List<Node>[] graph;
    private static int V;

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        V = fr.nextInt();
        graph = new List[V + 1];
        StringTokenizer st;

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for (int i = 1; i <= V; i++) {
            int n = fr.nextInt();

            while (true) {
                int e = fr.nextInt();
                if (e == -1) {
                    break;
                }
                int v = fr.nextInt();

                graph[n].add(new Node(e, v));
            }
        }

        System.out.println(BFS(BFS(1).e).v);
    }

    private static Node BFS(int n) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(n, 0));
        boolean[] visited = new boolean[V + 1];
        visited[n] = true;

        Node res = new Node(-1, 0);
        while (!q.isEmpty()) {
            Node poll = q.poll();
            if (res.v < poll.v) {
                res = poll;
            }

            for (Node node : graph[poll.e]) {
                if (!visited[node.e]) {
                    visited[node.e] = true;
                    q.add(new Node(node.e, node.v + poll.v));
                }
            }
        }

        return res;
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