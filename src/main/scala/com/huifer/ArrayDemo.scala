package com.huifer

import java.util

import scala.collection.mutable.ArrayBuffer

/**
 * 数组
 */
object ArrayDemo {
  def main(args: Array[String]): Unit = {
    //    arrayInt
    //    listBuffer

    val nums = ArrayBuffer[Int]()
    for (i <- 1 to 10) {
      nums += i
    }

    for (e <- nums) {
      if(e%2==0)  {
        nums -=e
      }
    }
    print()

  }

  private def listBuffer = {
    val nums = ArrayBuffer[Int]()
    for (i <- 1 to 10) {
      nums += i
    }
    println()

    // 普通的for
    for (i<-1 to nums.size){
      print(nums(i))
    }

    // foreach
    nums foreach (i => {
      print(i)
    })
    // 直接遍历元素
    for (e <- nums) {
      print(e)
    }

    // 通过`for()yield` 可以构造一个与原类型相同的数组
    val ints: ArrayBuffer[Int] = for (el <- nums) yield 2 * el
    var ins: ArrayBuffer[Int] = for (el <- nums if el % 2 == 0) yield 2 * el
    // 求和
    val sum = ins.sum

    print()
  }

  private def arrayInt = {
    // 初始化数组长度10,类型int
    val nums = new Array[Int](10)
    // 通过()来获取元素
    val i = nums(9)
    println(i)
  }
}
