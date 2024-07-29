package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2162_선분_그룹 {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] lines = new int[N][4];
        parent = new int[N];
        int[] counts = new int[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            st = new StringTokenizer(br.readLine());
            lines[i] = new int[]{
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            };
        }


        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isCross(lines[i][0], lines[i][1], lines[i][2], lines[i][3],
                        lines[j][0], lines[j][1], lines[j][2], lines[j][3])) {
                    union(i, j);
                }
            }
        }

        int lineCount = 0;
        int maxSize = 0;
        for (int i : parent) {
            counts[find(i)]++;
        }

        for (int i = 0; i < N; i++) {
            if (counts[i] > 0) {
                lineCount++;
                maxSize = Math.max(maxSize, counts[i]);
            }
        }

        System.out.println(lineCount + "\n" + maxSize);
    }

    private static boolean isCross(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int l1 = ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4);
        int l2 = ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2);

        return (l1 == -1 && l2 == -1) || (l1 <= 0 && l2 <= 0 &&
                Math.min(x1, x2) <= Math.max(x3, x4) && Math.min(x3, x4) <= Math.max(x1, x2) &&
                Math.min(y1, y2) <= Math.max(y3, y4) && Math.min(y3, y4) <= Math.max(y1, y2));
    }

    private static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long temp = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);
        if (temp > 0) {
            return 1;
        } else if (temp < 0) {
            return -1;
        } else {
            return 0;
        }
    }


    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x != y) {
            parent[y] = x;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }
}