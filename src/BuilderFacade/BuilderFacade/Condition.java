package BuilderFacade;

import java.time.LocalTime;

public class Condition {
    private final ConditionEnum type;
    private final Object value;

    public Condition(ConditionEnum type, Object value) {
        this.type = type;
        this.value = value;
    }

    public ConditionEnum getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    // Главный метод: проверка условия
    public boolean isMet(StateContext state) {
        switch (type) {
            case TIME_AFTER:
                return LocalTime.now().isAfter((LocalTime) value);

            case TEMP_ABOVE:
                return state.getTemperature() > (int) value;

            case POWER_CONSUMPTION:
                return state.getPowerConsumption() > (int) value;

            default:
                return false;
        }
    }
}
