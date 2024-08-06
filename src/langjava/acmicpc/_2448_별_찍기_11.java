package langjava.acmicpc;

import java.io.*;
import java.util.StringTokenizer;

public class _2448_별_찍기_11 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static boolean[][] stars;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        stars = new boolean[N][N * 2];
        int col = N - 4;

        checkFirstTriangle(col);

        int pow = 1;
        for (int i = 1; i < N / 3; i *= 2) {
            int k = pow * 6 / 2;
            copyTriangles(pow * 3, N - k, N + k);
            pow *= 2;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N * 2; j++) {
                if (stars[i][j]) {
                    bw.write("*");
                } else {
                    bw.write(" ");
                }
            }

            bw.write("\n");
        }

        bw.flush();
    }

    static private void checkFirstTriangle(int col) throws IOException {
        for (int i = 0; i < 3; i++) {
            int r = 3 - i;
            for (int j = 1; j <= 6 - r; j++) {
                if (j % r == 0) {
                    stars[i][col + j] = true;
                }
            }
        }
    }

    static private void copyTriangles(int endRow, int startCol, int endCol) {
        int width = endCol - startCol;
        for (int i = 0; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                int col = j - startCol;
                stars[i + endRow][N - width + col] = stars[i][j];
                stars[i + endRow][N + col] = stars[i][j];
            }
        }
    }
}