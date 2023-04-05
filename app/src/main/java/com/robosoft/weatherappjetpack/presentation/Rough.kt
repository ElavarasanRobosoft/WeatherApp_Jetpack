package com.robosoft.weatherappjetpack.presentation

import android.Manifest
import android.content.ContentValues.TAG
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import java.io.IOException

@Preview
@Composable
fun CurrentDistrict() {
    val context = LocalContext.current
    val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    val location = remember { mutableStateOf<Location?>(null) }
    val geocoder = Geocoder(context)

    val locationListener = remember {
        object : LocationListener {
            override fun onLocationChanged(p0: Location) {
                location.value = p0
                locationManager.removeUpdates(this)
            }

            override fun onProviderDisabled(p0: String) {}
            override fun onProviderEnabled(p0: String) {}
            override fun onStatusChanged(p0: String, p1: Int, p2: Bundle?) {}
        }
    }

    LaunchedEffect(Unit) {
        try {
            locationManager.requestSingleUpdate(
                LocationManager.NETWORK_PROVIDER,
                locationListener,
                null
            )
        } catch (e: SecurityException) {
            Log.e(TAG, "Security exception: ${e.message}")
        }
    }

    val districtName = location.value?.let { loc ->
        try {
            val addresses = geocoder.getFromLocation(loc.latitude, loc.longitude, 1)
            Log.d(TAG, "Geocoder result: $addresses")
            addresses[0].subAdminArea ?: "Unknown District"
        } catch (e: IOException) {
            Log.e(TAG, "Geocoder exception: ${e.message}")
            "Unknown District"
        }
    } ?: "Unknown District"
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(text = "Current District: $districtName")
    }
}


//fun getLocation(){
//    private lateinit var lastLocation: Location
//    private lateinit var fusedLocationClient: FusedLocationProviderClient
//
//    fusedLocationClient =
//        LocationServices.getFusedLocationProviderClient(this)
//
//    if (ActivityCompat.checkSelfPermission(
//            this,
//            Manifest.permission.ACCESS_FINE_LOCATION
//        ) != PackageManager.PERMISSION_GRANTED
//    ) {
//        ActivityCompat.requestPermissions(
//            this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
//            LOCATION_REQUEST_CODE
//        )
//        return
//    }
//
//    fusedLocationClient.lastLocation.addOnSuccessListener { location ->
//
//        if (location != null) {
//            lastLocation = location
//            val currentLatLong = LatLng(location.latitude, location.longitude)
//
//            latLng = LatLong(location.latitude, location.longitude)
//
//            val sharedPreferences =
//                this.getSharedPreferences(
//                    "sharedPreference",
//                    Context.MODE_PRIVATE
//                )
//            val editor = sharedPreferences?.edit()
//            editor?.putString("currentLat", location.latitude.toString())
//            editor?.putString("currentLong", location.longitude.toString())
//            editor?.apply()
//            Log.d("location", currentLatLong.toString())
//}
//
//
//
//
