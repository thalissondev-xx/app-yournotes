package br.com.yournotes.notes.activityies.addnote

import br.com.yournotes.notes.base.BaseInteractor
import br.com.yournotes.notes.base.BaseView

/**
 * Created by thalissonestrela on 3/15/17.
 */
interface AddMVP {

    interface View: BaseView {

        fun saveNote()

    }

    interface Interactor: BaseInteractor {



    }

}