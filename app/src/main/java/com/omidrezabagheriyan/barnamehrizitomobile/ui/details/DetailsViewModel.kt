package com.omidrezabagheriyan.barnamehrizitomobile.ui.details

import androidx.lifecycle.ViewModel
import com.omidrezabagheriyan.barnamehrizitomobile.domain.repositories.BarnamehRizitoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val repository: BarnamehRizitoRepository) :
    ViewModel() {


}