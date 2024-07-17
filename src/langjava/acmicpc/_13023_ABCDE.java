package langjava.acmicpc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _13023_ABCDE {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[n].add(e);
            graph[e].add(n);
        }


        boolean isExists = false;
        for (int i = 0; i < N; i++) {
            if (DFS(i, 0, new boolean[N])) {
                isExists = true;
                break;
            }
        }

        bw.write(isExists ? "1" : "0");
        bw.flush();
    }

    private static boolean DFS(int i, int count, boolean[] visited) {
        if (count == 4) {
            return true;
        }
        visited[i] = true;
        for (Integer e : graph[i]) {
            if (visited[e]) {
                continue;
            }
            boolean[] copiedVisited = new boolean[visited.length];
            System.arraycopy(visited, 0, copiedVisited, 0, visited.length);
            if (DFS(e, count + 1, copiedVisited)) {
                return true;
            }
        }

        return false;
    }
}