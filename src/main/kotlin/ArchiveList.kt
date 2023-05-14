import kotlin.system.exitProcess

class ArchiveList(): ListInterface {
    override val title = "Список архивов"
    override val itemList: MutableMap<String, () -> Unit> = mutableMapOf()

    override fun prepareListItem() {
        itemList.put("Создать архив") {}
        for (el in archivesData) {
            itemList.put(el.name) { menu.showListMenu(NoteList(el.id)) }

        }
        itemList.put("Выход") { exitProcess(0) }
    }
}