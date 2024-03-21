// JVM_ABI_K1_K2_DIFF: KT-65038
// WITH_STDLIB
class World() {
  public val items: ArrayList<Item> = ArrayList<Item>()

  inner class Item() {
    init {
      items.add(this)
    }
  }

  val foo = Item()
}

fun box() : String {
  val w = World()
  if (w.items.size != 1) return "fail"
  return "OK"
}
