package com.huifer.obj

import scala.collection.mutable

object func {
  def main(args: Array[String]): Unit = {
    var addOne = (x: Double) => {
      x + 1
    }
    val d = addOne(1)
    println(d)

    val d1 = add(1)
    println(d1)

    val stringToDouble = fu4(2)("955asf")
    val unit = fu5(2, "2")

    println(stringToDouble)
    println(unit)

    var list = Array("w", "c")
    var list2 = Array("W", "C")
    list.corresponds(list2)(_.equalsIgnoreCase(_))

    println("=========")
    val i = sum(10)
    println(i)

    println("=========")
    val a1 = addOneC(1)
    val i2 = a1(2)
    println("=========")
    delayed(time())
    println("=========")


    // 函数传递
    def m1(f: (Int, Int) => Int)(x: Int, y: Int): Int = {
      f(x, y)
    }

    var f1 = (x: Int, y: Int) => x + y
    var f2 = (x: Int, y: Int) => x - y

    var res1 = m1(f1)(1, 2)
    var res2 = m1(f2)(0, 3)
    println(res1)
    println(res2)
    print()

  }

  def add(x: Double): Double = {
    x.+(1)
  }

  // 这句无法推导数据类型,通配符_没有明确具体数据类型
  //  val fu1 = 1 + _
  // 这句可以推导数据类型,通配符通过(变量名:数据类型)确认了类型
  val fu2 = 1 + (_: Double)
  // 这句可以推导数据类型,通过(参数类型)=>返回值类型,确认了类型
  val fu3: (Double) => Double = 1 + _


  def fu4(x: Double) = (s: String) => {
    var hash = new mutable.HashMap[String, Double]()
    hash.put(s, x)
    hash
  }


  def fu5(x: Double, s: String) = {
    var hash = new mutable.HashMap[String, Double]()
    hash.put(s, x)
    hash
  }


  def sum(x: Int) = {
    // 内部方法
    def inSum(x: Int) = {
      val i = x + x
      println("内部方法结果=" + i)
      i
    }

    inSum(x)
  }

  // 柯里化
  // 原始函数
  def addC(x: Int, y: Int) = x + y

  // 柯里化后函数
  def addOneC(x: Int) = (y: Int) => x + y

  // 将函数作为参数传递
  def time(): Long = {
    System.currentTimeMillis()
  }

  def delayed(t: => Long): Long = {
    println("delayed参数:" + t)
    t
  }


}