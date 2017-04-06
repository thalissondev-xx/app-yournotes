package br.com.yournotes.notes.activityies.addnote

import android.content.Context
import br.com.yournotes.notes.activityies.addnote.models.Note
import br.com.yournotes.notes.activityies.addnote.models.RegisterNoteResult
import br.com.yournotes.notes.activityies.addnote.utils.InsertNote
import br.com.yournotes.notes.repository.NotesDbHelper
import rx.Observer

/**
 * Created by thalissonestrela on 2/8/17.
 */
class AddNoteInteractor: AddMVP.Interactor {

    fun saveData(note: Note, context: Context, observer: Observer<RegisterNoteResult>) {

        InsertNote(NotesDbHelper(context)).insert(note)
                .subscribe(observer)

    }

    override fun cancelRequest() {

    }

}