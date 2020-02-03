package com.example.googlekeeperkotlin.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.googlekeeperkotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        (mainRecycler as RecyclerView).layoutManager = GridLayoutManager(this, 2)
        adapter = MainAdapter()
        (mainRecycler as RecyclerView).adapter = adapter


        viewModel.viewState().observe(this, Observer {
            it?.let {
                adapter.notes = it.notes
            }
        })

    }
}