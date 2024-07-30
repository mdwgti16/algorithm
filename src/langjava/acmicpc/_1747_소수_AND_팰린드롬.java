package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1747_소수_AND_팰린드롬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Math.max(Integer.parseInt(br.readLine()), 2);

        int max = 10000000;
        boolean[] primes = new boolean[max + 1];
        int sqrt = (int) Math.sqrt(max);
        for (int i = 2; i <= sqrt; i++) {
            if (primes[i]) {
                continue;
            }

            if (i >= N && isPalindrome(i)) {
                System.out.println(i);
                return;
            }

            for (int j = 2; i * j <= max; j++) {
                primes[i * j] = true;
            }
        }

        for (int i = N; i < max; i++) {
            if (!primes[i] && isPalindrome(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    private static boolean isPalindrome(int n) {
        String number = String.valueOf(n);

        for (int i = 0; i < number.length() / 2; i++) {
            if (number.charAt(i) != number.charAt(number.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}