package br.com.yournotes.notes.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

/**
 * Created by thalissonestrela Team on 4/6/17.
 */
class NotesDbHelper(context: Context): SQLiteOpenHelper(context, "Notes.db", null, 1) {

    val TEXT_TYPE: String = " TEXT"
    val COMMA_SEP: String = ","

    // Create the table
    val SQL_CREATE_ENTRIES: String = "CREATE TABLE " + NotesContract.NotesEntry().TABLE_NAME +
                    " (" + BaseColumns._ID + " INTEGER PRIMARY KEY," +
                    NotesContract.NotesEntry().COLUMN_TITLE + TEXT_TYPE + COMMA_SEP +
                    NotesContract.NotesEntry().COLUMN_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
                    NotesContract.NotesEntry().COLUMN_TIMESTAMP + TEXT_TYPE + COMMA_SEP + ")"

    // Delete the table
    val SQL_DELETE_ENTRIES: String = "DROP TABLE IF EXISTS " + NotesContract.NotesEntry().TABLE_NAME

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        super.onDowngrade(db, oldVersion, newVersion)
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL(SQL_DELETE_ENTRIES)
        onCreate(p0)
    }

}