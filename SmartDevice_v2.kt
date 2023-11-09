open class SmartDevice protected constructor(val name: String, val category: String) {
	
	private var deviceStatus = "Online"
    	
    
    open val deviceType = "unknown"
    
  
    
    open fun turnOn() {
        deviceStatus = "on"
    }
    
    open fun turnOff() {
        deviceStatus = "off"
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
	SmartDevice(name = deviceName, category = deviceCategory) {

        var speakerVolume = 2
        set(value) {
            if(value in 0..100) {
                field = value
            }
        }
        
        var channelNumber = 1
        set(value) {
            if(value in 0..200) {
                field = value
            }
        }
        
        override val deviceType = "Smart TV"
        
        override fun turnOn() {
            super.turnOn()
            println("$name is turned on. Speaker volume is set to $speakerVolume and channel number is " + " set to $channelNumber")
        }
        
        override fun turnOff() {
            super.turnOff()
            println("$name turned off")
        }
        
        fun increaseSpeakerVolume() {
            speakerVolume++
            println("Speaker volume increased to $speakerVolume.")
        }
        
        fun nextChannel() {
            channelNumber++
            println("Channel number increased to $channelNumber")
        }
}
    
class SmartLightDevice(deviceName: String, deviceCategory: String) :
	SmartDevice(name = deviceName, category = deviceCategory) {

        var brightnessLevel = 0
        	set(value) {
                if(value in 0..100) {
                    field = value
                }
            }
         
        override val deviceType = "Smart Light"
         
        override fun turnOn() {
            super.turnOn()
            brightnessLevel = 2
            println("$name is turned on. The brightness level is set to $brightnessLevel")
        } 
        
        override fun turnOff() {
            super.turnOff()
            brightnessLevel = 0
            println("Smart Light turned off")
        }
         
		fun increaseBrightness() {
            brightnessLevel++
            println("Brightness increased to $brightnessLevel")
        }
        
}

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice

) {
    
    var deviceTurnOnCount = 0 
    	private set
    
    fun turnOnTv() {
        smartTvDevice.turnOn()
    }
    
    fun turnOffTv() {
        smartTvDevice.turnOff()
    }
    
    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }
    
    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }
    
    fun turnOnLight() {
        smartLightDevice.turnOn()
    }
    
    fun turnOffLight() {
        smartLightDevice.turnOff()
    }
    
    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }
    
    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}
    
fun main() {
    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
    smartDevice.turnOn()
    
    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()
}
