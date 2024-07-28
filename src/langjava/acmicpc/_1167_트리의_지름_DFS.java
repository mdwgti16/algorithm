package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1167_트리의_지름_DFS {
    static class Node {
        int e;
        long v;

        public Node(int e, long v) {
            this.e = e;
            this.v = v;
        }
    }

    private static List<Node>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
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

        visited = new boolean[V + 1];
        visited[1] = true;
        int n = DFS(1, 0).e;
        visited = new boolean[V + 1];
        visited[n] = true;
        System.out.println(DFS(n, 0).v);
    }

    private static Node DFS(int n, long diameter) {
        Node ans = new Node(-1, 0);
        List<Node> nodes = graph[n];
        visited[n] = true;

        for (Node node : nodes) {
            if (!visited[node.e]) {
                Node res = DFS(node.e, diameter + node.v);
                if (res.v > ans.v) {
                    ans = res;
                }
            }
        }

        if (ans.v == 0) {
            ans = new Node(n, diameter);
        }

        return ans;
    }
}