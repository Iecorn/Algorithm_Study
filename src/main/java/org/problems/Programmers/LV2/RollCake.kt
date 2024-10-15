package org.problems.Programmers.LV2

class Solution {
    fun solution(topping: IntArray): Int {
        var answer: Int = 0
        var arr1 = IntArray(topping.size){0} //형의 종류의 수를 저장할 배열
        var arr2 = IntArray(topping.size){0} //동생의 종류의 수를 저장할 배열
        var menuCount = mutableSetOf<Int>()

        for(i in 0 ..topping.size-1){ // 형이 (i+1)개를 먹었을때의 종류의 수
            menuCount.add(topping[i])
            arr1[i] = menuCount.size
        }

        menuCount.clear()

        for(i in topping.size-1 downTo 0){ // 형이 (i+1)개를 먹었을때의 동생의 종류의 수
            menuCount.add(topping[i])
            arr2[i] = menuCount.size
        }

        for(i in 0 until topping.size-1){ // 형이 (i+1)개를 먹었을 때 형과 동생의 종류의 수 비교
            if(arr1[i] == arr2[i+1]) answer++
        }

        return answer
    }

}

fun main() {
    val s:Solution = Solution()
    var array:IntArray = intArrayOf(1, 2, 1, 3, 1, 4, 1, 2)
    println(s.solution(array))
}
