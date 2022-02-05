package com.ybdev.ybpermissions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ybdev.permissionyb.Permission
import com.ybdev.permissionyb.PermissionYB
import com.ybdev.ybpermissions.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val permissionYB = PermissionYB(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        permissionYB.cameraPermissionCallback = {result -> permissionResult(result)}

        setClickListeners()
    }

    private fun permissionResult(result: Boolean){
        Log.d("jjjj", "permissionResult: $result")
    }

    private fun setClickListeners() {
        with(binding){
            camera.setOnClickListener { permissionYB.askForPermission(Permission.CAMERA) }
            readStorage.setOnClickListener { permissionYB.askForPermission(Permission.READ_EXTERNAL_STORAGE) }
            writeStorage.setOnClickListener {  permissionYB.askForPermission(Permission.WRITE_EXTERNAL_STORAGE)}
            readCalendar.setOnClickListener {  permissionYB.askForPermission(Permission.READ_CALENDAR)}
            writeCalendar.setOnClickListener {  permissionYB.askForPermission(Permission.WRITE_CALENDAR)}
            readContacts.setOnClickListener {  permissionYB.askForPermission(Permission.READ_CONTACTS)}
            writeContacts.setOnClickListener {  permissionYB.askForPermission(Permission.WRITE_CONTACTS)}
            recordAudio.setOnClickListener {  permissionYB.askForPermission(Permission.RECORD_AUDIO)}
            readSms.setOnClickListener {  permissionYB.askForPermission(Permission.READ_SMS)}
            sendSms.setOnClickListener {  permissionYB.askForPermission(Permission.SEND_SMS)}
            accessBackgroundLocation.setOnClickListener {  permissionYB.askForPermission(Permission.ACCESS_BACKGROUND_LOCATION)}
            accessCoarseLocation.setOnClickListener {  permissionYB.askForPermission(Permission.ACCESS_COARSE_LOCATION)}
            accessFineLocation.setOnClickListener {  permissionYB.askForPermission(Permission.ACCESS_FINE_LOCATION)}
            openSettings.setOnClickListener { startActivity(permissionYB.openApplicationSettings(packageName)) }
        }
    }
}
