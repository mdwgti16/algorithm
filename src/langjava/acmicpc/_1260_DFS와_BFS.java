package langjava.acmicpc;

import java.io.*;
import java.util.*;

public class _1260_DFS와_BFS {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static List<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[n].add(e);
            graph[e].add(n);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N + 1];
        DFS(V);
        bw.write("\n");

        visited = new boolean[N + 1];
        BFS(V);

        bw.flush();
    }

    private static void DFS(int v) throws IOException {
        bw.write(v + " ");
        visited[v] = true;

        for (Integer e : graph[v]) {
            if (!visited[e]) {
                DFS(e);
            }
        }
    }

    private static void BFS(int v) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            Integer n = q.poll();
            bw.write(n + " ");
            for (Integer e : graph[n]) {
                if (!visited[e]) {
                    visited[e] = true;
                    q.add(e);
                }
            }
        }
    }

}