package com.shiun.no771

class Solution1 {
    fun numJewelsInStones(J: String, S: String): Int {

        var num: Int = 0

        for (s in S) {
            var match = if (s.toString().toRegex().find(J) != null) num++ else continue
        }

        println(num)

        return num
    }
}

class Solution2 {
    fun numJewelsInStones(J: String, S: String): Int {
        var count = 0
        J.forEach {
            var j = it
            S.forEach {
                when (j == it) {
                    true -> count++
                }
            }
        }
        return count
    }
}

class Solution3 {
    fun numJewelsInStones(J: String, S: String): Int {
        var count = 0
        J.forEach {
            var j = it
            S.forEach {
                if (j == it) count++
            }
        }
        return count
    }
}

fun main() {
    Solution1().numJewelsInStones("aA", "abAbbbbbb")
    println(
        Solution2().numJewelsInStones("aA", "abAbbbbbb")
    )
}