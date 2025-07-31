package com.tg.societymanagment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tg.societymanagment.adapters.ProjectAdapter
import com.tg.societymanagment.data.ProjectTask
import com.tg.societymanagment.databinding.FragmentFolderBinding
import com.tg.societymanagment.db.DatabaseHelper
import com.tg.societymanagment.model.ProjectFactory
import com.tg.societymanagment.model.ProjectViewModel
import com.tg.societymanagment.model.repositry.ProjectRepo


class FolderFragment : Fragment() {

    private lateinit var binding: FragmentFolderBinding

    var projectlist = listOf<ProjectTask>()


    lateinit var viewmodel : ProjectViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

         val db = DatabaseHelper.getDatabase(requireContext())
         val dao = db.projectDao()
         val repositry = ProjectRepo(dao)
         val factory = ProjectFactory(repositry)

        viewmodel = ViewModelProvider(this,factory)[ProjectViewModel::class.java]

         binding = FragmentFolderBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel.projectList.observe(viewLifecycleOwner){
            projectlist = it
        }

        val recyclerView = binding.rvprojectTask
        val adapter = ProjectAdapter(projectlist)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }


}