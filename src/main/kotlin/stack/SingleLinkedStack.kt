package org.example.stack

import org.example.list.SingleLinkedList
import java.util.NoSuchElementException

class SingleLinkedStack : SingleLinkedList(), Stack {
  override fun push(value: Int) {
    super.addFirst(value)
  }

  override fun pop(): Int {
    if (begin == null) throw NoSuchElementException()
    return removeAt(0)
  }

  override fun peek(): Int {
    if (super.size == 0) throw NoSuchElementException()
    return super.get(0)
  }

  override val isEmpty: Boolean
    get() = super.size == 0
}

