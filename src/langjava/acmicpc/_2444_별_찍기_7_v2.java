package langjava.acmicpc;

import java.io.*;
import java.util.StringTokenizer;

public class _2444_별_찍기_7_v2 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            write(N - i, i * 2 - 1);
        }

        for (int i = N - 1; i > 0; i--) {
            write(N - i, i * 2 - 1);
        }

        bw.flush();
    }

    private static void write(int spaces, int stars) throws IOException {
        for (int i = 0; i < spaces; i++) {
            bw.write(" ");
        }

        for (int i = 0; i < stars; i++) {
            bw.write("*");
        }

        bw.write("\n");
    }
}