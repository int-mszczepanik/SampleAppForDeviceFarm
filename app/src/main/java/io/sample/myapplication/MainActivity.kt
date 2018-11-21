package io.sample.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        launch {
            val profile = "test"
            val number = " ${getProfile()}"

            Toast.makeText(applicationContext, profile+number, Toast.LENGTH_LONG).show()
        }
    }

    private suspend fun getProfile(): Int {
        return withContext(Dispatchers.IO) {
            delay(100)
            10
        }
    }
}