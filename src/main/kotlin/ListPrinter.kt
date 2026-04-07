package org.example

import org.example.list.CustomList

object ListPrinter {
  fun printList(list: CustomList) {
    for (i in list) {
      print(i)
    }
  }
}

