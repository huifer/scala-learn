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

class ScalaAttr(@BeanProperty var name: String, @BeanProperty var age: Int, private var is: Boolean) {
  def p: Unit = {
    println(this.is)
  }

}

object TestScalaAttr {
  def main(args: Array[String]): Unit = {
    var attr = new ScalaAttr("张三", 1, false)
    println(attr.getAge)
    println(attr.getName)
    attr.p
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

class ScalaClass2 {

  /**
   * 内部类
   */
  class InClass {
    var i: Int = 10

    def pr = {
      println("内部类")
    }
  }

  /**
   * 通过函数将内部类构造
   *
   * @return
   */
  def inClass: InClass = {
    new InClass
  }

}


object TestScalaClass2 {
  def main(args: Array[String]): Unit = {
    var sc2 = new ScalaClass2
    val clazz = sc2.inClass
    val clazz1 = sc2.inClass
    clazz.pr

    val bool = clazz.equals(clazz1)
    // false
    println(bool)
  }
}

// 伴生对象&伴生类
/**
 * 伴生类
 */
class CompanionClass {

  var cs = CompanionClass.newCompanionClass
  private var num = 0


  def getCount = {
    this.num = cs
    this.num
  }

  def add(i: Int): Unit = {
    num += i
    println("增加后值=" + num)
  }
}

/**
 * 伴生对象
 */
object CompanionClass {
  private var count = 0

  def newCompanionClass = {
    count += 1
    count
  }

  def add(i: Int) {
    this.count += i
  }
}

object TestCompanion {
  def main(args: Array[String]): Unit = {
    var vc = new CompanionClass
    println(vc.getCount)

    vc.add(10)

  }
}


// abs

abstract class ScalaAbs {
  def start()

  def end()
}

class AbsExtend extends ScalaAbs {
  override def start(): Unit = {
    println("start")
  }

  override def end(): Unit = {
    println("end")
  }
}

object TestAbs {
  def main(args: Array[String]): Unit = {
    var a = new AbsExtend
    a.start()
    a.end()
  }
}

// 枚举
class Color extends Enumeration {
  type Color = Value
  val Red = Value("0")
  val Green = Value("1")

  override protected def readResolve(): AnyRef = super.readResolve()

  override def toString(): String = super.toString()

  override def values: ValueSet = super.values
}

// package
package com {
  package huifer {

    object B {
      var i = "B"
      var a = com.huifer.other.A.b

      def main(args: Array[String]): Unit = {
        println(a)
      }
    }

    package other {

      object A {
        var b = B.i

        def main(args: Array[String]): Unit = {
          println(b)
        }
      }

    }

  }

}


// package object

package object People {
  val defaultName = "张三"

  class Lisi {
    var name = defaultName
  }


}

