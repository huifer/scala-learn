package com.huifer.obj

/**
 * 键值对
 */
object KvDemo {
  def main(args: Array[String]): Unit = {

    //    val map = Map("a" -> 1, "b" -> "123")
    //    var newMap: Map[String, Int] = Map("a" -> 1, "b" -> 2)

    var newMap: scala.collection.mutable.Map[String, Int] = scala.collection.mutable.Map("a" -> 1, "b" -> 2)


    // 获取key的值
    val i = newMap("a")
    // 获取所有key
    val keys = newMap.keys
    println(keys)
    val set = newMap.keySet
    println(set)
    // 获取所有value
    val values = newMap.values
    println(values)
    // 追加key
    newMap += ("c" -> 3)
    println(newMap)
    // 修改key的值
    newMap("a") = 123
    println(newMap)
    // 删除一个key
    newMap -= "a"
    println(newMap)

    // 遍历
    newMap.keys.foreach(
      k => {
        println("key=" + k + "    value=" + newMap(k))
      }
    )
    println("=======")
    for ((k, v) <- newMap) {
      println("k=" + k + "\tvalue=" + v)
    }


  }
}
