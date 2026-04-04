package org.example.list

class CustomArrayList(startSize: Int): CustomList {
    var inner = IntArray(startSize)

    // TODO: implement interface CustomList

    override fun add(element: Int) {
        TODO("implement this")
    }

    private fun resize(newSize: Int) {
        TODO("implement this")
        // should return new array list with newSize size
        // and first size elements copied from this
    }

    companion object {
        fun customArrayListOf(vararg items: Int) =
            items.fold(CustomArrayList(items.size)) { list, item ->
                list.also { it.add(item) }
            }
    }
}