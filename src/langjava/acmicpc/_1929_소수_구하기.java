package langjava.acmicpc;

import java.io.*;
import java.util.StringTokenizer;

public class _1929_소수_구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[M + 1];

        for (int i = 2; i <= M; i++) {
            if (check[i]) {
                continue;
            }

            for (int j = 2; i * j <= M; j++) {
                check[i * j] = true;
            }
        }

        for (int i = Math.max(2, N); i <= M; i++) {
            if (!check[i]) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
    }
}