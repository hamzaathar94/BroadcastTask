package com.example.broadcasttask

import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.broadcasttask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding:ActivityMainBinding?=null
    private var networkReceiver:NetworkReceiver?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        networkReceiver= NetworkReceiver()

        // Set listener for switch changes
        binding?.toggleButton2?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Register receiver
                val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
                registerReceiver(networkReceiver, filter)
                Log.d("Filter",""+filter)
            } else {
                // Unregister receiver
                unregisterReceiver(networkReceiver)
            }
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        // Unregister receiver to avoid leaks
        unregisterReceiver(networkReceiver)
    }
}