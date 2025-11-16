import MainClasses.DeviceInterfaces.*;

public class Action {
    private final IDevice device;
    private final ActionEnum type;
    private final Object value;

    public Action(IDevice device, ActionEnum type, Object value) {
        this.device = device;
        this.type = type;
        this.value = value;
    }

//    DETECT,
//    CALIBRATE,
//    MOVE_FORWARD,
//    MOVE_BACKWARD,
//    TURN_LEFT,
//    TURN_RIGHT

    public void execute() throws UnsupportedOperationException {
        switch (type) {

            case TURN_ON:
                if (device instanceof IDevicePowerControll s)
                    s.TurnOn();
                else
                    throw new UnsupportedOperationException(device.GetName() + " cannot be turned on");
                break;

            case TURN_OFF:
                if (device instanceof IDevicePowerControll s)
                    s.TurnOff();
                else
                    throw new UnsupportedOperationException(device.GetName() + " cannot be turned off");
                break;

            case SET_BRIGHTNESS:
                if (device instanceof IDeviceBrightnessControll d)
                    d.SetBrightness((int) value);
                else
                    throw new UnsupportedOperationException(device.GetName() + " cannot change brightness");
                break;

            case SET_TEMPERATURE:
                if (device instanceof IDeviceThermoControll t)
                    t.SetTemperature((int) value);
                else
                    throw new UnsupportedOperationException(device.GetName() + " cannot set temperature");
                break;

            case LOCK:
                if (device instanceof IDeviceLockControll l)
                    l.Lock();
                else
                    throw new UnsupportedOperationException(device.GetName() + " cannot lock");
                break;

            case UNLOCK:
                if (device instanceof IDeviceLockControll l)
                    l.Unlock();
                else
                    throw new UnsupportedOperationException(device.GetName() + " cannot unlock");
                break;

            case START_RECORDING:
                if (device instanceof IDeviceRecordingControll r)
                    r.StartRecording();
                else
                    throw new UnsupportedOperationException(device.GetName() + " cannot start recording");
                break;

            case STOP_RECORDING:
                if (device instanceof IDeviceRecordingControll r)
                    r.StopRecording();
                else
                    throw new UnsupportedOperationException(device.GetName() + " cannot stop recording");
                break;

            case DETECT:
                if (device instanceof IDeviceSensorControll r)
                    r.Detect();
                else
                    throw new UnsupportedOperationException(device.GetName() + " cannot stop recording");
                break;

            case CALIBRATE:
                if (device instanceof IDeviceSensorControll r)
                    r.Calibrate();
                else
                    throw new UnsupportedOperationException(device.GetName() + " cannot stop recording");
                break;

            default:
                throw new IllegalArgumentException("Unknown Action type: " + type);
        }
    }
}