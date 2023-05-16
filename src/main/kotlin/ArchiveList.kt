import kotlin.system.exitProcess

class ArchiveList(): ListInterface {
    override val title = "Список архивов"
    override val itemList: MutableList<MenuItem> = mutableListOf()
    init {

        itemList.add(MenuItem("Создать архив", isActive = true, isExecute = false) { menu.showListMenu(ArchiveAdd()) })
        for (el in archivesData) {
            itemList.add(MenuItem(el.name, isActive = true, isExecute = false) { menu.showListMenu(NoteList(el.id)) })
        }
        itemList.add(MenuItem("Выход", isActive = true, isExecute = false) { exitProcess(0) })
    }
}