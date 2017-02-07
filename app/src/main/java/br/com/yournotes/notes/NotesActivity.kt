package br.com.yournotes.notes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.yournotes.R
import kotlinx.android.synthetic.main.activity_notes.*

class NotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
    }
}
