package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2444_별_찍기_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N * 2 - 1; i++) {
            int end = i <= N
                    ? N - i + 2 * i - 1
                    : i - N + 2 * (2 * N - i) - 1;
            for (int j = 0; j < end; j++) {
                if (i <= N && j < N - i) {
                    sb.append(" ");
                    continue;
                } else if (j < i - N) {
                    sb.append(" ");
                    continue;
                }

                sb.append("*");
            }
            sb.append("\n");
        }

        sb.append("\n");
        System.out.println(sb);
    }
}