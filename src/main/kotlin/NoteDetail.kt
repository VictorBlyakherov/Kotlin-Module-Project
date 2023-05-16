class NoteDetail(val noteId: Int): ListInterface {
    override var title: String = ""
    override val itemList: MutableList <MenuItem> = mutableListOf()

    init {
        val tempNote: Note = notesData.filter { el -> el.id == noteId }[0]
        title = "Просмотр заметки ${tempNote.name}"
        itemList.add(MenuItem(tempNote.text, isActive = false, isExecute = false) { })

        itemList.add(MenuItem("Назад к списку заметок", isActive = true, isExecute = false) { menu.showListMenu(NoteList(tempNote.archiveId)) })
    }
}