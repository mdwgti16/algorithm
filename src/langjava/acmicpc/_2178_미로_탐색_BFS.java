package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2178_미로_탐색_BFS {

    private static int[][] map;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        boolean[][] visited = new boolean[N + 2][M + 2];
        for (int i = 1; i <= N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(split[j - 1]);
            }
        }

        for (int i = 0; i <= N; i++) {
            visited[i][0] = true;
            visited[i][M + 1] = true;
        }

        for (int j = 0; j <= M; j++) {
            visited[0][j] = true;
            visited[N + 1][j] = true;
        }

        System.out.println(find(visited));
    }

    private static int find(boolean[][] visited) {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{1, 1, 1});
        visited[1][1] = true;
        int res = 1;
        while (!q.isEmpty()) {
            Integer[] poll = q.poll();
            int i = poll[0], j = poll[1], count = poll[2];

            if (i == N && j == M) {
                res = count;
            }

            if (!visited[i][j - 1] && map[i][j - 1] == 1) {
                visited[i][j - 1] = true;
                q.add(new Integer[]{i, j - 1, count + 1});
            }
            if (!visited[i][j + 1] && map[i][j + 1] == 1) {
                visited[i][j + 1] = true;
                q.add(new Integer[]{i, j + 1, count + 1});
            }

            if (!visited[i - 1][j] && map[i - 1][j] == 1) {
                visited[i - 1][j] = true;
                q.add(new Integer[]{i - 1, j, count + 1});
            }

            if (!visited[i + 1][j] && map[i + 1][j] == 1) {
                visited[i + 1][j] = true;
                q.add(new Integer[]{i + 1, j, count + 1});
            }
        }

        return res;
    }
}