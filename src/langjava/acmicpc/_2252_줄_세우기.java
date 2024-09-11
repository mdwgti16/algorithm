package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2252_줄_세우기 {
    private static List<Integer>[] graph;
    private static int[] phases;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        phases = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
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

}