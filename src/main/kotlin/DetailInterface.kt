interface DetailInterface {
    val title: String
    val detailText: String
    val backRef: () -> Unit
    fun prepareData()
}