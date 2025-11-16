package BuilderFacade;

import Factory.devices.*;

public class DeviceAction {
    private final IDevice device;
    private final ActionEnum type;
    private final Object value;

    public DeviceAction(IDevice device, ActionEnum type, Object value) {
        this.device = device;
        this.type = type;
        this.value = value;
    }

    public void execute() throws UnsupportedOperationException {
        switch (type) {
//            Дождаться интерфейса выключения и включения.
//            case TURN_ON:
//                if (device instanceof IDevicePowerControll s)
//                    s.TurnOn();
//                else
//                    throw new UnsupportedOperationException(device.GetName() + " cannot be turned on");
//                break;

//            case TURN_OFF:
//                if (device instanceof IDevicePowerControll s)
//                    s.TurnOff();
//                else
//                    throw new UnsupportedOperationException(device.GetName() + " cannot be turned off");
//                break;

            case ActionEnum.SET_BRIGHTNESS:
                if (device instanceof LightControl d)
                    d.setBrightness((int) value);
                else
                    throw new UnsupportedOperationException(device.getName() + " cannot change brightness");
                break;

            case ActionEnum.SET_TEMPERATURE:
                if (device instanceof ClimateControl t)
                    t.setTemperature((int) value);
                else
                    throw new UnsupportedOperationException(device.getName() + " cannot set temperature");
                break;

            case ActionEnum.ENABLE:
                if (device instanceof Security l)
                    l.enable();
                else
                    throw new UnsupportedOperationException(device.getName() + " cannot enable security");
                break;

            case ActionEnum.DISABLE:
                if (device instanceof Security l)
                    l.disable();
                else
                    throw new UnsupportedOperationException(device.getName() + " cannot disable security");
                break;

            case ActionEnum.START_CLEANING:
                if (device instanceof CleaningControl r)
                    r.startCleaning();
                else
                    throw new UnsupportedOperationException(device.getName() + " cannot start cleaning");
                break;

            case ActionEnum.STOP_CLEANING:
                if (device instanceof CleaningControl r)
                    r.stopCleaning();
                else
                    throw new UnsupportedOperationException(device.getName() + " cannot stop cleaning");
                break;

            case ActionEnum.LIMIT_POWER:
                if (device instanceof EnergyManagement r)
                    r.limitPower((int) value);
                else
                    throw new UnsupportedOperationException(device.getName() + " cannot limit power");
                break;

            case ActionEnum.SET_COLOR:
                if (device instanceof LightControl r)
                    r.setColor((String) value);
                else
                    throw new UnsupportedOperationException(device.getName() + " cannot set color");
                break;

            case ActionEnum.SET_MODE:
                if (device instanceof ClimateControl r)
                    r.setMode((String) value);
                else
                    throw new UnsupportedOperationException(device.getName() + " cannot set mode");
                break;

            case ActionEnum.SET_SCHEDULE:
                if (device instanceof CleaningControl r)
                    r.setSchedule((String) value);
                else
                    throw new UnsupportedOperationException(device.getName() + " cannot set schedule");
                break;

            default:
                throw new IllegalArgumentException("Unknown BuilderFacade.Action type: " + type);
        }
    }
}
