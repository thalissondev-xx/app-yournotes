package br.com.yournotes.notes.activityies.main.injection

import br.com.yournotes.notes.activityies.main.NotesInteractor
import br.com.yournotes.notes.activityies.main.injection.NotesModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by thalissonestrela on 3/15/17.
 */

@Singleton
@Component(
        modules = arrayOf(NotesModule::class)
)
interface NotesComponent {
    fun inject(presenter: NotesInteractor)
}