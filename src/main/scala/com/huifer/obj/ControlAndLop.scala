package com.huifer.obj

import java.util

import scala.util.control.Breaks

/**
 * 控制和循环
 */
object ControlAndLop {
  val loop = new Breaks;


  def main(args: Array[String]): Unit = {
    //    control
    //    lop
    //    breakAndContinue
    //    fib
    //    dec()
    exc()
  }

  /**
   * 异常捕捉
   *
   * @return
   */
  def exc() = {
    val i = 1
    try {
      i / 0
    } catch {
      //      case e: ArithmeticException => {
      //        println(e.getMessage)
      //      }
      case ex: Exception => {
        println(ex.getMessage)
      }
    } finally {
      print("finally")
    }
  }

  /**
   * 默认参数
   *
   * @param str
   * @param st
   */
  def dec(str: String = "a", st: String = "b") = {
    println(str + st)
  }

  /**
   * 斐波那契数列运行体
   */
  private def fib = {
    val d = abs(-1)
    println(d)

    // 斐波那契
    for (i <- 1 to 10) {
      val l = fac(i)
      println(l)
    }
  }

  /**
   * 斐波那契
   *
   * @param x
   * @return
   */
  def fac(x: Long): Long = {
    if (x == 1 || x == 2) {
      1
    } else {
      fac(x - 1) + fac(x - 2)
    }
  }

  /**
   * 取数的绝对值
   *
   * @param x 数
   * @return 绝对值
   */
  def abs(x: Double): Double = {
    if (x >= 0) {
      x
    } else {
      -x
    }
  }

  /**
   * scala 没有break和continue处理方案
   */
  private def breakAndContinue = {
    var ls = new util.ArrayList[Int]()
    // break
    loop.breakable(
      for (i <- 1 to 10) {
        if (i == 5) {
          loop.break
        } else {
          println(i)
          ls.add(i)
        }
      }
    )
    print(ls)

    // continue
    var lss = new util.ArrayList[Int]()
    for (i <- 1 to 10) {
      loop.breakable(

        if (i == 5) {
          loop.break()
        } else {
          lss.add(i)
        }
      )
    }

    print(lss)
  }

  /**
   * 循环
   */
  private def lop = {
    var i = 10
    while (i > 0) {
      println(i)
      i -= 1
    }

    for (i <- 1 to 10) {
      print(i)
    }
    println()

    var h = "hello"
    h foreach (s => {
      println(s)
    })
    println()
    for (i <- 0 until (h.length)) {
      println(h(i))
    }
  }

  /**
   * 控制语句if和返回值
   */
  private def control = {
    var i: Int = 0
    if (i < 0) {
      println("is true")
    }
    else if (i == 0) {
      println("other")
    }
    else {
      println("is false")
    }

    // 代码块有返回值
    var ic = {
      var b = 0
      if (b == 0) {
        //        true
        b += 10
      } else {
        //        false
        b -= 10
      }
      b
    }
    println(ic)

    var id = {
      Math.sqrt(10)
    }
    println(id)
  }
}
