package com.robosoft.weatherappjetpack.presentation.home

import android.content.ContentValues
import android.content.Context
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.robosoft.weatherappjetpack.domain.usecase.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.IOException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(HomeScreenState())
    val state: State<HomeScreenState> = _state

    val timeFormatter = DateTimeFormatter.ofPattern("E, dd MMM yyyy    hh:mm a")

    fun getCurrentDateTime(): String {
        val currentTime = LocalDateTime.now()
        return currentTime.format(timeFormatter).toString()
    }

    @Composable
    fun currentDistrictName():String {
        val context = LocalContext.current
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        val location = remember { mutableStateOf<Location?>(null) }
        val geocoder = Geocoder(context)

        LaunchedEffect(Unit) {
            val locationListener = object : LocationListener {
                override fun onLocationChanged(p0: Location) {
                    location.value = p0
                    locationManager.removeUpdates(this)
                }

                override fun onProviderDisabled(p0: String) {}
                override fun onProviderEnabled(p0: String) {}
                override fun onStatusChanged(p0: String, p1: Int, p2: Bundle?) {}
            }

            try {
                locationManager.requestSingleUpdate(
                    LocationManager.NETWORK_PROVIDER,
                    locationListener,
                    null
                )
            } catch (e: SecurityException) {
                Log.e(ContentValues.TAG, "Security exception: ${e.message}")
            }
        }

        val districtName = location.value?.let { loc ->
            try {
                val addresses = geocoder.getFromLocation(loc.latitude, loc.longitude, 1)
                addresses[0].subAdminArea // Use the subAdminArea property to get the district name
            } catch (e: IOException) {
                Log.e(ContentValues.TAG, "Geocoder exception: ${e.message}")
                null
            }
        } ?: "Unknown District"
        return districtName
    }



}