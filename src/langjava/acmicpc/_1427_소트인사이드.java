package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1427_소트인사이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] N = br.readLine().toCharArray();

        for (int i = 0; i < N.length - 1; i++) {
            int max = i + 1;
            for (int j = i + 2; j < N.length; j++) {
                if (N[max] < N[j]) {
                    max = j;
                }
            }

            if (N[i] < N[max]) {
                char temp = N[i];
                N[i] = N[max];
                N[max] = temp;
            }
        }

        System.out.println(N);
    }
}