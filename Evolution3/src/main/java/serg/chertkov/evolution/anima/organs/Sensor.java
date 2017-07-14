package serg.chertkov.evolution.anima.organs;

import static serg.chertkov.evolution.anima.organs.OrganType.*;

@SuppressWarnings("unused")
public class Sensor extends Organ {
    public Sensor(char[] genes) {
        super(genes);
    }

    @Override
    void setDefaultTypes() {
        super.defaultTypes = new char[] {
                SENSOR_CELLS_TYPE,
                SENSOR_CELLS_NRG,
                SENSOR_CELLS_MEAT,
                SENSOR_CELLS_ANIMAL,
                SENSOR_ORGANS_HEALTH,
                SENSOR_ORGANS_STATUS};
    }
}
