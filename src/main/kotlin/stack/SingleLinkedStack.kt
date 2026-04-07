package org.example.stack

import org.example.list.SingleLinkedList

class SingleLinkedStack : SingleLinkedList(), Stack {
  override fun push(value: Int) {
    super.addFirst(value)
  }

  override fun pop(): Int {
    if (super.size == 0) throw NoSuchElementException()
    val v = super.get(0)

    super.remove(0)

    return v
  }

  override fun peek(): Int {
    if (super.size == 0) throw NoSuchElementException()
    return super.get(0)
  }

  override val isEmpty: Boolean
    get() = super.size == 0
}

