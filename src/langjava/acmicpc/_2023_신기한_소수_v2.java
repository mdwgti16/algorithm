package langjava.acmicpc;

import java.io.*;

public class _2023_신기한_소수_v2 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] primes = new int[]{1, 3, 5, 7, 9};
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        DFS(2);
        DFS(3);
        DFS(5);
        DFS(7);

        bw.flush();
    }

    private static void DFS(int num) throws IOException {
        if (String.valueOf(num).length() == N) {
            bw.write(num + "\n");
            return;
        }


        for (int prime : primes) {
            int temp = num * 10 + prime;
            if (isPrime(temp)) {
                DFS(temp);
            }
        }
    }

    private static boolean isPrime(int n) {
        int m = (int) Math.sqrt(n);
        for (int i = 2; i <= m; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}