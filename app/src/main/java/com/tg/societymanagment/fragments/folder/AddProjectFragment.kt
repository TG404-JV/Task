package com.tg.societymanagment.fragments.folder

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.lifecycleScope
import com.google.android.material.datepicker.MaterialDatePicker
import com.tg.societymanagment.data.ProjectTask
import com.tg.societymanagment.databinding.FragmentAddProjectBinding
import com.tg.societymanagment.db.DatabaseHelper
import com.tg.societymanagment.db.ProjectDao
import com.tg.societymanagment.model.repositry.ProjectRepo
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class AddProjectFragment : Fragment() {

   private lateinit var _binding : FragmentAddProjectBinding
    private  val binding get() = _binding


    private lateinit var db : ProjectDao ;
    private lateinit var projectRepo: ProjectRepo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = DatabaseHelper.getDatabase(requireContext()).projectDao()
        projectRepo = ProjectRepo(db)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentAddProjectBinding.inflate(layoutInflater,container,false)
        return _binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoryList = listOf(
            "Development",
            "Learning",
            "Practice",
            "Research",
            "Maintenance",
            "Bug Fixing",
            "Testing",
            "Deployment",
            "Documentation",
            "Design",
            "Planning",
            "Meeting",
            "Support",
            "Automation",
            "Monitoring",
            "Upgrade",
            "Security",
            "Performance",
            "Data Migration",
            "Integration"
        )

        val taskList = mutableListOf<Pair<String,String>>()

        val adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,categoryList)

        binding.etCategory.setAdapter(adapter)

        binding.etCategory.setOnClickListener {
            binding.etCategory.showDropDown()

        }

        val taskadapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,taskList)
        binding.lvTask.adapter = taskadapter

        binding.btnAddTask.setOnClickListener {
           val taskName = binding.etAddTask.text.toString()
            val taskDate  = binding.etDate.text.toString()
            taskList.add(Pair(taskName, taskDate))
            taskadapter.notifyDataSetChanged()
        }

        binding.etDate.setOnClickListener {
            val datePickerDialog  = MaterialDatePicker.Builder.datePicker().setTitleText("Enter The Task Date").build()
            datePickerDialog.show(childFragmentManager,"TG")

            datePickerDialog.addOnPositiveButtonClickListener { position->
                binding.etDate.setText(SimpleDateFormat("dd/mm/yy", Locale.getDefault()).format(Date(position)))

            }

        }

        binding.btnSave.setOnClickListener {
            val projectName = binding.etProjectName.text.toString()
            val category = binding.etCategory.text.toString()
            val date = binding.etDate.text.toString()


            lifecycleScope.launch {
                projectRepo.addProject(ProjectTask(0,projectName,category,taskList,date,false))
            }

        }

    }

}