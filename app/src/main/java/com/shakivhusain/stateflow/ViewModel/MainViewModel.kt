package com.shakivhusain.stateflow.ViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {

    private val _counter: MutableStateFlow<Int> = MutableStateFlow(0)
    val counter:StateFlow<Int> = _counter

    fun incrementState() {
        _counter.value++
    }


    fun decrementState() {
        _counter.value--
    }
}