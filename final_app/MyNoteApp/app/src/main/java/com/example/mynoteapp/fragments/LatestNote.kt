package com.example.mynoteapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mynoteapp.Models.NoteViewModel
import com.example.mynoteapp.R

class LatestNote : Fragment() {

    private lateinit var textLatestNoteTitle: TextView
    private lateinit var viewModel: NoteViewModel

    private lateinit var latestNote : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_latest, container, false)

        textLatestNoteTitle = view.findViewById(R.id.textLatestNoteTitle)
        viewModel = ViewModelProvider(requireActivity()).get(NoteViewModel::class.java)

        viewModel.allNotes.observe(viewLifecycleOwner, Observer { notes ->
            if (notes.isNotEmpty()){
                latestNote = notes[notes.size-1].title.toString()
                textLatestNoteTitle.text = "Latest: " + latestNote;
            } else {
                latestNote = "No latest note"
                textLatestNoteTitle.text = latestNote
            }
        })

        return view
    }
}
