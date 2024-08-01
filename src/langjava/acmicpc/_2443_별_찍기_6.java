package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2443_별_찍기_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = N; i > 0; i--) {
            for (int j = 0; j < N - i + 2 * i - 1; j++) {
                if (j < N - i) {
                    sb.append(" ");
                    continue;
                }
                sb.append("*");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}