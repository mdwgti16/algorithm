package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1744_수_묶기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        int negative = 0;
        int one = 0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n <= 0) {
                negative++;
            } else if (n == 1) {
                one++;
            }

            nums[i] = n;
        }

        Arrays.sort(nums);
        int ans = one;

        int posRemain = (N - negative - one) % 2;
        if (posRemain != 0) {
            ans += nums[negative + one];
        }

        int negRemain = negative % 2;
        if (negRemain != 0) {
            ans += nums[negative - 1];
        }

        for (int i = N - 1; i >= negative + one + posRemain; i -= 2) {
            ans += nums[i] * nums[i - 1];
        }

        for (int i = 0; i < negative - negRemain; i += 2) {
            ans += nums[i] * nums[i + 1];
        }

        System.out.println(ans);
    }
}