package langjava.acmicpc;

import java.io.*;
import java.util.StringTokenizer;

public class _2442_별_찍기_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < N - i; j++) {
                bw.write(" ");
            }

            for (int j = 0; j < 2 * i - 1; j++) {
                bw.write("*");
            }

            bw.write("\n");
        }

        bw.flush();
    }
}