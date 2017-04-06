package br.com.yournotes.notes.activityies.addnote.injection

import br.com.yournotes.notes.activityies.addnote.AddNoteActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Fretebras Android Team on 4/6/17.
 */

@Singleton
@Component(
        modules = arrayOf(AddNoteModule::class)
)
interface AddNoteComponent {
    fun inject(view: AddNoteActivity)
}