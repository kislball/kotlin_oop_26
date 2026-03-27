package org.example

import org.example.SingleLinkedList.Companion.singleLinkedListOf

fun main() {
    val t = singleLinkedListOf(1, 2, 3)
    t[2] = 5
    print(t[2])
}