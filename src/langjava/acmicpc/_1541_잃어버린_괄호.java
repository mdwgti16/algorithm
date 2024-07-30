package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1541_잃어버린_괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        StringBuilder sb = new StringBuilder();
        int[] nums = new int[25];
        int index = 0;
        int temp = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if ('0' <= c && c <= '9') {
                sb.append(c);
            } else {
                int n = Integer.parseInt(sb.toString());
                if (c == '-') {
                    nums[index++] = temp + n;
                    temp = 0;
                } else {
                    temp += n;
                }
                sb = new StringBuilder();
            }
        }

        nums[index++] = temp + Integer.parseInt(sb.toString());

        int ans = nums[0];
        for (int i = 1; i < index; i++) {
            ans -= nums[i];
        }

        System.out.println(ans);
    }
}