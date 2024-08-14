package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1707_이분_그래프 {
    private static List<Integer>[] graphs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graphs = new List[V + 1];

            for (int j = 1; j <= V; j++) {
                graphs[j] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

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
}