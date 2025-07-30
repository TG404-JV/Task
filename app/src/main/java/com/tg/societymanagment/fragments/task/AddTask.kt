package com.tg.societymanagment.fragments.task

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.tg.societymanagment.R
import com.tg.societymanagment.databinding.FragmentAddTaskBinding


class AddTask : Fragment() {

    val categoryList = listOf("Home", "Work", "Urgent", "Finance", "Personal","other")
    private lateinit var binding : FragmentAddTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddTaskBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,categoryList)
        binding.etCategory.setAdapter(adapter)

        binding.etCategory.setOnClickListener {
            binding.etCategory.showDropDown()  // Methods Shows The ListItem On Edittext when We Click On It
        }

        binding.etCategory.setOnItemClickListener { adapterView, view, i, l ->
            val itemSelected = adapterView.getItemAtPosition(i)
            binding.etCategory.setText(itemSelected.toString())

        }

        binding.etStartTime.setOnClickListener {
            showTimePicker(binding.etStartTime)
        }

        binding.etEndTime.setOnClickListener {
            showTimePicker(binding.etEndTime)
        }
    }


    private fun showTimePicker(view : TextInputEditText) {
        val picker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(10)
            .setMinute(10)
            .setTitleText("Select Time")
            .build()

        picker.show(parentFragmentManager,"timePicker")
        picker.addOnPositiveButtonClickListener {
            var ampm: String
            var hour = picker.hour
            if (picker.hour>12)
            {
                hour -=12
                ampm = "PM"
            }
            else
            {
                ampm = "AM"
            }


            view.text = Editable.Factory.getInstance().newEditable("${hour}:${picker.minute} $ampm")
        }



    }

}