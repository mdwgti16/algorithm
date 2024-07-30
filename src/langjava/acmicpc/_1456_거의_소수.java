package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1456_거의_소수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());


        int max = (int) Math.sqrt(B);
        boolean[] primes = new boolean[max + 1];
        int ans = 0;
        for (int i = 2; i <= max; i++) {
            if (primes[i]) {
                continue;
            }

            for (int j = 2; i * j <= max; j++) {
                primes[i * j] = true;
            }

            for (int j = 2; ; j++) {
                long pow = (long) Math.pow(i, j);
                if (pow > B) {
                    break;
                }

                if (pow >= A) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}