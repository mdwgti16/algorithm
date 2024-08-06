package langjava.acmicpc;

import java.io.*;

public class _2523_별_찍기_13 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            printStart(i, N - i);
        }

        for (int i = N - 1; i > 0; i--) {
            printStart(i, N - i);
        }

        bw.flush();
    }

    private static void printStart(int starts, int spaces) throws IOException {
        for (int i = 0; i < starts; i++) {
            bw.write("*");
        }

        bw.write("\n");
    }

}