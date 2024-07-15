package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11004_K번째_수_v2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(0, N - 1, A, K - 1);
        System.out.println(A[K - 1]);
    }

    private static void quickSort(int s, int e, int[] A, int K) {
        if (s < e) {
            int p = partition(s, e, A);
            if (K < p) {
                quickSort(s, p - 1, A, K);
            } else if (p < K) {
                quickSort(p + 1, e, A, K);
            }
        }
    }

    private static int partition(int s, int e, int[] A) {
        if (s + 1 == e) {
            if (A[s] > A[e]) {
                swap(A, s, e);
            }

            return e;
        }

        int M = (s + e) / 2;
        int pivot = A[M];
        swap(A, s, M);
        int i = s + 1;
        int j = e;

        while (i <= j) {
            while (A[i] < pivot) {
                i++;
            }

            while (pivot < A[j]) {
                j--;
            }

            if (i <= j) {
                swap(A, i++, j--);
            }
        }

        A[s] = A[j];
        A[j] = pivot;

        return j;
    }


    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
