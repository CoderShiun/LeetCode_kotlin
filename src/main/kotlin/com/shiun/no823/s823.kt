package com.shiun.no823

class Solution {
    fun flipAndInvertImage(A: Array<IntArray>): Array<IntArray> {
        for (i in A){
            i.reverse()

            var index = 0
            i.forEach {
                when (it){
                    0 -> {
                        i.set(index, 1)
                        index++
                    }

                    1 -> {
                        i.set(index, 0)
                        index++
                    }
                }
                print(i.get(it))
            }
            println()
        }

        return A
    }
}

class Solution2 {
    fun flipAndInvertImage(A: Array<IntArray>): Array<IntArray> {
        var ret = mutableListOf<IntArray>()
        A.forEachIndexed { i, cur ->
            var row = mutableListOf<Int>()
            for (j in cur.size-1 downTo 0) {
                row.add(if (cur[j] == 0)  1  else  0 )
            }
            ret.add(row.toIntArray())
        }
        return ret.toTypedArray()
    }
}

fun main() {
    var arrays = arrayOf(
        intArrayOf(1,1,0),
        intArrayOf(1,0,1),
        intArrayOf(0,0,0)
    )

    val a = Solution().flipAndInvertImage(arrays)
}