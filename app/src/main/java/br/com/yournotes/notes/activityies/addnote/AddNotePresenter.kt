package br.com.yournotes.notes.activityies.addnote

import br.com.yournotes.notes.activityies.addnote.models.RegisterNoteResult
import rx.Observer
import javax.inject.Inject

/**
 * Created by thalissonestrela on 2/8/17.
 */
class AddNotePresenter @Inject constructor(
        val view: AddMVP.View, val interactor: AddNoteInteractor): Observer<RegisterNoteResult> {

    fun requestSaveNote() {

    }

    override fun onNext(t: RegisterNoteResult?) {

    }

    override fun onCompleted() {

    }

    override fun onError(e: Throwable?) {

    }

}