class NoteList(val archiveId: Int): ListInterface{
        override val title = "Список заметок"
        override val itemList: MutableMap<String, () -> Unit> = mutableMapOf()

        override fun prepareListItem() {
            itemList.put("Создать заметку") {}
            for (el in notesData.filter { el -> el.id == archiveId }) {
                itemList.put(el.name) { menu.showDetailMenu(NoteDetail(el.id)) }
            }
            itemList.put("Назад к списку архивов") { menu.showListMenu(ArchiveList()) }
        }
}