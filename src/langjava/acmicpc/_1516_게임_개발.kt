package langjava.acmicpc

import java.util.*
import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val graph = Array<MutableList<Int>>(N + 1) { mutableListOf() }
    val times = Array<Int>(N + 1) { 0 }
    val phases = Array<Int>(N + 1) { 0 }

    for (i in 1..N) {
        val arr = readLine().split(" ").map { it.toInt() }
        times[i] = arr[0]

        for (j in 1..<arr.size - 1) {
            val edge = arr[j]
            graph[edge].add(i)
            phases[i]++
        }
    }

    val q = LinkedList<Int>()
    for (i in 1..N) {
        if (phases[i] == 0) {
            q.add(i)
        }
    }

    val result = Array<Int>(N + 1) { 0 }
    while (q.isNotEmpty()) {
        val node = q.poll()

        for (next in graph[node]) {
            phases[next]--
            result[next] = max(result[next], result[node] + times[node])
            if (phases[next] == 0) {
                q.add(next)
            }
        }
    }

    val sb = StringBuilder()
    for (i in 1..N) {
        sb.append((result[i] + times[i])).append("\n")
    }

    println(sb)
}
