package com.huifer

/**
 * 变量
 */
object Variate {
  def main(args: Array[String]): Unit = {
    //    var a = 1;
    var a: Int = 1
    a = 1 + 1
    var b = 1.1 + 1.2
    var c = "hello" + b
    val d = "hello-world"
    println(a)
    println(b)
    println(c)
    var e: Int = 2.3.toInt
    println(e)
    val i = e.+(1)
    println(i)
    println(i.<<(1))
    println(d.apply(10))
  }

}
