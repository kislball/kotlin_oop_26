package org.example.stack

import org.example.list.CustomArrayList

class ArrayListStack(var inner: CustomArrayList = CustomArrayList(10)) : Stack {
  override fun push(value: Int) {
    addFirst(value)
  }

  override fun pop(): Int {
    val v = peek()
    remove(0)

    return v
  }

  override fun peek(): Int {
    try {
      return get(0)
    } catch (e: IndexOutOfBoundsException) {
      throw NoSuchElementException()
    }
  }

  override val isEmpty: Boolean
    get() = size == 0

  override fun get(index: Int): Int = inner.get(index)

  override fun set(index: Int, value: Int) = inner.set(index, value)

  override fun add(element: Int) = inner.add(element)

  override fun addFirst(element: Int) = inner.addFirst(element)

  override fun remove(element: Int): Boolean = inner.remove(element)

  override fun indexOf(element: Int): Int = inner.indexOf(element)

  override val size: Int
    get() = inner.size

  override fun iterator(): Iterator<Int> = inner.iterator()
}

