package br.com.yournotes.notes.activityies.addnote.injection

import br.com.yournotes.notes.activityies.addnote.AddMVP
import br.com.yournotes.notes.activityies.addnote.AddNoteActivity
import br.com.yournotes.notes.activityies.addnote.AddNoteInteractor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Fretebras Android Team on 4/6/17.
 */

@Module
class AddNoteModule(var view: AddNoteActivity) {

    @Singleton
    @Provides
    fun provideView(): AddMVP.View {
        return view
    }

    @Singleton
    @Provides
    fun provideInteractor(): AddNoteInteractor {
        return AddNoteInteractor()
    }

}