package org.example.stack

import java.util.NoSuchElementException
import org.example.list.CustomArrayList
import org.example.list.CustomList

class ArrayListStack(var inner: CustomArrayList = CustomArrayList(10)) :
    Stack, CustomList by inner {
  override fun push(value: Int) {
    addFirst(value)
  }

  override fun pop(): Int {
    if (size == 0) throw NoSuchElementException()
    return inner.removeAt(0)
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
}
