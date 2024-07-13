package langjava.acmicpc;

import java.io.*;
import java.util.*;

public class _1253_좋다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(nums);
        int ans = 0;
        for (int k = 0; k < n; k++) {
            int i = 0;
            int j = n - 1;
            long num = nums[k];

            while (i < j) {
                if (nums[i] + nums[j] == num) {
                    if (i == k) {
                        i++;
                    } else if (j == k) {
                        j--;
                    } else {
                        ans++;
                        break;
                    }
                } else if (nums[i] + nums[j] < num) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        System.out.println(ans);
    }
}