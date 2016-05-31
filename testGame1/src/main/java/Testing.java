import Fauna.Animals;
import Flora.World;

/**
 * Created by sergey on 29.05.2016.
 */
public class Testing {
    public static void main(String[] args) {
        World.generate(10);
//        Animals a = new Animals();
        Animals.add();
        System.out.println(Animals.get(0).toString());
    }
}
