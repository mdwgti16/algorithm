package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1002_Turret {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int length = Integer.parseInt(st.nextToken());

        for (int i = 0; i < length; i++) {
            st = new StringTokenizer(bf.readLine());
            double x1 = Double.parseDouble(st.nextToken());
            double y1 = Double.parseDouble(st.nextToken());
            double r1 = Double.parseDouble(st.nextToken());
            double x2 = Double.parseDouble(st.nextToken());
            double y2 = Double.parseDouble(st.nextToken());
            double r2 = Double.parseDouble(st.nextToken());

            double d = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);

            if (x1 == x2 && y1 == y2 && r1 == r2) {
                System.out.println(-1);
            } else if (Math.pow(r2 - r1, 2) == d || Math.pow(r1 + r2, 2) == d) {
                System.out.println(1);
            } else if (Math.pow(r2 - r1, 2) < d && Math.pow(r1 + r2, 2) > d) {
                System.out.println(2);
            } else {
                System.out.println(0);
            }
        }
    }
}