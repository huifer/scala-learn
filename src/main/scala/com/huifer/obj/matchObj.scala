package com.huifer.obj

object matchObj {

  def main(args: Array[String]): Unit = {
    var s = "张三"
    s match {
      case "张三" => println("张三")
      case "李四" => println("李四")
    }

    var num: Int = 0
    num =
      s match {
        case "张三" => 1
        case "李四" => 2
      }
    println(num)

    var o = 1

    var b = o match {
      case x: Int => x
      case x: Double => Int.MaxValue
      case _ => 0
    }
    println(b)

  }

}
