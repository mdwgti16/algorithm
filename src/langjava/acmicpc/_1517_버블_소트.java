package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1517_버블_소트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(mergeSort(0, N - 1, A, new int[N]));
    }

    private static long mergeSort(int s, int e, int[] A, int[] B) {
        long swap = 0;
        if (s == e) {
            return swap;
        }

        int M = (s + e) / 2;
        swap += mergeSort(s, M, A, B);
        swap += mergeSort(M + 1, e, A, B);

        int i = s;
        int j = M + 1;
        for (int k = s; k <= e; k++) {
            if (i > M) {
                B[k] = A[j++];
            } else if (j > e) {
                B[k] = A[i++];
            } else if (A[i] > A[j]) {
                B[k] = A[j++];
                swap += M - i + 1;
            } else {
                B[k] = A[i++];
            }
        }

        for (int k = s; k <= e; k++) {
            A[k] = B[k];
        }

        return swap;
    }
}