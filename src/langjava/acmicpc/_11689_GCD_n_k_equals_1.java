package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11689_GCD_n_k_equals_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        int sqrt = (int) Math.sqrt(N);
        long ans = N;
        for (int i = 2; i <= sqrt; i++) {
            if (N % i == 0) {
                ans -= ans / i;
                while (N % i == 0) {
                    N /= i;
                }
            }
        }

        if (N > 1) {
            ans -= ans / N;
        }

        System.out.println(ans);
    }
}