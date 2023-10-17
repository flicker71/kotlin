package com.example.myblocknotekotlin.ui.home

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myblocknotekotlin.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val root: View = binding.root
        val noteEditText = binding.noteEditText
        val addNoteButton = binding.addNoteButton
        val notesListView = binding.notesListView


        val notes = mutableListOf<String>()
        val adapter = ArrayAdapter(requireContext(), R.layout.simple_list_item_1, notes)
        notesListView.adapter = adapter

        addNoteButton.setOnClickListener {
            val noteText = noteEditText.text.toString()
            if (noteText.isNotEmpty()) {
                notes.add(noteText)
                adapter.notifyDataSetChanged()
                noteEditText.text.clear()
            }
        }

        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}