package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1541_잃어버린_괄호_v2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] expressions = br.readLine().split("-");
        int ans = getSum(expressions[0]);
        for (int i = 1; i < expressions.length; i++) {
            ans -= getSum(expressions[i]);
        }

        System.out.println(ans);
    }

    private static int getSum(String expressions) {
        int sum = 0;
        for (String n : expressions.split("\\+")) {
            sum += Integer.parseInt(n);
        }
        return sum;
    }
}