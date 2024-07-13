package langjava.acmicpc;

import java.io.IOException;

public class _1546_평균 {
    public static void main(String[] args) throws IOException {
        int length = readInt();
        double sum = 0;
        int maxScore = 0;
        for (int i = 0; i < length; i++) {
            int score = readInt();
            maxScore = Math.max(maxScore, score);
            sum += score;
        }
        System.out.println(100 * sum / maxScore / length);
    }

    private static int readInt() throws IOException {
        int value = 0;
        while (true) {
            int n = System.in.read();
            if (n == ' ' || n == '\n') {
                break;
            }
            value = value * 10 + n - '0';
        }
        return value;
    }
}
