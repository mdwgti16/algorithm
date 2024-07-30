package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1016_제곱이_아닌_수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] check = new boolean[(int) (max - min) + 1];

        for (long i = 2; ; i++) {
            long pow = i * i;
            if (pow > max) {
                break;
            }
            long start = min / pow;
            if (min % pow != 0) {
                start++;
            }

            for (long j = start; ; j++) {
                long n = pow * j;
                if (n > max) {
                    break;
                }

                check[(int) (n - min)] = true;
            }
        }

        int ans = 0;
        for (boolean answer : check) {
            if (!answer) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}