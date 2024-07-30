package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1033_칵테일 {
    private static long[] weights;
    private static boolean[] visited;
    private static List<Node>[] graph;

    public static class Node {
        int e, p, q;

        public Node(int e, int p, int q) {
            this.e = e;
            this.p = p;
            this.q = q;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        weights = new long[N];
        visited = new boolean[N];
        graph = new List[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        long lcm = 1;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, p, q));
            graph[b].add(new Node(a, q, p));
            lcm = lcm * p * q / gcm(p, q);
        }

        weights[0] = lcm;
        calculate(0);

        long gcm = weights[0];
        for (int i = 1; i < N; i++) {
            gcm = gcm(weights[i], gcm);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(weights[i] / gcm).append(" ");
        }

        System.out.println(sb);
    }

    private static void calculate(int i) {
        for (Node node : graph[i]) {
            if (!visited[node.e]) {
                weights[node.e] = weights[i] * node.q / node.p;
                visited[node.e] = true;
                calculate(node.e);
            }
        }
    }

    private static long gcm(long a, long b) {
        if (b == 0) {
            return a;
        }

        return gcm(b, a % b);
    }
}