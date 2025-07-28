package com.tg.societymanagment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tg.societymanagment.adapters.TaskAdapter
import com.tg.societymanagment.databinding.FragmentHomeBinding
import com.tg.societymanagment.db.DatabaseHelper
import com.tg.societymanagment.model.ListModel
import com.tg.societymanagment.model.ListModelFactor
import com.tg.societymanagment.model.repositry.ListRepositry

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    lateinit var  viewModel : ListModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.mainTaskRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)

        val db = DatabaseHelper.getDatabase(requireContext())
        val dao = db.listDao()

        val listrepo = ListRepositry(dao)
        val factory = ListModelFactor(listrepo)


        viewModel = ViewModelProvider(this, factory)[ListModel::class.java]


        viewModel.loadTaskList()



        viewModel.taskList.observe(viewLifecycleOwner){

            val impTask = it.filter { task -> task.isImportant }
            val generalTask = it.filter { task -> !task.isImportant }
            val adapter = TaskAdapter(impTask)
            recyclerView.adapter = adapter
            val adapter2 = TaskAdapter(generalTask)
            val subTaskRecyclerView = binding.subTaskRecyclerView
            subTaskRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            subTaskRecyclerView.adapter = adapter2
        }





    }

}