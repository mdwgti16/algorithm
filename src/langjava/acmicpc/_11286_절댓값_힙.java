package langjava.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _11286_절댓값_힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                } else {
                    return Math.abs(o1) - Math.abs(o2);
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int k = Integer.parseInt(br.readLine());

            if (k == 0) {
                if (priorityQueue.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(priorityQueue.remove()).append("\n");
                }
            } else {
                priorityQueue.add(k);
            }
        }

        System.out.println(sb);
    }
}