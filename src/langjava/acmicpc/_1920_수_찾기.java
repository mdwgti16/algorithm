package langjava.acmicpc;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1920_수_찾기 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] AN;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        AN = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            AN[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] AM = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            AM[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(AN);

        for (int i = 0; i < M; i++) {
            DFS(0, N - 1, AM[i]);
        }

        bw.flush();
    }

    private static void DFS(int s, int e, int k) throws IOException {
        int m = (s + e) / 2;

        if (AN[m] == k) {
            bw.write("1\n");
            return;
        }
        if (s >= e) {
            bw.write("0\n");
            return;
        }

        if (AN[m] > k) {
            DFS(s, m - 1, k);
        } else {
            DFS(m + 1, e, k);
        }
    }
}