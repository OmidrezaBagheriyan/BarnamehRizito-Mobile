package com.omidrezabagheriyan.barnamehrizitomobile.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.omidrezabagheriyan.barnamehrizitomobile.R
import com.omidrezabagheriyan.barnamehrizitomobile.databinding.FragmentMainBinding
import com.omidrezabagheriyan.barnamehrizitomobile.utils.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {
    private val binding by viewBinding(FragmentMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}