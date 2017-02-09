package br.com.yournotes.notes.activityies.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.Menu
import android.view.MenuItem
import br.com.yournotes.R
import br.com.yournotes.notes.activityies.addnote.AddNote

class NotesActivity : AppCompatActivity(), NotesView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
    }

    override fun showAlert(dialog: AlertDialog) {
        dialog.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.add_note ->
                    startActivity(Intent(this, AddNote::class.java))
        }

        return super.onOptionsItemSelected(item)
    }

}
