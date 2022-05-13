package com.shakivhusain.stateflow.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _counter: MutableStateFlow<Int> = MutableStateFlow(0)

    // Emit the data in state flow
    val counter: StateFlow<Int> = _counter

    private val _liveData = MutableLiveData("Hello world")
    val liveData: LiveData<String> = _liveData

    private val _stateFlow = MutableStateFlow("Hello World")
    val stateFlow = _stateFlow.asStateFlow()

    private val _sharedFlow = MutableSharedFlow<String>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    fun triggerLiveData() {
        _liveData.value = "Live Data"
    }

    fun triggerStateFlow() {
        _stateFlow.value = "State Flow"
    }

    fun triggerFlow(): Flow<String> {
        return flow {
            repeat(5){
                emit("Item : $it")
                delay(1000L)
            }
        }
    }

    fun triggerSharedFlow(){
        viewModelScope.launch {
            _sharedFlow.emit("Shred Flow")
        }
    }

    fun incrementState() {
        _counter.value++
    }


    fun decrementState() {
        _counter.value--
    }


}