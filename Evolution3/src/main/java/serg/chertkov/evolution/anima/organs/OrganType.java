package serg.chertkov.evolution.anima.organs;

@SuppressWarnings("unused")
public interface OrganType {
    // Interaction with environment
    char ACTIVATOR_REPRODUCE = 1;
    char ACTIVATOR_EAT_NRG = 10;
    char ACTIVATOR_EAT_MEAT = 11;
    // Interaction with other animals
    char ACTIVATOR_PAIRING = 20;
    char ACTIVATOR_ATTACK = 21;
    // Movement in water
    char ACTIVATOR_MOVE_WATER = 31;
    char ACTIVATOR_JUMP_WATER = 32;
    char ACTIVATOR_TURN_LEFT_WATER = 33;
    char ACTIVATOR_TURN_RIGHT_WATER = 34;
    char ACTIVATOR_TURN_BACK_WATER = 35;
    // Movement in earth
    char ACTIVATOR_MOVE_PLANT = 51;
    char ACTIVATOR_JUMP_PLANT = 52;
    char ACTIVATOR_TURN_LEFT_PLANT = 53;
    char ACTIVATOR_TURN_RIGHT_PLANT = 54;
    char ACTIVATOR_TURN_BACK_PLANT = 55;
    // Movement in mounts
    char ACTIVATOR_MOVE_MOUNTS = 71;
    char ACTIVATOR_JUMP_MOUNTS = 72;
    char ACTIVATOR_TURN_LEFT_MOUNTS = 73;
    char ACTIVATOR_TURN_RIGHT_MOUNTS = 74;
    char ACTIVATOR_TURN_BACK_MOUNTS = 75;

    // Interaction with environment and other animals
    char SENSOR_CELLS_TYPE = 201;
    char SENSOR_CELLS_NRG = 202;
    char SENSOR_CELLS_MEAT = 203;
    char SENSOR_CELLS_ANIMAL = 204;
    // Interaction with internal organs
    char SENSOR_ORGANS_HEALTH = 210;
    char SENSOR_ORGANS_STATUS = 211;

    char FEATURE_DEFENCE = 230;
    char FEATURE_NRG_CAPACITY = 231;
    char FEATURE_MAX_AGE = 232;
    char FEATURE_NEURON_SYSTEM = 240;

    char NEURON = 250;
}
