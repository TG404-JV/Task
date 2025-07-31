package com.tg.societymanagment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tg.societymanagment.data.Task
import com.tg.societymanagment.databinding.ItemMainTaskBinding
import com.tg.societymanagment.databinding.ItemSubTaskBinding


class TaskAdapter (val list : List<Task>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val GENERAL = 0
        const val IMPORTANT = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (list[position].isImportant) {
            IMPORTANT
        } else {
            GENERAL
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecyclerView.ViewHolder {
        return when (viewType) {
            IMPORTANT -> {
                val view = ItemMainTaskBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                ImpViewHolder(view)
            }

            else -> {
                GeneralViewHolder(ItemSubTaskBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int)
    {
        val item = list[position]
        when(holder)
        {
            is ImpViewHolder -> {
                holder.title.text = item.Title
                holder.subTitle.text = item.subTitle
                holder.time.text = item.startTime
            }
            is GeneralViewHolder -> {
                holder.title.text = item.Title
                holder.subTitle.text = item.subTitle
                holder.time.text = item.startTime
            }

        }
    }

    override fun getItemCount(): Int = list.size

    class ImpViewHolder(binding: ItemMainTaskBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.tvTaskTitle
        val subTitle = binding.tvTaskSubtitle
        val time = binding.tvTime

    }

    class GeneralViewHolder(binding: ItemSubTaskBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.tvTitle
        val subTitle = binding.tvSubTask
        val time = binding.tvTime

    }



}