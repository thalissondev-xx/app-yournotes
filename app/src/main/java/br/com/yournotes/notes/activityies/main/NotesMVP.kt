package br.com.yournotes.notes.activityies.main

import android.support.v7.app.AlertDialog

/**
 * Created by thalissonestrela on 3/15/17.
 */
interface NotesMVP {

    interface View {
        fun showAlert(dialog: AlertDialog)
    }

    interface Interactor {
        fun request()
    }

}