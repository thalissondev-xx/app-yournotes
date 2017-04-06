package br.com.yournotes.notes.activityies.addnote

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import br.com.yournotes.R
import br.com.yournotes.notes.activityies.addnote.injection.AddNoteModule
import br.com.yournotes.notes.activityies.addnote.injection.DaggerAddNoteComponent
import br.com.yournotes.notes.activityies.addnote.models.Note
import kotlinx.android.synthetic.main.activity_addnote.*
import javax.inject.Inject

/**
 * Created by thalissonestrela on 2/8/17.
 */
class AddNoteActivity : AppCompatActivity(), AddMVP.View {

    @Inject lateinit var presenter: AddNotePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addnote)

        // Inject
        DaggerAddNoteComponent
                .builder()
                .addNoteModule(AddNoteModule(this))
                .build()
                .inject(this)

        // Show the button back for the previous activity
        // actionBar.setDisplayHomeAsUpEnabled(true)
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showError(msg: String) {
        Snackbar.make(svAddNote, msg, Snackbar.LENGTH_LONG).setAction("OK", null).show()
    }

    override fun saveNote() {
        presenter.requestSaveNote(Note(
                etTitle.text.toString(), etDescription.text.toString()
        ))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_addnote, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.check_note ->
                saveNote()
        }

        return super.onOptionsItemSelected(item)
    }

}