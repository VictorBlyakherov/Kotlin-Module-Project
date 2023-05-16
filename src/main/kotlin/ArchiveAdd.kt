class ArchiveAdd() : ListInterface {
    override val title: String = "Добавление архива"
    override val itemList: MutableList<MenuItem> = mutableListOf()

    init {
        itemList.add(MenuItem("Введите название архива"))
        itemList.add(MenuItem("", isActive = false, isExecute = true) {
            val name = scanner.nextLine()
            this.addArchive(name)
            println("Архив успешно добавлен")
        })
        itemList.add(MenuItem("Вернуться к списку архивов", isActive = true, isExecute = false) {menu.showListMenu(ArchiveList())})
    }

    fun addArchive(name: String) {
        archivesData.add(Archive(archivesData.size, name))
    }
}