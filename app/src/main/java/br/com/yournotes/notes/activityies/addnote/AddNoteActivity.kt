package br.com.yournotes.notes.activityies.addnote

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import br.com.yournotes.R

/**
 * Created by thalissonestrela on 2/8/17.
 */
class AddNoteActivity : AppCompatActivity(), AddMVP.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addnote)

        // Show the button back for the previous activity
        // actionBar.setDisplayHomeAsUpEnabled(true)
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun saveNote() {

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_addnote, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.check_note ->
                startActivity(Intent(this, AddNoteActivity::class.java))
        }

        return super.onOptionsItemSelected(item)
    }

}