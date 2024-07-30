package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1016_제곱이_아닌_수_v2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        int ans = (int) (max - min) + 1;
        boolean[] check = new boolean[ans];
        int sqrt = (int) Math.sqrt(max);
        for (long i = 2; i <= sqrt; i++) {
            long pow = i * i;

            long start = min / pow;
            if (min % pow != 0) {
                start++;
            }

            for (long n = pow * start; n <= max; n += pow) {
                int index = (int) (n - min);
                if (!check[index]) {
                    check[index] = true;
                    ans--;
                }
            }
        }

        System.out.println(ans);
    }
}