package com.huifer.obj

trait log {
  def log(msg: String)
}

@SerialVersionUID(123L)
class ConsoleLogger extends log with Serializable {
  override def log(msg: String): Unit = {
    println("控制台输出" + msg)
  }
}


trait ConsoleLogger2 {
  def log(msg: String): Unit = {
    println("控制台输出2" + msg)
  }
}


class Cos extends ConsoleLogger2 {

}

class Cos2 extends ConsoleLogger2 {
  def hc(): Unit = {
    log("执行hc")
    println("操作hc")
  }
}


trait t1 {
  def isDouble(i: Int): Boolean = {
    i % 2 == 0
  }
}

class t1Class extends t1 {
  override def isDouble(i: Int): Boolean = {
    val bool = super.isDouble(i)
    if (bool) {
      if (i > 50) {
        true
      } else {
        false
      }
    } else {
      false
    }
  }
}


trait t2 {
  println("这是T2")

  def log: Unit = {
    println(1)
  }
}

trait t4 extends t3 {
  println("这是T4")

  override def log: Unit = {
    println(3)
  }
}

trait t3 extends t2 {
  println("这是T3")

  override def log: Unit = {
    println(2)
  }
}


class t4Tt extends t2 with t3 with t4 {
  override def log: Unit = super.log
}


class t4T extends t4 {
  override def log: Unit = super.log
}


trait traitFiled {
  var i = 10
  val j = 20
  // 抽象字段
  val k: Int
}

class tf extends traitFiled {

  override val k = 10

  def pr: Unit = {
    println(i + j + k)
  }
}


abstract class abs {
  println("超类")
}

trait c1 {
  println("c1")
}

trait c2 extends c1 {
  println("c2")
}

trait c3 extends c2 {
  println("c3")
}

trait c4 extends c1 {
  println("c4")
}


class demo extends abs with c4 with c3 with c2 with c1 {

}

object TraitClass {
  def main(args: Array[String]): Unit = {
    var log = new ConsoleLogger
    log.log("hello")

    var log2 = new Cos
    log2.log("test")

    var log3 = new Cos2
    log3.hc()

    val clazz = new t1Class
    println(clazz.isDouble(1))
    println(clazz.isDouble(52))


    var t = new t4T
    t.log
    println("=============")
    var tt = new t4Tt
    tt.log
    println("=============")

    var tf = new tf
    tf.pr
    println("=============")
    val demo = new demo

  }
}
