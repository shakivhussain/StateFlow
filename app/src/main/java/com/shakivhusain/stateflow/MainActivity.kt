package com.shakivhusain.stateflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.shakivhusain.stateflow.ViewModel.MainViewModel
import com.shakivhusain.stateflow.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.increment.setOnClickListener {
            mainViewModel.incrementState()
        }


        mainBinding.decrement.setOnClickListener {
            mainViewModel.decrementState()
        }

        counterResult()
    }

    private fun counterResult() {

        lifecycleScope.launchWhenStarted {

            mainViewModel.counter.collect(){

                mainBinding.result.text=it.toString()

            }

        }

    }
}