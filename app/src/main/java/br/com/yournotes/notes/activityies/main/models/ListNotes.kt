package br.com.yournotes.notes.activityies.main.models

import java.util.*

/**
 * Created by thalissonestrela on 3/15/17.
 */
data class ListNotes(
        var id: Long,
        var title: String,
        var content: String,
        var list: ArrayList<ListNotes>
)