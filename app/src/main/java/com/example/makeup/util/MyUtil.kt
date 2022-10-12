package com.example.makeup.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

class MyUtil {
    companion object {
        //Checks if the internet connection is available
        fun isInternetAvailable(context: Context): Boolean {
            (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).run {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    return this.getNetworkCapabilities(this.activeNetwork)?.hasCapability(
                        NetworkCapabilities.NET_CAPABILITY_INTERNET
                    ) ?: false

                } else {
                    (@Suppress("Deprecation")
                    return this.activeNetworkInfo?.isConnected ?: false)

                }
            }

        }

    }
}