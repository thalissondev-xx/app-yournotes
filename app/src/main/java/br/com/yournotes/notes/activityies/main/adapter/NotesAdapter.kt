package br.com.yournotes.notes.activityies.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.yournotes.R
import br.com.yournotes.notes.activityies.addnote.models.Note

/**
 * Created by thalissonestrela on 4/13/17.
 */
class NotesAdapter(val items: List<Note>, val listener: (Note) -> Unit):
        RecyclerView.Adapter<NotesViewHolder>() {

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) =
            holder.bind(items[position], listener)

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            NotesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list,
                    parent, false))

}