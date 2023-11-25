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

class NoteCount : Fragment() {

    private lateinit var textNoteCount: TextView
    private lateinit var viewModel: NoteViewModel

    private var noteCount: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_count, container, false)

        textNoteCount = view.findViewById(R.id.textNoteCount)

        viewModel = ViewModelProvider(requireActivity()).get(NoteViewModel::class.java)

        viewModel.allNotes.observe(viewLifecycleOwner, Observer { notes ->
            noteCount = notes.size
            textNoteCount.text = "Note Count: $noteCount"
        })

        return view
    }
}
