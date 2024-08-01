package langjava.acmicpc;

import java.io.*;
import java.util.StringTokenizer;

public class _2445_별_찍기_8 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            write(i, (N - i) * 2);
        }

        for (int i = N - 1; i > 0; i--) {
            write(i, (N - i) * 2);
        }

        bw.flush();
    }

    private static void write(int stars, int spaces) throws IOException {
        for (int i = 0; i < stars; i++) {
            bw.write("*");
        }

        for (int i = 0; i < spaces; i++) {
            bw.write(" ");
        }

        for (int i = 0; i < stars; i++) {
            bw.write("*");
        }

        bw.write("\n");
    }
}