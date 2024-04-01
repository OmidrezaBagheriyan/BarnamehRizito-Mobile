package com.omidrezabagheriyan.barnamehrizitomobile.ui.tasks

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.omidrezabagheriyan.barnamehrizitomobile.R
import com.omidrezabagheriyan.barnamehrizitomobile.databinding.FragmentTasksBinding
import com.omidrezabagheriyan.barnamehrizitomobile.utils.viewbinding.viewBinding

class TasksFragment:Fragment(R.layout.fragment_tasks) {
    private val binding by viewBinding(FragmentTasksBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}