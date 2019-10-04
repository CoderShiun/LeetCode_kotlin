package com.shiun.no938

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
}


class Solution {
    fun rangeSumBST(root: TreeNode?, L: Int, R: Int): Int {
        return rangeSumBstHelper(root, L, R, 0)
    }

    fun rangeSumBstHelper(root: TreeNode?, L: Int, R: Int, s: Int): Int {
        var sum = s

        if (root != null) {
            when (root != null) {
                root.`val` in L..R -> {
                    sum += root.`val`
                    sum = rangeSumBstHelper(root.left, L, R, sum)
                    sum = rangeSumBstHelper(root.right, L, R, sum)
                }

                root.`val` < L -> sum = rangeSumBstHelper(root.right, L, R, sum)

                else -> sum = rangeSumBstHelper(root.left, L, R, sum)
            }
        }


        if (root != null) {
            if (root.`val` in L..R) {
                sum += root.`val`
                sum = rangeSumBstHelper(root.left, L, R, sum)
                sum = rangeSumBstHelper(root.right, L, R, sum)
            } else if (root.`val` < L) {
                sum = rangeSumBstHelper(root.right, L, R, sum)
            } else {
                sum = rangeSumBstHelper(root.left, L, R, sum)
            }
        }
        return sum
    }

    fun rangeSumBST2(root: TreeNode?, L: Int, R: Int): Int {
        var result = 0
        if (root == null) return result
        with(root) {
            if (`val` in L..R) result += `val`
            if (`val` < R) right?.let { result += rangeSumBST(it, L, R) }
            if (`val` > L) left?.let { result += rangeSumBST(it, L, R) }
        }
        return result
    }

    fun rangeSumBST3 (root: TreeNode?, L: Int, R: Int): Int {
        var result = 0
        if (root == null) return result
        root?.run {
            if (`val` in L..R) result += `val`
            if (`val` < R) right.let { result += rangeSumBST(it, L, R) }
            if (`val` > L) left.let { result += rangeSumBST(it, L, R) }
        }
        return result
    }
}

