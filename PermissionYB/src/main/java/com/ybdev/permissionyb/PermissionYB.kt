package com.ybdev.permissionyb

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class PermissionYB(appCompatActivity: AppCompatActivity) {

    var cameraPermissionCallback : ((Boolean) -> Any)? = null
    var readStoragePermissionCallback : ((Boolean) -> Any)? = null
    var writeStoragePermissionCallback : ((Boolean) -> Any)? = null
    var readCalendarPermissionCallback : ((Boolean) -> Any)? = null
    var writeCalendarPermissionCallback : ((Boolean) -> Any)? = null
    var readContactsPermissionCallback : ((Boolean) -> Any)? = null
    var writeContactsPermissionCallback : ((Boolean) -> Any)? = null
    var recordAudioPermissionCallback : ((Boolean) -> Any)? = null
    var readSMSPermissionCallback : ((Boolean) -> Any)? = null
    var sendSMSPermissionCallback : ((Boolean) -> Any)? = null
    var accessBackgroundLocationPermissionCallback : ((Boolean) -> Any)? = null
    var accessCoarseLocationPermissionCallback : ((Boolean) -> Any)? = null
    var accessFineLocationPermissionCallback : ((Boolean) -> Any)? = null



    fun askForPermission(permission: Permission) {
        when (permission) {
            Permission.CAMERA -> {
                checkCameraPermission()
            }
            Permission.READ_EXTERNAL_STORAGE -> {
                checkReadExternalStoragePermission()
            }
            Permission.WRITE_EXTERNAL_STORAGE -> {
                checkWriteExternalStoragePermission()
            }
            Permission.READ_CALENDAR -> {
                checkReadCalendarPermission()
            }
            Permission.WRITE_CALENDAR -> {
                checkWriteCalendarPermission()
            }
            Permission.READ_CONTACTS -> {
                checkReadContactsPermission()
            }
            Permission.WRITE_CONTACTS -> {
                checkWriteContactsPermission()
            }
            Permission.RECORD_AUDIO -> {
                checkRecordAudioPermission()
            }
            Permission.READ_SMS -> {
                checkReadSMSPermission()
            }
            Permission.SEND_SMS -> {
                checkSendSMSPermission()
            }
            Permission.ACCESS_BACKGROUND_LOCATION -> {
                checkAccessBackgroundLocationPermission()
            }
            Permission.ACCESS_COARSE_LOCATION -> {
                checkAccessCoarseLocationPermission()
            }
            Permission.ACCESS_FINE_LOCATION -> {
                checkAccessFineLocationPermission()
            }

        }
    }

    fun openApplicationSettings(packageName: String): Intent {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        val uri: Uri = Uri.fromParts("package", packageName, null)
        intent.data = uri
        return intent
    }

    /** CAMERA **/
    private fun checkCameraPermission() {
        cameraPermission.launch(Manifest.permission.CAMERA)
    }

    private val cameraPermission =
        appCompatActivity.registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            cameraPermissionCallback?.let { callback->
                callback(it)
            }
        }
    /** CAMERA **/

    /** EXTERNAL STORAGE **/
    private fun checkReadExternalStoragePermission() {
        readExternalStorage.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
    }

    private val readExternalStorage =
        appCompatActivity.registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            readStoragePermissionCallback?.let { callback->
                callback(it)
            }
        }

    private fun checkWriteExternalStoragePermission() {
        writeExternalStorage.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }

    private val writeExternalStorage =
        appCompatActivity.registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            writeStoragePermissionCallback?.let {
                callback -> callback(it)
            }
        }
    /** EXTERNAL STORAGE **/


    /** CALENDAR **/
    private fun checkReadCalendarPermission() {
        readCalendarPermission.launch(Manifest.permission.READ_CALENDAR)
    }

    private val readCalendarPermission =
        appCompatActivity.registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            readCalendarPermissionCallback?.let {
                    callback -> callback(it)
            }
        }

    private fun checkWriteCalendarPermission() {
        writeCalendarPermission.launch(Manifest.permission.READ_CALENDAR)
    }

    private val writeCalendarPermission =
        appCompatActivity.registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            writeCalendarPermissionCallback?.let {
                    callback -> callback(it)
            }
        }

    /** CALENDAR **/


    /** CONTACTS **/
    private fun checkReadContactsPermission() {
        readContactsPermission.launch(Manifest.permission.READ_CONTACTS)
    }

    private val readContactsPermission =
        appCompatActivity.registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            readContactsPermissionCallback?.let {
                    callback -> callback(it)
            }
        }

    private fun checkWriteContactsPermission() {
        writeContactsPermission.launch(Manifest.permission.WRITE_CONTACTS)
    }

    private val writeContactsPermission =
        appCompatActivity.registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            writeContactsPermissionCallback?.let {
                    callback -> callback(it)
            }
        }

    /** CONTACTS **/

    /** AUDIO **/
    private fun checkRecordAudioPermission() {
        recordAudioPermission.launch(Manifest.permission.RECORD_AUDIO)
    }

    private val recordAudioPermission =
        appCompatActivity.registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            recordAudioPermissionCallback?.let {
                    callback -> callback(it)
            }
        }
    /** AUDIO **/

    /** SMS **/
    private fun checkReadSMSPermission() {
        readSMSPermission.launch(Manifest.permission.READ_SMS)
    }

    private val readSMSPermission =
        appCompatActivity.registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            readSMSPermissionCallback?.let {
                    callback -> callback(it)
            }
        }

    private fun checkSendSMSPermission() {
        sendSMSPermission.launch(Manifest.permission.SEND_SMS)
    }

    private val sendSMSPermission =
        appCompatActivity.registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            sendSMSPermissionCallback?.let {
                    callback -> callback(it)
            }
        }

    /** SMS **/

    /** LOCATION **/

    private fun checkAccessBackgroundLocationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            accessBackgroundLocationPermission.launch(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        }
    }

    private val accessBackgroundLocationPermission =
        appCompatActivity.registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            accessBackgroundLocationPermissionCallback?.let {
                    callback -> callback(it)
            }
        }

    private fun checkAccessCoarseLocationPermission() {
        accessCoarseLocationPermission.launch(Manifest.permission.ACCESS_COARSE_LOCATION)
    }

    private val accessCoarseLocationPermission =
        appCompatActivity.registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            accessCoarseLocationPermissionCallback?.let {
                    callback -> callback(it)
            }
        }

    private fun checkAccessFineLocationPermission() {
        accessFineLocationPermission.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }

    private val accessFineLocationPermission =
        appCompatActivity.registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            accessFineLocationPermissionCallback?.let {
                    callback -> callback(it)
            }
        }
}

