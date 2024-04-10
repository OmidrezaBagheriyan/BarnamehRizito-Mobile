package com.omidrezabagheriyan.barnamehrizitomobile.ui.tasks

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getString
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.omidrezabagheriyan.barnamehrizitomobile.R
import com.omidrezabagheriyan.barnamehrizitomobile.databinding.ItemTaskBinding
import com.omidrezabagheriyan.barnamehrizitomobile.domain.models.Task
import com.omidrezabagheriyan.barnamehrizitomobile.domain.models.TaskStatus

class TaskAdapter(private val context: Context, private val detail: (Task) -> Unit) :
    ListAdapter<Task, TaskAdapter.TaskViewHolder>(
        object : DiffUtil.ItemCallback<Task>() {
            override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
                return oldItem.id == newItem.id
            }
        }
    ) {
    inner class TaskViewHolder(
        private val itemTaskBinding: ItemTaskBinding,
        private val detail: (Task) -> Unit
    ) : RecyclerView.ViewHolder(itemTaskBinding.root) {
        fun bind(task: Task) {
            itemTaskBinding.tvTitle.text = task.title

            itemTaskBinding.tvStatus.text = if (task.taskStatus == TaskStatus.TASK)
                getString(context, R.string.text_task_status)
            else
                getString(context, R.string.text_done_status)
            itemTaskBinding.tvDescription.text = task.description
            itemTaskBinding.root.setOnClickListener {
                detail(task)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder =
        TaskViewHolder(
            ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            detail
        )

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}