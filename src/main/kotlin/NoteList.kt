class NoteList(private val archiveId: Int): ListInterface{

    override val title = "Список заметок"
    override val itemList: MutableList<MenuItem> = mutableListOf()
    init {

        itemList.add(MenuItem("Создать заметку", isActive = true, isExecute = false) { menu.showListMenu(NoteAdd(archiveId)) })
        for (el in notesData.filter { el -> el.archiveId == archiveId }) {
            itemList.add(MenuItem(el.name, isActive = true, isExecute = false) { menu.showListMenu(NoteDetail(el.id)) })
        }
        itemList.add(MenuItem("Назад к списку архивов", isActive = true, isExecute = false) { menu.showListMenu(ArchiveList()) })
    }
}