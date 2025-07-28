package com.tg.societymanagment.fragments.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.tg.societymanagment.databinding.BottomsheetAddTaskBinding
import com.tg.societymanagment.R


class BottomsheetAddTask : BottomSheetDialogFragment() {

    private lateinit var binding : BottomsheetAddTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = BottomsheetAddTaskBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val frameLayout = binding.frameContainer

        binding.cvAddTask.setOnClickListener {
            findNavController().navigate(R.id.addTask)
            dismiss()

        }
    }

}