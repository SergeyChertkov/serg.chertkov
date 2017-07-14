package serg.chertkov.evolution.anima.organs;

public interface OrganFunction {
    double getHealth();
    void damage(double hit);
    boolean getStatus();
    double action(double []impulse);
    void endOfTurn();
    boolean isAlive();
}
