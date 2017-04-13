package br.com.yournotes.notes.activityies.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import br.com.yournotes.notes.activityies.addnote.models.Note

/**
 * Created by thalissonestrela on 4/13/17.
 */
class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(note: Note, listener: (Note) -> Unit) = with(itemView) {
        setOnClickListener { listener(note) }
    }
}