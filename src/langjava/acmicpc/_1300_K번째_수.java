package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1300_K번째_수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int start = 0;
        int end = K;
        while (start <= end) {
            int middle = (start + end) / 2;
            int count = 0;
            for (int i = 1; i <= N; i++) {
                int temp = middle / i;
                if (temp > N) {
                    temp = N;
                }
                count += temp;
            }

            if (count < K) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        System.out.println(start);
    }
}