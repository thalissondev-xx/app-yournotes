package br.com.yournotes.notes.activityies.addnote

import br.com.yournotes.notes.activityies.addnote.models.Note
import br.com.yournotes.notes.activityies.addnote.models.RegisterNoteResult
import br.com.yournotes.notes.activityies.addnote.models.ValidateResult
import rx.Observer
import javax.inject.Inject

/**
 * Created by thalissonestrela on 2/8/17.
 */
class AddNotePresenter @Inject constructor(
        val view: AddMVP.View, val interactor: AddNoteInteractor): Observer<RegisterNoteResult> {

    fun requestSaveNote(note: Note) {
        var validateResult: ValidateResult = validateNote(note)

        // Is valid?
        if (validateResult.status) {
            interactor.saveData(note)
        } else {
            view.showError(validateResult.msg)
        }
    }

    fun validateNote(note: Note): ValidateResult {

        // Verify if the some value is empty
        if (note.title.trim().equals("")) {
            return ValidateResult(false, "Your title is empty")
        } else if (note.description.trim().equals("")) {
            return ValidateResult(false, "Your description is empty")
        }

        return ValidateResult(true, "It's ok")
    }

    override fun onNext(t: RegisterNoteResult?) {

    }

    override fun onCompleted() {

    }

    override fun onError(e: Throwable?) {

    }

}