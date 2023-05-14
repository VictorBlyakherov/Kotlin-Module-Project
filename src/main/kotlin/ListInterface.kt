interface ListInterface {
    val title: String
    val itemList: MutableMap<String, () -> Unit>

    fun prepareListItem()

}