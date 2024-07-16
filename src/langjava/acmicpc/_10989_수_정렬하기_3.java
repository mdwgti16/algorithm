package langjava.acmicpc;

import java.io.*;

public class _10989_수_정렬하기_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M = 5;
        int K = 10;
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        int[] temp = new int[N];
        for (int i = 0; i < M; i++) {
            int[] tempIndex = new int[K];

            int digit = (int) Math.pow(K, i);
            for (int j = 0; j < N; j++) {
                tempIndex[(A[j] / digit) % K]++;
            }

            for (int j = 1; j < K; j++) {
                tempIndex[j] += tempIndex[j - 1];
            }

            for (int j = N - 1; j >= 0; j--) {
                temp[tempIndex[(A[j] / digit) % K]-- - 1] = A[j];
            }

            for (int j = 0; j < N; j++) {
                A[j] = temp[j];
            }
        }

        for (int i = 0; i < N; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
    }
}