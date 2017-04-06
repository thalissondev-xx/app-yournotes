package br.com.yournotes.notes.activityies.addnote.utils

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import br.com.yournotes.notes.activityies.addnote.models.Note
import br.com.yournotes.notes.activityies.addnote.models.RegisterNoteResult
import br.com.yournotes.notes.repository.NotesContract
import br.com.yournotes.notes.repository.NotesDbHelper
import rx.Observable

/**
 * Created by Fretebras Android Team on 4/6/17.
 */
class InsertNote(var helper: NotesDbHelper) {

    fun insert(note: Note) : Observable<RegisterNoteResult> {

        return Observable.create {

            try {
                var result: RegisterNoteResult = RegisterNoteResult(false)
                var db: SQLiteDatabase = helper.writableDatabase

                var contentValues: ContentValues = ContentValues()
                contentValues.put(NotesContract.NotesEntry().COLUMN_TITLE, note.title)
                contentValues.put(NotesContract.NotesEntry().COLUMN_DESCRIPTION, note.description)

                var rowId: Long = db.insert(NotesContract.NotesEntry().TABLE_NAME,
                        null, contentValues)

                Log.i("Notes", "rowId: " + rowId)

                db.close()

                if (!rowId.toString().equals("-1")) {
                    result.status = true
                    it.onNext(result)
                } else {
                    result.status = false
                    it.onNext(result)
                }

            } catch(error: Exception) {
                it.onError(error)
            }

        }

    }

}