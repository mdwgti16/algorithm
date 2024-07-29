package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2166_다각형의_면적 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] points = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new int[]{
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            };
        }

        long sum = ccw(points[N - 1][0], points[N - 1][1], points[0][0], points[0][1]);
        for (int i = 0; i < N - 1; i++) {
            sum += ccw(points[i][0], points[i][1], points[i + 1][0], points[i + 1][1]);
        }


        System.out.println(String.format("%.1f", Math.abs(sum) / 2.0));
    }

    private static long ccw(long x2, long y2, long x3, long y3) {
        return x2 * y3 - x3 * y2;
    }

}