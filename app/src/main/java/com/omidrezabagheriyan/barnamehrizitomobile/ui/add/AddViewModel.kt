package com.omidrezabagheriyan.barnamehrizitomobile.ui.add

import androidx.lifecycle.ViewModel
import com.omidrezabagheriyan.barnamehrizitomobile.domain.repositories.BarnamehRizitoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(private val repository: BarnamehRizitoRepository) :
    ViewModel() {


}