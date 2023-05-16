class NoteAdd(archiveId: Int): ListInterface {
    override val title: String = "Добавление заметки"
    override val itemList: MutableList<MenuItem> = mutableListOf()

    init {
        itemList.add(MenuItem("Введите название Заметки"))
        itemList.add(MenuItem("", isActive = false, isExecute = true) {
            val name = scanner.nextLine()
            println("Введите текст заметки")
            val text = scanner.nextLine()
            this.addNote(name, text, archiveId)
            println("Заметка успешно добавлена")

        })

        itemList.add(MenuItem("Вернуться к списку заметок", isActive = true, isExecute = false) {menu.showListMenu(NoteList(archiveId))})
    }

    fun addNote(name: String, text: String, archiveId: Int) {
        notesData.add(Note(notesData.size, name, text, archiveId))
    }


}