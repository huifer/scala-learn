package com.huifer

import scala.beans.BeanProperty

/**
 * 父类
 */
class parents(val name: String) {
  var i = 100

  val b = 0

  def sayHi(): Unit = {
    println("父类说hi")
  }
}

/**
 * 子类
 */
class children(n: String) extends parents(n) {
  //  override def sayHi(): Unit = {
  //    println("子类说hi")
  //  }
  override def sayHi(): Unit = super.sayHi()

  override val name = "李四"

  override val b = 2
}

// 匿名子类
class children2(n: String) extends parents(n) {
  @BeanProperty var ch = new children("李四") {
    override def sayHi(): Unit = {
      println("匿名子类的hi")
    }

    override val name: String = "李四"
    override val b: Int = 999
  }
}


/**
 * 抽象类
 */
abstract class p {
  var i: Int

  def pw(): Unit
}

class pChi extends p {
  override var i = 123

  override def pw(): Unit = {
    println("hello")
  }
}

object ExtendsClass {
  def main(args: Array[String]): Unit = {
    var ch = new children("张三")
    // 子类可以使用父类的属性
    println(ch.i)
    ch.sayHi()
    println(ch.name)
    println(ch.b)

    var ch2 = new children2("王五")
    val ch1 = ch2.getCh
    ch1.sayHi()

    var pchi = new pChi
    println(pchi.i)
  }
}
