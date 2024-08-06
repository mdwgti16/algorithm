package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1325_효율적인_해킹_bfs {
    private static List<Integer>[] graph;
    private static boolean[] visited;
    private static int[] counts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        counts = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }


        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            counting(i);
        }

        StringBuilder sb = new StringBuilder();
        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (counts[i] > max) {
                max = counts[i];
                sb = new StringBuilder(i + " ");
            } else if (counts[i] == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    private static void counting(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;
        while (!q.isEmpty()) {
            int n = q.poll();

            for (int e : graph[n]) {
                if (!visited[e]) {
                    visited[e] = true;
                    counts[e]++;
                    q.add(e);
                }
            }
        }
    }
}