package langjava.acmicpc;

import java.io.*;
import java.util.StringTokenizer;

public class _2445_별_찍기_9 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            write(i, (N - i) * 2 - 1);
        }
        for (int i = N - 2; i >= 0; i--) {
            write(i, (N - i) * 2 - 1);
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