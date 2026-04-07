package org.example.list

import kotlin.IntArray

open class CustomArrayList(initialCapacity: Int) : CustomList {
  var inner = IntArray(initialCapacity)

  private fun resize(newSize: Int) {
    if (newSize <= capacity) return
    val oldInner = inner
    val oldSize = size
    inner = IntArray(newSize)

    for (i in 0 until oldSize) {
      inner[i] = oldInner[i]
    }
  }

  private fun ensureCapacity(minSize: Int) {
    while (capacity < minSize) {
      resize(capacity / 2 * 3 + 1)
    }
  }

  companion object {
    fun customArrayListOf(vararg items: Int) =
        items.fold(CustomArrayList(items.size)) { list, item -> list.also { it.add(item) } }
  }

  override fun get(index: Int): Int {
    if (index < 0 || index >= size) throw IndexOutOfBoundsException()
    return inner[index]
  }

  override fun set(index: Int, value: Int) {
    if (index < 0 || index >= size) return
    inner[index] = value
  }

  override fun add(element: Int) {
    ensureCapacity(size + 1)
    inner[size] = element
    size += 1
  }

  override fun addFirst(element: Int) {
    ensureCapacity(size + 1)
    for (i in (size - 1) downTo 0) {
      inner[i + 1] = inner[i]
    }
    inner[0] = element
    size += 1
  }

  override fun remove(element: Int): Boolean {
    val idx =
        try {
          indexOf(element)
        } catch (e: NoSuchElementException) {
          return false
        }

    for (i in idx until size - 1) {
      inner[i] = inner[i + 1]
    }

    size -= 1
    return true
  }

  override fun indexOf(element: Int): Int {
    for (i in 0 until size) {
      if (inner[i] == element) {
        return i
      }
    }
    throw NoSuchElementException()
  }

  override var size: Int = 0
    protected set

  val capacity: Int
    get() = inner.size

  override fun iterator(): Iterator<Int> {
    return inner.asSequence().take(size).iterator()
  }
}
