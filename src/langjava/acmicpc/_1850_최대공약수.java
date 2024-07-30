package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1850_최대공약수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < gcm(a, b); i++) {
            sb.append("1");
        }

        System.out.println(sb);
    }

    private static long gcm(long a, long b) {
        if (b == 0) {
            return a;
        }

        return gcm(b, a % b);
    }
}