package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12891_DNA_비밀번호_v2_int {
    static int[] counts = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        char[] chars = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        counts[0] = Integer.parseInt(st.nextToken());
        counts[2] = Integer.parseInt(st.nextToken());
        counts[6] = Integer.parseInt(st.nextToken());
        counts[19] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < p; i++) {
            counts[chars[i] - 'A']--;
        }

        int ans = 0;
        if (check()) ans++;

        for (int i = 0; i + p < s; i++) {
            counts[chars[i] - 'A']++;
            counts[chars[i + p] - 'A']--;
            if (check()) ans++;
        }

        System.out.println(ans);
    }

    public static boolean check() {
        return !(counts[0] > 0 || counts[2] > 0 || counts[6] > 0 || counts[19] > 0);
    }
}