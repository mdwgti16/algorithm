package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1043_거짓말 {
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] parties = new int[M];
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        for (int i = 0; i < count; i++) {
            union(0, Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            for (int j = 1; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                union(prev, temp);
                prev = temp;
            }

            parties[i] = prev;
        }

        for (int i = 0; i < M; i++) {
            if (find(parties[i]) != find(0)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x != y) {
            parents[y] = parents[x];
        }
    }

    private static int find(int n) {
        if (n == parents[n]) {
            return n;
        } else {
            return parents[n] = find(parents[n]);
        }
    }
}