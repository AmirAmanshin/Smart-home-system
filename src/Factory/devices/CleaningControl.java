package Factory.devices;

public interface CleaningControl {
    void startCleaning();
    void stopCleaning();
    void setSchedule(String time);
}