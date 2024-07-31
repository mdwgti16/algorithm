package langjava.acmicpc;

import java.io.*;
import java.util.*;

public class _18352_특정_거리의_도시_찾기 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static List<Integer>[] graph;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        visited = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            visited[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            graph[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
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
}