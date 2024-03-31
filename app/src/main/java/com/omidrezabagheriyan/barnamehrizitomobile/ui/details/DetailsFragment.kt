package com.omidrezabagheriyan.barnamehrizitomobile.ui.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.omidrezabagheriyan.barnamehrizitomobile.R
import com.omidrezabagheriyan.barnamehrizitomobile.databinding.FragmentDetailsBinding
import com.omidrezabagheriyan.barnamehrizitomobile.utils.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {
    private val binding by viewBinding(FragmentDetailsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}