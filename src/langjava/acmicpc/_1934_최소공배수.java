package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1934_최소공배수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(a * b / gcd(a, b));
        }
    }

    private static int gcd(int a, int b) {
        while (true) {
            if (a < b) {
                int temp = a;
                a = b;
                b = temp;
            }

            int mod = a % b;
            if (mod == 0) {
                return b;
            } else {
                a = mod;
            }
        }
    }
}