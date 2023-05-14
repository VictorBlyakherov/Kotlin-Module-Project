import java.util.*

class Menu {

    fun showDetailMenu(menuPage: DetailInterface) {
        menuPage.prepareData()
        println(menuPage.title)
        println()
        println(menuPage.detailText)
        println()
        println("Для возврата к предыдущему экрану нажмите 0")
        val userChoice = getIntUserResponse(0)
        menuPage.backRef.invoke()
    }


    fun showListMenu(menuPage: ListInterface) {
        menuPage.prepareListItem()
        println("Выберите номер пункта меню:")
        println(menuPage.title)
        var count: Int = 1
        val tempMap: MutableMap<Int, String> = mutableMapOf()
        for (el in menuPage.itemList.entries) {
            println("$count. ${el.key}")
            tempMap.put(count, el.key)
            count++
        }
        val userChoice = getIntUserResponse(count)
        menuPage.itemList[tempMap[userChoice]]?.invoke()
    }

    private fun getIntUserResponse(count: Int): Int {
        while (true) {
            val userResponse = Scanner(System.`in`).nextLine()
            if (isInteger(userResponse) && (userResponse.toInt() in 0..count)) {
                return userResponse.toInt()
            }
            println("Не пойдет. Введите целое число в диапазоне 0..$count")
        }
    }

    private fun getTextUserResponse(): String {
        return Scanner(System.`in`).nextLine()
    }


    private fun isInteger(s: String): Boolean {
        return try {
            s.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }
}