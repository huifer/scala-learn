package com.huifer

data class Stu(
        var id: Long,
        var name: String
)

fun main(args: Array<String>) {
    var stu = Stu(1L, "SS")
    println(stu)
}