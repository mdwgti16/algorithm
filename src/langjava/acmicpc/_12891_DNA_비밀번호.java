package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12891_DNA_비밀번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        char[] chars = br.readLine().toCharArray();

        int[] targetCount = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            targetCount[i] = Integer.parseInt(st.nextToken());
        }

        int[] currentCounts = new int[4];
        for (int i = 0; i < p; i++) {
            add(chars[i], targetCount, currentCounts);
        }

        int check = checkCount(targetCount, currentCounts);
        int ans = 0;
        int i = 0;
        int j = p;
        while (true) {
            if (check == 4) {
                ans++;
            }

            if (j >= s) {
                break;
            }
            if (remove(chars[i++], targetCount, currentCounts)) {
                check--;
            }

            if (add(chars[j++], targetCount, currentCounts)) {
                check++;
            }
        }

        System.out.println(ans);
    }

    private static boolean add(char c, int[] targetCount, int[] currentCounts) {
        if ('A' == c) {
            return ++currentCounts[0] == targetCount[0];
        } else if ('C' == c) {
            return ++currentCounts[1] == targetCount[1];
        } else if ('G' == c) {
            return ++currentCounts[2] == targetCount[2];
        } else if ('T' == c) {
            return ++currentCounts[3] == targetCount[3];
        }

        return false;
    }

    private static boolean remove(char c, int[] targetCount, int[] currentCounts) {
        if ('A' == c) {
            return currentCounts[0]-- == targetCount[0];
        } else if ('C' == c) {
            return currentCounts[1]-- == targetCount[1];
        } else if ('G' == c) {
            return currentCounts[2]-- == targetCount[2];
        } else if ('T' == c) {
            return currentCounts[3]-- == targetCount[3];
        }

        return false;
    }

    private static int checkCount(int[] targetCount, int[] currentCounts) {
        int check = 0;
        if (currentCounts[0] >= targetCount[0]) {
            check++;
        }
        if (currentCounts[1] >= targetCount[1]) {
            check++;
        }
        if (currentCounts[2] >= targetCount[2]) {
            check++;
        }
        if (currentCounts[3] >= targetCount[3]) {
            check++;
        }

        return check;
    }
}