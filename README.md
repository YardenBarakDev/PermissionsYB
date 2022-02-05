[![](https://jitpack.io/v/YardenBarakDev/PermissionsYB.svg)](https://jitpack.io/#YardenBarakDev/PermissionsYB)

Easy to use permission libeary

##
Step 1. Add Maven

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  
Step 2. Add the dependency

  	dependencies {
	        implementation 'com.github.YardenBarakDev:PermissionsYB:v1.0.0.0'
	}


  ## Usage
  

  ###### initiate
  ```
   private val permissionYB = PermissionYB(AppCompatActivity)
  ```
  
  ## Ask for permission
   ```
   permissionYB.askForPermission(Permission.CAMERA)
  ```
  
  ## Listen to callback
   ```
  cameraPermissionCallback = { resultBoolean -> cameraCallBack(resultBoolean) }
  ```
  
  ## Open application settings
   ```
    startActivity(permissionYB.openApplicationSettings(packageName))
  ```
  
  ## Permissions aviliable
  
    CAMERA
    READ_EXTERNAL_STORAGE
    WRITE_EXTERNAL_STORAGE
    READ_CALENDAR
    WRITE_CALENDAR
    READ_CONTACTS
    WRITE_CONTACTS
    RECORD_AUDIO
    READ_SMS
    SEND_SMS
    ACCESS_BACKGROUND_LOCATION
    ACCESS_COARSE_LOCATION
    ACCESS_FINE_LOCATION
    
   ###Each permission has its own callback 
