package br.com.yournotes.notes.activityies.addnote

import android.content.Context
import br.com.yournotes.notes.activityies.addnote.models.Note
import br.com.yournotes.notes.repository.NotesDbHelper
import br.com.yournotes.notes.repository.NotesUtils
import rx.Observer
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by thalissonestrela on 2/8/17.
 */
class AddNoteInteractor: AddMVP.Interactor {

    var sub: Subscription? = null

    fun saveData(note: Note, context: Context, observer: Observer<Boolean>) {

        sub = NotesUtils(NotesDbHelper(context)).insert(note)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)

    }

    override fun cancelRequest() {
        sub?.unsubscribe()
    }

}