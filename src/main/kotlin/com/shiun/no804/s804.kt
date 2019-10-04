package com.shiun.no804

class Solution {
    fun uniqueMorseRepresentations(words: Array<String>): Int {
        val MORSE: Array<String> = arrayOf(
            ".-",
            "-...",
            "-.-.",
            "-..",
            ".",
            "..-.",
            "--.",
            "....",
            "..",
            ".---",
            "-.-",
            ".-..",
            "--",
            "-.",
            "---",
            ".--.",
            "--.-",
            ".-.",
            "...",
            "-",
            "..-",
            "...-",
            ".--",
            "-..-",
            "-.--",
            "--.."
        )
        var result = HashSet<String>()

        for (word in words) {
            var code = String()

            for (char in word.toCharArray()) code += MORSE[char - 'a']

            result.add(code)
        }
        return result.size
    }
}

fun main() {
    val a = Solution().uniqueMorseRepresentations(arrayOf("gin", "zen", "gig", "msg"))
    println(a)
}