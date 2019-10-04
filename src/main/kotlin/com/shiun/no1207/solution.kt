package com.shiun.no1207

class Solution {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        var arrMap = mutableMapOf<Int, Int>()

        for (i in arr) {
            if (!arrMap.contains(i)) {
                var ini = 1
                arrMap.put(i, ini)
            } else {
                var ii = arrMap[i]
                ii = ii?.plus(1)
                arrMap[i] = ii!!
            }
        }

        var result = false

        for (i in arrMap.values) {
            var count = 0
            for (j in arrMap.values) {
                if (i == j) count ++
                if (count == 2) result = false else result = true
                if (!result){
                    return result
                }
            }
        }

        return result
    }
}

class Solution2 {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val map: HashMap<Int,Int> = HashMap()
        val set: HashSet<Int> = HashSet()

        for(num in arr) map[num] = map.getOrDefault(num,0) + 1

        for(count in map.values){
            if(set.contains(count)) return false
            set.add(count)
        }
        return true
    }
}

class Solution3 {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        var freq = HashMap<Int, Int>()

        arr.forEach { freq.put(it, 1 + freq.getOrDefault(it, 0)) }

        return freq.size == HashSet<Int>(freq.values).size
    }
}

fun main() {
    var a = Solution3().uniqueOccurrences(intArrayOf(1, 2, 2, 1, 1, 3))
    var b = Solution3().uniqueOccurrences(intArrayOf(1, 2))
    var c = Solution3().uniqueOccurrences(intArrayOf(-3, 0, 1, -3, 1, 1, 1, -3, 10, 0))
    var d = Solution3().uniqueOccurrences(intArrayOf(4,0,2,-5,-4))

    println(a)
    println(b)
    println(c)
    println(d)
}