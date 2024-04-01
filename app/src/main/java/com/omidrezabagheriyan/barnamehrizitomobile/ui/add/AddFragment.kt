package com.omidrezabagheriyan.barnamehrizitomobile.ui.add

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.omidrezabagheriyan.barnamehrizitomobile.R
import com.omidrezabagheriyan.barnamehrizitomobile.databinding.FragmentAddBinding
import com.omidrezabagheriyan.barnamehrizitomobile.domain.models.Task
import com.omidrezabagheriyan.barnamehrizitomobile.domain.models.TaskStatus
import com.omidrezabagheriyan.barnamehrizitomobile.utils.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFragment : Fragment(R.layout.fragment_add) {
    private val binding by viewBinding(FragmentAddBinding::bind)
    private val addViewModel: AddViewModel by viewModels()
    private val navController by lazy { findNavController() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setup()
    }

    private fun setup() {
        setupBtnAddTask()
    }

    private fun setupBtnAddTask() {
        binding.fabAddApply.setOnClickListener {
            checkFields()
        }
    }

    private fun insertTaskToDatabase(task: Task) {
        addViewModel.addTask(task)
    }

    private fun getStatus(): TaskStatus {
        if (binding.cbAddIsDone.isChecked) {
            return TaskStatus.DONE
        }
        return TaskStatus.TASK
    }

    private fun navigateToTasks() {
        navController.navigate(AddFragmentDirections.actionAddFragmentToTasksFragment())
    }

    private fun checkFields() {
        if (binding.tietAddTitle.text!!.isEmpty()) {
            Snackbar.make(
                requireView(),
                getString(R.string.text_toast_title_empty),
                Snackbar.LENGTH_SHORT
            ).setAction(getString(R.string.text_toast_okey)) {
                isHidden
            }.show()
            return
        }

        insertTaskToDatabase(
            Task(
                0,
                binding.tietAddTitle.text.toString(),
                binding.tietAddDescription.text.toString(),
                getStatus()
            )
        )

        navigateToTasks()

    }
}