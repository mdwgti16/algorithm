package langjava.acmicpc;

import java.io.*;
import java.util.StringTokenizer;

public class _1850_최대공약수_v2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long gcm = gcm(a, b);
        while (gcm-- > 0) {
            bw.write("1");
        }
        bw.flush();
    }

    private static long gcm(long a, long b) {
        if (b == 0) {
            return a;
        }

        return gcm(b, a % b);
    }
}