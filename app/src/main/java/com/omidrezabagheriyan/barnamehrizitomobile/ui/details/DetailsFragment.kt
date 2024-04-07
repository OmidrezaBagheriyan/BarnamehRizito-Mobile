package com.omidrezabagheriyan.barnamehrizitomobile.ui.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.omidrezabagheriyan.barnamehrizitomobile.R
import com.omidrezabagheriyan.barnamehrizitomobile.databinding.FragmentDetailsBinding
import com.omidrezabagheriyan.barnamehrizitomobile.domain.models.Task
import com.omidrezabagheriyan.barnamehrizitomobile.utils.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {
    private val binding by viewBinding(FragmentDetailsBinding::bind)
    private val detailsViewModel: DetailsViewModel by viewModels()
    private val navController by lazy {
        findNavController()
    }
    private val navArgs: DetailsFragmentArgs by navArgs()
    private lateinit var task: Task

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setup()
    }

    private fun setup() {
        bindDataToUI(navArgs.task.id)
        manageButtons()
    }

    private fun manageButtons(){
        binding.ivDetailsDelete.setOnClickListener {
            manageDeleteTask(navArgs.task)
        }
        binding.ivDetailsEdit.setOnClickListener {
            manageEditTask(navArgs.task)
        }
    }

    private fun bindDataToUI(id: Int) {
        detailsViewModel.taskById(id)
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                detailsViewModel.details.collect { data ->
                    binding.mtvDetailsTitle.text = data.title
                    binding.mtvDetailsStatus.text = data.taskStatus.name
                    binding.mtvDetailsDescription.text = data.description
                    task = data
                }
            }
        }
    }

    private fun navigateToMain(){
        navController.navigate(DetailsFragmentDirections.actionDetailsFragmentToTasksFragment())
    }

    private fun navigationToEdit(task: Task){
        navController.navigate(DetailsFragmentDirections.actionDetailsFragmentToEditFragment(task))
    }

    private fun manageEditTask(task: Task){
        navigationToEdit(task)
    }
    private fun manageDeleteTask(task: Task) {
        detailsViewModel.deleteTask(task)
        navigateToMain()
    }
}