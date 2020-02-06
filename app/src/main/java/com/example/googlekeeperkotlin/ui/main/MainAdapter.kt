package com.example.googlekeeperkotlin.ui.main

import Note
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.googlekeeperkotlin.R
import kotlinx.android.synthetic.main.item_note.view.*

class MainAdapter(private val onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<MainAdapter.NoteViewHolder>() {

    var notes: List<Note> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        )

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(vh: NoteViewHolder, position: Int) = vh.bind(notes[position])

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(note: Note) = with(itemView) {
            item_note_title.text = note.title
            item_note_body.text = note.note

            val color = when (note.color) {
                Color.WHITE -> R.color.color_white
                Color.VIOLET -> R.color.color_violet
                Color.YELLOW -> R.color.color_yello
                Color.RED -> R.color.color_red
                Color.PINK -> R.color.color_pink
                Color.GREEN -> R.color.color_green
                Color.BLUE -> R.color.color_blue
            }

            (this as CardView).setBackgroundColor(ContextCompat.getColor(itemView.context, color))
            itemView.setOnClickListener { onItemClickListener.onItemClick(note) }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(note: Note)
    }
}
