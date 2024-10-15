package org.problems.BackJoon.Bronze

fun main(args:Array<String>) {
    val br = System.`in`.bufferedReader()
    val array = mutableListOf<List<String>>()
    var answer:String = ""

    repeat(5){
        val str = br.readLine().trim()
        val splitInput = str.split("")
        array.add(splitInput)
    }

    val maxLength = array.maxOf{ it.size }

    for (i in 0 until maxLength) {
        for (list in array) {
            if(i < list.size)
                answer += list[i]
        }
    }

    println(answer)
}