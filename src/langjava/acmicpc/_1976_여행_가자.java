package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1976_여행_가자 {
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parents = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (st.nextToken().equals("1")) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int parent = find(Integer.parseInt(st.nextToken()));
        int j = 1;
        for (; j < M; j++) {
            if (find(Integer.parseInt(st.nextToken())) != parent) {
                break;
            }
        }

        System.out.println(j == M
                ? "YES"
                : "NO");
    }

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x != y) {
            parents[y] = parents[x];
        }
    }

    private static int find(int n) {
        if (parents[n] == n) {
            return n;
        } else {
            return parents[n] = find(parents[n]);
        }
    }
}