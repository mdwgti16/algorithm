package langjava.acmicpc

import java.util.*
import kotlin.math.max

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun nextInt(): Int {
        nextToken(); return nval.toInt()
    }

    val N = nextInt()
    val graph = Array(N + 1) { ArrayList<Int>() }
    val times = IntArray(N + 1)
    val phases = IntArray(N + 1)

    for (i in 1..N) {
        times[i] = nextInt()

        while (true) {
            val edge = nextInt()
            if (edge == -1) break
            graph[edge].add(i)
            phases[i]++
        }
    }

    val q = LinkedList<Int>()
    val result = IntArray(N + 1) { times[it] }
    for (i in 1..N) {
        if (phases[i] == 0) {
            q.add(i)

            while (q.isNotEmpty()) {
                val node = q.poll()

                for (next in graph[node]) {
                    result[next] = max(result[next], result[node] + times[next])
                    if (--phases[next] == 0) {
                        q += next
                    }
                }
            }
        }
    }

    val sb = StringBuilder()
    for (i in 1..N) {
        sb.append((result[i])).append("\n")
    }

    print(sb)
}
