package com.huifer


import scala.beans.BeanProperty

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

/**
 * 注解Bean
 */
class ScalaBean {
  @BeanProperty var intVal: Int = 0
}

/**
 * 构造器
 *
 * @param xx
 */
class ScalaCu1(xx: Int) {
  var age = xx
}

class ScalaCu2 {
  var age: Int = 0
  var name: String = ""


  def this(x: Int, n: String) {
    this() // 代表的是主构造器.
    this.age = x
    this.name = n
  }

  def this(x: Int) {
    this()
    this.age = x
  }

  def this(n: String) {
    this()
    this.name = n
  }


  override def toString = s"ScalaCu2(age=$age, name=$name)"
}

object TestScalaCu2 {
  def main(args: Array[String]): Unit = {
    var sc2_1 = new ScalaCu2
    println(sc2_1)
    var sc2_2 = new ScalaCu2(1, "张三")
    println(sc2_2)
    var sc2_3 = new ScalaCu2(1)
    println(sc2_3)
    var sc2_4 = new ScalaCu2("张三")
    println(sc2_4)
  }
}


// 继承
class People(n: String) {
  @BeanProperty var name: String = n
}

class Man(n: String, i: Int) extends People(n) {
  @BeanProperty var age = i
}

object TestExtends {
  def main(args: Array[String]): Unit = {
    var man = new Man("张三", 1)
    println(man.getAge)
    println(man.getName)
  }
}

class People2 {
  @BeanProperty var name = "默认值"

  def this(n: String) {
    this()
    this.name = n
  }
}

class WoMan(n: String, i: Int) extends People2 {
  //  super.name = n
  @BeanProperty var age = i

}

object TestExtends2 {
  def main(args: Array[String]): Unit = {
    var woman = new WoMan("张三", 1)
    println(woman.getName)
    println(woman.getAge)
  }
}