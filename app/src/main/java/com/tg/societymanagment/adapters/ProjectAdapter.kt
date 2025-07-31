package com.tg.societymanagment.adapters

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tg.societymanagment.R
import com.tg.societymanagment.data.ProjectTask

class ProjectAdapter(private val projectList: List<ProjectTask>) : RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ProjectViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_projects,parent,false)
        return  ProjectViewHolder(view)
    }
    override fun onBindViewHolder(
        holder: ProjectViewHolder,
        position: Int,
    ) {
        val data = projectList[position]
        holder.title.text = data.projectName
        holder.Category.text = data.category
        val adapter = ArrayAdapter(holder.itemView.context,android.R.layout.simple_list_item_1,data.projectTask.toList())
        holder.projectTaskList.adapter = adapter
    }

    override fun getItemCount() = projectList.size

    inner class ProjectViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val title : TextView = itemView.findViewById(R.id.tvTitle)
        val Category : TextView = itemView.findViewById(R.id.tvCategory)
        val projectTaskList : ListView = itemView.findViewById(R.id.lvProjectTask)


    }
}