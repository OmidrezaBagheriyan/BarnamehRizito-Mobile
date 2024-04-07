package com.omidrezabagheriyan.barnamehrizitomobile.ui.edit

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.omidrezabagheriyan.barnamehrizitomobile.R
import com.omidrezabagheriyan.barnamehrizitomobile.databinding.FragmentEditBinding
import com.omidrezabagheriyan.barnamehrizitomobile.domain.models.Task
import com.omidrezabagheriyan.barnamehrizitomobile.domain.models.TaskStatus
import com.omidrezabagheriyan.barnamehrizitomobile.utils.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditFragment:Fragment(R.layout.fragment_edit) {
    private val binding by viewBinding(FragmentEditBinding::bind)
    private val editViewModel: EditViewModel by viewModels()
    private val navController by lazy {
        findNavController()
    }
    private val navArgs:EditFragmentArgs by navArgs()
    private lateinit var task: Task

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
    }

    private fun setupUI() {
        bindDataToUI()
        setupBtnUpdate()
    }

    private fun isCheckedStatus() {
        when (navArgs.task.taskStatus) {
            TaskStatus.TASK -> {
                binding.cbEditIsDone.isChecked = false
            }

            TaskStatus.DONE -> {
                binding.cbEditIsDone.isChecked = true
            }

            else -> {
                Snackbar.make(
                    requireView(),
                    getString(R.string.text_toast_task_loaded),
                    Snackbar.LENGTH_SHORT
                ).setAction(getString(R.string.text_toast_okey)) {
                    isHidden
                }.show()
            }
        }
    }

    private fun bindDataToUI() {
        binding.tietEditTitle.setText(navArgs.task.title)
        isCheckedStatus()
        binding.tietEditDescription.setText(navArgs.task.description)
    }

    private fun getStatus(): TaskStatus {
        if (binding.cbEditIsDone.isChecked) {
            return TaskStatus.DONE
        }
        return TaskStatus.TASK
    }

    private fun editTaskToDatabase(task: Task) {
        editViewModel.editTask(task)
    }

    private fun checkFields() {
        if (binding.tietEditTitle.text!!.isEmpty()) {
            Snackbar.make(
                requireView(),
                getString(R.string.text_toast_title_empty),
                Snackbar.LENGTH_SHORT
            ).setAction(getString(R.string.text_toast_okey)) {
                isHidden
            }.show()
            return
        }

        editTaskToDatabase(
            Task(
                navArgs.task.id,
                binding.tietEditTitle.text.toString(),
                binding.tietEditDescription.text.toString(),
                getStatus()
            )
        )
        navigateToMain()
    }

    private fun navigateToMain() {
        navController.navigate(EditFragmentDirections.actionEditFragmentToTasksFragment())
    }

    private fun setupBtnUpdate() {
        binding.fabEditApply.setOnClickListener {
            checkFields()
        }
    }
}