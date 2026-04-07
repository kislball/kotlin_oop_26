import java.util.NoSuchElementException
import org.example.list.SingleLinkedList
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SingleLinkedListTest {

  private lateinit var list: SingleLinkedList

  @BeforeEach
  fun setUp() {
    list = SingleLinkedList()
  }

  @Test
  fun `add elements`() {
    list.add(1)
    list.add(2)
    list.add(3)

    assertEquals(3, list.size)
    for (i in list.withIndex()) {
      assertEquals(i.index + 1, i.value)
    }
  }

  @Test
  fun `addFirst works correctly`() {
    list.add(2)
    list.addFirst(1)

    assertEquals(1, list[0])
    assertEquals(2, list[1])
  }

  @Test
  fun `remove element`() {
    list.add(1)
    list.add(2)
    list.add(3)

    assertTrue(list.remove(2))
    assertEquals(2, list.size)
    assertEquals(1, list[0])
    assertEquals(3, list[1])
  }

  @Test
  fun `remove non-existing element`() {
    list.add(1)
    list.add(2)

    val removed = list.remove(3)
    assertFalse(removed)
    assertEquals(2, list.size)
  }

  @Test
  fun `contains works`() {
    list.add(1)
    list.add(2)

    assertTrue(list.contains(1))
    assertFalse(list.contains(3))
  }

  @Test
  fun `get by index`() {
    list.add(10)
    list.add(20)
    list.add(30)

    assertEquals(10, list[0])
    assertEquals(20, list[1])
    assertEquals(30, list[2])
  }

  @Test
  fun `get throws exception on invalid index`() {
    list.add(10)
    list[0]

    assertThrows(IndexOutOfBoundsException::class.java) { list[5] }
  }

  @Test
  fun `indexOf works`() {
    list.add(10)
    list.add(20)
    list.add(30)

    assertEquals(1, list.indexOf(20))
  }

  @Test
  fun `indexOf throws exception for non-existing element`() {
    list.add(10)
    list.add(20)

    assertThrows(NoSuchElementException::class.java) { list.indexOf(30) }
  }

  @Test
  fun `set works`() {
    list.add(10)
    list.add(20)
    list.add(30)

    list[2] = 5
    assertEquals(5, list[2])
  }

  @Test
  fun `set does nothing on invalid index`() {
    list.add(10)
    list.add(20)

    list[5] = 100
    assertEquals(10, list[0])
    assertEquals(20, list[1])
  }

  @Test
  fun `remove first element`() {
    list.add(1)
    list.add(2)
    list.add(3)

    assertTrue(list.remove(1))
    assertEquals(2, list.size)
    assertEquals(2, list[0])
    assertEquals(3, list[1])
  }

  @Test
  fun `remove last element`() {
    list.add(1)
    list.add(2)
    list.add(3)

    assertTrue(list.remove(3))
    assertEquals(2, list.size)
    assertEquals(1, list[0])
    assertEquals(2, list[1])
  }

  @Test
  fun `size returns correct count`() {
    assertEquals(0, list.size)

    list.add(1)
    assertEquals(1, list.size)

    list.add(2)
    list.add(3)
    assertEquals(3, list.size)
  }

  @Test
  fun `addFirst to empty list`() {
    list.addFirst(42)

    assertEquals(1, list.size)
    assertEquals(42, list[0])
  }

  @Test
  fun `iterator iterates correctly`() {
    list.add(1)
    list.add(2)
    list.add(3)

    val result = mutableListOf<Int>()
    for (item in list) {
      result.add(item)
    }

    assertEquals(3, result.size)
  }
}
