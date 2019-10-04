package com.shiun.no905

class Solution {
    fun sortArrayByParity(A: IntArray): IntArray {
        var evenArray = mutableListOf<Int>()
        var oddArray = mutableListOf<Int>()
        A.forEachIndexed { index, i ->
            if (i%2==0) evenArray.add(i) else oddArray.add(i)
        }

        return evenArray.toIntArray() + oddArray
    }
}

fun main() {
    val array = intArrayOf(3, 1, 2, 4)
    Solution().sortArrayByParity(array)
}