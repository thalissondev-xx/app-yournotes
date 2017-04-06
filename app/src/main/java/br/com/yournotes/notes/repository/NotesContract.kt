package br.com.yournotes.notes.repository

/**
 * Created by thalissonestrela on 4/6/17.
 */
class NotesContract {

    class NotesEntry {

        val TABLE_NAME: String = "notes"
        val COLUMN_TITLE: String = "title"
        val COLUMN_DESCRIPTION: String = "description"
        val COLUMN_TIMESTAMP: String = "timestamp"

    }

}