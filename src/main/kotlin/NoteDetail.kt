class NoteDetail(val noteId: Int): DetailInterface {
    override var title: String = ""
    override var detailText: String = ""
    override var backRef: () -> Unit = {}

    override fun prepareData() {
        val tempNote: Note = notesData.filter { el -> el.id == noteId }[0]
        title = "Просмотр заметки ${tempNote.name}"
        detailText = tempNote.text
        backRef = {menu.showListMenu(NoteList(tempNote.archiveId))}
    }

}