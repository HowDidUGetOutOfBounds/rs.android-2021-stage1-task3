package subtask3

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>?{

        var res: ArrayList<String> = ArrayList()

        for (i in number.indices) {
            try {
                res.addAll(getAllNear(i, number))
            }
            catch (e: Exception)
            {
                return null
            }
        }

        var resArray: Array<String> = Array(res.size) { "empty" }
        for (i in res.indices) {
            resArray[i] = res[i]
        }


        return resArray
    }

    fun getAllNear(indx: Int, input: String): ArrayList<String> {
        val getNearTo = input[indx].toString().toInt()
        val currentArray = numberNeighbors.get(getNearTo)
        var result = ArrayList<String>()

        if (currentArray != null) {
            for (i in 0..currentArray.size-1) {
                var stringToAdd: String = ""
                stringToAdd += input.substring(0, indx)
                stringToAdd += currentArray[i]
                if(indx < input.length) {
                    stringToAdd += input.substring(indx + 1)
                }
                result.add(stringToAdd)
            }
        }

        return result
    }

    var numberNeighbors = mapOf<Int, Array<Int>>(
        0 to arrayOf(8),
        1 to arrayOf(2,4),
        2 to arrayOf(1,3,5),
        3 to arrayOf(2,6),
        4 to arrayOf(1,5,7),
        5 to arrayOf(2,4,6,8),
        6 to arrayOf(3,5,9),
        7 to arrayOf(4,8),
        8 to arrayOf(5,7,9,0),
        9 to arrayOf(6,8)
    )
}
