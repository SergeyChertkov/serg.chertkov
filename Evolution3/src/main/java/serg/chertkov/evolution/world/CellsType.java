package serg.chertkov.evolution.world;

@SuppressWarnings("unused")
public interface CellsType {
    char WATER = 0;
    char SWAMP = 10;
    char PLANT = 100;
    char HILLS = 110;
    char MOUNTS = 120;

    char MAX_WATER = 64;
    char GROW_WATER = 2;
    char MAX_SWAMP = 128;
    char GROW_SWAMP = 4;
    char MAX_PLANT = 128;
    char GROW_PLANT = 16;
    char MAX_HILLS = 64;
    char GROW_HILLS = 8;
    char MAX_MOUNTS = 32;
    char GROW_MOUNTS = 1;
}
