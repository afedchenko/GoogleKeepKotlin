package com.example.googlekeeperkotlin.ui.main

import Note
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.googlekeeperkotlin.R
import com.example.googlekeeperkotlin.ui.note.NoteActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainRecycler.layoutManager = GridLayoutManager(this, 2)
        adapter = MainAdapter( object : MainAdapter.OnItemClickListener {
            override fun onItemClick(note: Note) {
                openNoteScreen(note)
            }
        })
        mainRecycler.adapter = adapter

        viewModel.viewState().observe(this, Observer {
            it?.let {
                adapter.notes = it.notes
            }
        })
    }

    private fun openNoteScreen(note: Note?) {
        val intent = NoteActivity.getStartIntent(this, note)
        startActivity(intent)
    }
}