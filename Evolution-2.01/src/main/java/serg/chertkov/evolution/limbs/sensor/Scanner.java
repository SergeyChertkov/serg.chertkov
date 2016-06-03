package serg.chertkov.evolution.limbs.sensor;

import serg.chertkov.evolution.EvoData;
import serg.chertkov.evolution.limbs.Sensor;
import serg.chertkov.evolution.utils.Utils;
import serg.chertkov.evolution.world.World;

/**
 * Created by sergey on 27.02.2016.
 */
public class Scanner extends Sensor {
    private int offset_x;
    private int offset_y;
    private int type;

    public Scanner(double []coefficient) {
        super(coefficient);
    }

    /**
     *
     * @param X - need coordinate X of animal for this class
     * @param Y - need coordinate Y of animal for this class
     * @return
     */
    @Override
    public double dataCatch(int X, int Y){
        if(property > 404)
            return 0;
        generateXYType();
        return World.getData(type, Utils.offsetCoordinates(X, offset_x),
                Utils.offsetCoordinates(Y, offset_y));
    }

    /**
     * Method converts the scanner property to offset the coordinates and type of scan
     * @return
     */
    private void generateXYType(){
        type = (property - property%81)/81;
        int tmp = property - type*81;
        offset_x = (tmp - tmp%9)/9;
        offset_y = tmp - offset_x*9;
        offset_x -=4;
        offset_y -=4;
    }

}
