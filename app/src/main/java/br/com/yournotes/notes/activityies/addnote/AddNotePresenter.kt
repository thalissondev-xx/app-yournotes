package br.com.yournotes.notes.activityies.addnote

import android.content.Context
import android.util.Log
import br.com.yournotes.notes.activityies.addnote.models.Note
import br.com.yournotes.notes.activityies.addnote.models.RegisterNoteResult
import br.com.yournotes.notes.activityies.addnote.models.ValidateResult
import rx.Observer
import javax.inject.Inject

/**
 * Created by thalissonestrela on 2/8/17.
 */
class AddNotePresenter @Inject constructor(
        val view: AddMVP.View, val interactor: AddNoteInteractor): Observer<Boolean> {

    fun requestSaveNote(note: Note, context: Context) {
        var validateResult: ValidateResult = validateNote(note)

        // Is valid?
        if (validateResult.status) {
            interactor.saveData(note, context, this)
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

    override fun onNext(t: Boolean?) {
        Log.i("Notes", "rowId: " + t)
    }

    override fun onCompleted() {
        Log.i("Notes", "onCompleted")
    }

    override fun onError(e: Throwable?) {
        Log.i("Notes", "onError: " + e?.message)
    }

}