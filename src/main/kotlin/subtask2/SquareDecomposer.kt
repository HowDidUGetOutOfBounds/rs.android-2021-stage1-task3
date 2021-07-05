package subtask2

import java.util.ArrayList




class SquareDecomposer {

    fun decomposeNumber(n: Long): Array<Int>? {
        val decomposeArray = Decomposer(n, n * n) ?: return null

        decomposeArray.removeAt(decomposeArray.size - 1)
        var result = Array<Int>(decomposeArray.size){0}
        for (i in 0..decomposeArray.size - 1) {
            result[i] = decomposeArray[i].toInt()
        }
        return result
    }

    fun Decomposer(n: Long, remain: Long): MutableList<Long>? {
        if (remain == 0L) {
            val r: MutableList<Long> = ArrayList()
            r.add(n)
            return r
        }

        for (i in n - 1 downTo 1) {
            if (remain - i * i >= 0) {
                val r = Decomposer(i, remain - i * i)

                if (r != null) {
                    r.add(n)
                    return r
                }
            }
        }

        return null
    }
}
