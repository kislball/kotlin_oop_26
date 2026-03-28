package org.example

import java.util.NoSuchElementException

class SingleLinkedList : CustomList {
    class Node {
        var value: Int = 0
        var next: Node? = null
    }

    var begin: Node? = null

    override val size: Int
    get() {
        var cur = begin
        var i = 0

        while (cur != null) {
            cur = cur.next
            i++
        }

        return i
    }

    override fun add(element: Int) {
        if (begin == null) {
            begin = Node().also { it.value = element }
        } else {
            var cur = begin
            while (cur?.next != null) {
                cur = cur.next
            }
            cur?.next = Node().also { it.value = element }
        }
    }

    private fun getNode(index: Int): Node? {
        if (index < 0 || begin == null) return null
        var cur = begin
        for (i in 0 until index) {
            cur = cur?.next ?: return null
        }
        return cur
    }

    override operator fun set(index: Int, value: Int) {
        getNode(index)?.value = value
    }

    override fun addFirst(element: Int) {
        val oldBegin = begin
        begin = Node().also {
            it.value = element
            it.next = oldBegin
        }
    }

    override operator fun get(index: Int): Int {
        return getNode(index)?.value ?: throw IndexOutOfBoundsException()
    }

    override fun indexOf(element: Int): Int {
        var i = 0
        for (v in this.iterator()) {
            if (v == element) return i
            i++
        }
        throw NoSuchElementException()
    }

    override fun remove(element: Int): Boolean {
        try {
            val idx = indexOf(element)

            if (idx == 0) {
                begin = begin?.next
            } else {
                var node = getNode(idx) ?: throw IndexOutOfBoundsException()
                var previous = getNode(idx - 1) ?: throw IndexOutOfBoundsException()

                previous.next = node.next
            }

            return true
        } catch (e: NoSuchElementException) {
            return false
        }
    }

    override fun iterator(): Iterator<Int> {
        return object : Iterator<Int> {
            var cur = begin

            override fun hasNext(): Boolean {
                return cur?.next != null
            }

            override fun next(): Int {
                val value = cur?.value ?: throw NoSuchElementException()
                cur = cur?.next

                return value
            }
        }
    }

    companion object {
        fun singleLinkedListOf(vararg items: Int) =
        items.fold(SingleLinkedList()) { list, item ->
            list.also{ it.add(item) }
        }
    }
}
