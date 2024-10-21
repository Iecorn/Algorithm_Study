package org.problems.BackJoon.Gold

import java.util.*

val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)

lateinit var area : Array<CharArray>
var visited = Array(0) { Array(0) { false } }
var n = 0
var cnt = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()

    area =  Array(n) { readLine().toCharArray() }
    find()
    print("$cnt ")
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (area[i][j] == 'R')
                area[i][j] = 'G'
        }
    }
    find()
    println(cnt)
}

fun find() {
    visited = Array(n) { Array(n) { false } }
    cnt = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!visited[i][j]) {
                bfs(i, j, area[i][j])
                cnt++
            }
        }
    }
}


fun bfs(x: Int, y: Int, color: Char) {
    val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
    queue.add(x to y)
    visited[x][y] = true

    while (queue.isNotEmpty()){
        val now = queue.poll()
        for(i in 0 until 4){
            val tempX = now.first + dx[i]
            val tempY = now.second + dy[i]

            if(tempX in 0 until n
                && tempY in 0 until n
                && !visited[tempX][tempY]
                && area[tempX][tempY] == color){
                visited[tempX][tempY] = true
                queue.add(tempX to tempY)
            }
        }
    }
}

