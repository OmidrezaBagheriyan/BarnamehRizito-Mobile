package com.omidrezabagheriyan.barnamehrizitomobile.ui.tasks

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.omidrezabagheriyan.barnamehrizitomobile.R
import com.omidrezabagheriyan.barnamehrizitomobile.databinding.FragmentTasksBinding
import com.omidrezabagheriyan.barnamehrizitomobile.domain.models.Task
import com.omidrezabagheriyan.barnamehrizitomobile.domain.models.TaskStatus
import com.omidrezabagheriyan.barnamehrizitomobile.utils.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TasksFragment : Fragment(R.layout.fragment_tasks) {
    private val binding by viewBinding(FragmentTasksBinding::bind)
    private val tasksViewModel: TasksViewModel by viewModels()
    private val navController by lazy { findNavController() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setup()
    }

    private fun setup() {
        setupRVTasks()
        setupRVDones()
        btnToAddTask()
    }

    private fun navigateToAddTask() {
        navController.navigate(TasksFragmentDirections.actionTasksFragmentToAddFragment())
    }

    private fun btnToAddTask() {
        binding.fabTasksAddTask.setOnClickListener {
            navigateToAddTask()
        }
    }

    private fun navigateToDetailsTask(task: Task) {
        navController.navigate(TasksFragmentDirections.actionTasksFragmentToDetailsFragment(task))
    }

    private fun setupRVTasks() {
        tasksViewModel.showTasks(TaskStatus.TASK)

        val tasksAdapter = TaskAdapter(requireContext()) { task ->
            navigateToDetailsTask(task)
        }

        binding.rvTasksListTask.adapter = tasksAdapter

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                tasksViewModel.taskList.collect { data ->
                    tasksAdapter.submitList(data)
                }
            }
        }
    }

    private fun setupRVDones() {
        tasksViewModel.showDones(TaskStatus.DONE)

        val donesAdapter = TaskAdapter(requireContext()) { task ->
            navigateToDetailsTask(task)
        }

        binding.rvTasksListDone.adapter = donesAdapter

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                tasksViewModel.doneList.collect { data ->
                    donesAdapter.submitList(data)
                }
            }
        }
    }
}