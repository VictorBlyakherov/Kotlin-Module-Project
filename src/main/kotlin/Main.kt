val archivesData: MutableList<Archive> = mutableListOf()
val notesData: MutableList<Note> = mutableListOf()
var currentArchiveId = 1
var currentNoteId = 1
val menu: Menu = Menu()

fun main(args: Array<String>) {
    archivesData.add(Archive(0, "Архив 1"))
    archivesData.add(Archive(1, "Архив 2"))
    notesData.add(Note(0, "Note 1", "Note 1 1 1 1 ",0))
    notesData.add(Note(1, "Note 2", "Note 2 2 2 2 2",1))
    menu.showListMenu(ArchiveList())
}

