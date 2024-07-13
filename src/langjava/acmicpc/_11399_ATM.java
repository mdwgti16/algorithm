package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());

            int j = i - 1;
            while (j >= 0) {
                if (P[j] <= k) {
                    break;
                }
                P[j + 1] = P[j];
                j--;
            }

            P[j + 1] = k;
        }

        int sum = 0;
        int res = 0;
        for (int i : P) {
            sum = sum + i;
            res += sum;
        }
        System.out.println(res);
    }
}