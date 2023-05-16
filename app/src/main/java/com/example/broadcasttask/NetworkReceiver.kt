package com.example.broadcasttask

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log

class NetworkReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        // Check for network connectivity changes and update UI or perform actions as needed
        val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        if (networkInfo != null && networkInfo.isConnected) {
            // Network is connected
            Log.d("NetworkReceiver", "Connected")
        } else {
            // Network is disconnected
            Log.d("NetworkReceiver", "Disconnected")
        }
    }
}
