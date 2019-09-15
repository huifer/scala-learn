package com.huifer

import java.beans.BeanProperty

/**
 * Scala 的类不需要public
 */
class ScalaClass {


  // 必须初始化,否则需要进行参数传递的形式进行
  var intVal: Int = 0

  // 方法默认公开public
  def add(): Unit = {
    intVal += 1
  }

  def add(aNum: Int) {
    intVal += aNum
    pri
  }

  // 获取
  def getIntVal() = intVal

  // 私有方法
  private def pri: Unit = {
    println(intVal)
  }

}


object TestScalaClass {
  def main(args: Array[String]): Unit = {
    // 使用类
    val scalaClass = new ScalaClass
    // 输出intValue
    println(scalaClass.intVal)
    // 执行加法操作 , 没有参数可以不写`()`
    scalaClass.add
    scalaClass.add(10)
    // 通过get方法获取
    println(scalaClass.getIntVal())
  }
}


class ScalaObj {
  var ints: Int = 0

  def getInts = ints

  def setInts(vInt: Int) {
    ints = vInt

  }

}

object TestScalaObj {
  def main(args: Array[String]): Unit = {
    val s = new ScalaObj
  }
}


class ScalaBean{
  @BeanProperty var intVal :Int = 0

}
