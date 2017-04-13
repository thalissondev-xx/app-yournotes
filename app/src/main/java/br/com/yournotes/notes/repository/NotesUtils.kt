package br.com.yournotes.notes.repository

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import br.com.yournotes.notes.activityies.addnote.models.Note
import rx.Observable

/**
 * Created by thalissonestrela on 4/6/17.
 */
class NotesUtils(var helper: NotesDbHelper) {

    fun insert(note: Note): Observable<Boolean> {

        var db: SQLiteDatabase = helper.writableDatabase
        var contentValues: ContentValues = ContentValues()

        var obs: Observable<Boolean> = Observable.create {
            try {
                contentValues.put(NotesContract.NotesEntry().COLUMN_TITLE, note.title)
                contentValues.put(NotesContract.NotesEntry().COLUMN_DESCRIPTION, note.description)

                var rowId: Long = db.insert(
                        NotesContract.NotesEntry().TABLE_NAME, null, contentValues)

                if (!rowId.toString().equals("-1")) {
                    it.onNext(true)
                } else {
                    it.onNext(false)
                }

            } catch(error: Exception) {
                it.onError(error)
            } finally {
                db.close()
            }
        }

        return obs

    }

    fun select(): Observable<Cursor> {

        var db: SQLiteDatabase = helper.readableDatabase

        var obs: Observable<Cursor> = Observable.create {
            try {
                var sortOrder: String = BaseColumns._ID + " DESC"
                var projection = arrayOf(BaseColumns._ID, NotesContract.NotesEntry().COLUMN_TITLE,
                        NotesContract.NotesEntry().COLUMN_DESCRIPTION, NotesContract.NotesEntry().COLUMN_TIMESTAMP)

                var cursor: Cursor = db.query(NotesContract.NotesEntry().TABLE_NAME, projection,
                        null, null, null, null, sortOrder)

                if (cursor != null) {
                    it.onNext(cursor)
                } else {
                    it.onError(NullPointerException())
                }

            } catch (error: Exception) {
                it.onError(error)
            } finally {
                db.close()
            }
        }

        return obs

    }

}