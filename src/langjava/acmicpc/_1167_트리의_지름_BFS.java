package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1167_트리의_지름_BFS {
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        graph = new List[V + 1];
        StringTokenizer st;

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            while (true) {
                int e = Integer.parseInt(st.nextToken());
                if (e == -1) {
                    break;
                }
                int v = Integer.parseInt(st.nextToken());

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
}