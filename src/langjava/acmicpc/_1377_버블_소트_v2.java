package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1377_버블_소트_v2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] A = new int[1000001];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            A[arr[i]]++;
        }

        int s = 0;
        for (int i = 0; i <= 1000000; i++) {
            s += A[i];
            A[i] = s - 1;
        }

        int m = 0;
        for (int i = 0; i < N; i++) {
            m = Math.max(m, i - A[arr[i]]);
        }

        System.out.println(m + 1);
    }
}