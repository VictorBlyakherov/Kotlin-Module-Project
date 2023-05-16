class Menu {

    fun showListMenu(menuPage: ListInterface) {
        println(menuPage.title)
        var count: Int = 0
        val tempMap: MutableMap<Int, () -> Unit> = mutableMapOf()
        val tempChoiceList: MutableList<String> = mutableListOf()
        for (el in menuPage.itemList) {
            if (el.isActive) {
                println("${count}. ${el.text}")
                tempMap.put(count, el.action)
                tempChoiceList.add(count, el.text)
                count++
            } else {
                println(el.text)
            }
            if (el.isExecute) {
                el.action.invoke()
            }
        }
        val userChoice = getIntUserResponse(count - 1, tempChoiceList)
        tempMap[userChoice]?.invoke()
    }

    private fun getIntUserResponse(count: Int, choiceList: List<String>): Int {
        while (true) {
            val userResponse = scanner.nextLine()
            if (isInteger(userResponse) && (userResponse.toInt() in 0..count)) {
                return userResponse.toInt()
            } else {
                println("Не пойдет. Введите целое число в диапазоне 0..$count")
                for ((countElement, el) in choiceList.withIndex()) {
                    println("${countElement}. $el")
                }
            }
        }
    }

    private fun isInteger(s: String): Boolean = s.toIntOrNull() != null
}