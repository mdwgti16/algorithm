package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2751_수_정렬하기_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, N - 1, A, res);
        StringBuilder sb = new StringBuilder();
        for (int n : A) {
            sb.append(n).append("\n");
        }
        System.out.println(sb);
    }

    private static void mergeSort(int s, int e, int[] A, int[] res) {
        if (s == e) {
            return;
        }

        int M = (s + e) / 2;
        mergeSort(s, M, A, res);
        mergeSort(M + 1, e, A, res);

        int i = s;
        int j = M + 1;
        for (int k = s; k <= e; k++) {
            if (j > e) {
                res[k] = A[i++];
            } else if (i > M) {
                res[k] = A[j++];
            } else if (A[i] > A[j]) {
                res[k] = A[j++];
            } else {
                res[k] = A[i++];
            }
        }

        for (int k = s; k <= e; k++) {
            A[k] = res[k];
        }
    }
}
