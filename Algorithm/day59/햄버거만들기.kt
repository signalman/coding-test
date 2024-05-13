package Algorithm.day59

class 햄버거만들기 {
    fun solution(ingredient: IntArray): Int {
        var answer = 0
        val stack = mutableListOf<Ingredient>()

        ingredient.forEach {
            when (it) {
                1 -> {
                    if (stack.isNotEmpty() && stack.last().type == 3 && stack.last().valid) {
                        repeat(3) { stack.removeAt(stack.size - 1) }
                        answer++
                    } else stack.add(Ingredient(it, true))
                }
                else -> {
                    if (stack.isNotEmpty() && stack.last().type == it - 1 && stack.last().valid) {
                        stack.add(Ingredient(it, true))
                    } else stack.add(Ingredient(it, false))
                }
            }
        }
        return answer
    }
    data class Ingredient(val type: Int, val valid: Boolean)
}