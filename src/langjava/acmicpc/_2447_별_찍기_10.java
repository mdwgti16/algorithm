package langjava.acmicpc;

import java.io.*;
import java.util.StringTokenizer;

public class _2447_별_찍기_10 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());


        for (int i = 1; i < N * 2; i++) {
            if (i % 2 == 0) {
                bw.write("\n");
                continue;
            }

            for (int col = 1; col <= N; col++) {
                int row = (i + 1) / 2;
                int pow = getCloseN(Math.min(row, col));

                if (isMiddle(row, col, pow)) {
                    bw.write(" ");
                } else {
                    bw.write("*");
                }
            }
        }

        bw.flush();
    }

    static private boolean isMiddle(int row, int col, int pow) {
        while (pow > 1) {
            row %= pow;
            col %= pow;
            int q = pow / 3;
            if ((row > q && row <= q * 2) && (col > q && col <= q * 2)) {
                return true;
            }

            pow /= 3;
        }

        return false;
    }

    static private int getCloseN(int number) {
        int n = 3;

        for (int i = 1; i <= 8; i++) {
            if (number < n) {
                return n;
            }

            n *= 3;
        }

        return n;
    }
}