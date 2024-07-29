package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11047_동전_0_v3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;

        int j = N - 1;
        for (int i = N - 1; i >= 0; i--) {
            if (K >= coins[i]) {
                int q = K / coins[i];
                K -= q * coins[i];
                ans += q;
            }

            if (K == 0) {
                break;
            }
        }

        System.out.println(ans);
    }
}