package subtask1

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        val posters = array[0]
        val colorVariants = array[1].toLong()
        var res: Int? = null

        for (i in 1..colorVariants)
        {
            if(findMatches(colorVariants, i) == posters)
            {
                res = i.toInt()
                break
            }
        }

        return res
    }

    fun findMatches(n: Long, k: Long):Int
    {
        return (factorial(n)/(factorial(n-k) * factorial(k))).toInt()
    }

    fun factorial(value: Long): Long {
        return if(value == 0L) {
            1
        } else {
            value * factorial(value-1)
        }
    }
}
