package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2178_미로_탐색_BFS_v2 {

    private static int[][] map;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        System.out.println(find(visited));
    }

    private static int find(boolean[][] visited) {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{0, 0, 1});
        visited[0][0] = true;

        int[] dx = new int[]{-1, 0, 0, 1};
        int[] dy = new int[]{0, -1, 1, 0};

        int res = 1;
        while (!q.isEmpty()) {
            Integer[] poll = q.poll();
            int i = poll[0], j = poll[1], count = poll[2];

            if (i == N - 1 && j == M - 1) {
                res = count;
            }

            for (int k = 0; k < 4; k++) {
                int row = i + dy[k];
                int col = j + dx[k];

                if (row >= 0 && col >= 0 && row < N && col < M) {
                    if (!visited[row][col] && map[row][col] == 1) {
                        visited[row][col] = true;
                        q.add(new Integer[]{row, col, count + 1});
                    }
                }
            }
        }

        return res;
    }
}