package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2343_기타_레슨 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] times = new int[N];
        st = new StringTokenizer(br.readLine());
        int start = 0;
        int end = 0;

        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
            start = Math.max(start, times[i]);
            end += times[i];
        }

        while (start <= end) {
            int middle = (start + end) / 2;
            int count = 1;
            int sum = 0;

            for (int i = 0; i < N; i++) {
                if (sum + times[i] > middle) {
                    sum = times[i];
                    count++;
                } else {
                    sum += times[i];
                }
            }

            if (count > M) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        System.out.println(start);
    }
}