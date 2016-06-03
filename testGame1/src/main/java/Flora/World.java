package Flora;

/**
 * Created by sergey on 30.05.2016.
 */
public class World {
    public static final int WORLD_X = 253;
    public static final int WORLD_Y = 189;
    public static final int maxNrg = 100;
    public static final boolean TOR = true;

    private static Cell [][] cells;

    public static void generate(int nrg) {
        if(nrg>maxNrg) nrg=maxNrg;
        cells = new Cell [WORLD_X][WORLD_Y];
        for(int i=0; i<WORLD_X; i++)
            for(int j=0; j<WORLD_Y; j++)
                cells[i][j] = new Cell(nrg, (int) (Math.random()*100+10), Math.random()*0.2+0.01, false);
    }

    public static void generateCenter(){
        cells = new Cell [WORLD_X][WORLD_Y];
        for(int i=0; i<WORLD_X; i++)
            for(int j=0; j<WORLD_Y; j++){
                if(i<0.2*WORLD_X || i>0.8*WORLD_X || j<0.2*WORLD_Y || j>0.8*WORLD_Y)
                    cells[i][j] = new Cell(10, (int) (Math.random()*10+10), 0.01, false);
                else
                    cells[i][j] = new Cell(10, (int) (Math.random()*100+50), 0.05, false);
            }
    }

    public static Cell get(int x, int y) {
        return cells[x][y];
    }

    public static int getNrg(int X, int Y){
        if(TOR) {
            if (X < 0) X = WORLD_X - 1;
            if (X >= WORLD_X-1) X = 0;
            if (Y < 0) Y = WORLD_Y - 1;
            if (Y >= WORLD_Y-1) Y = 0;
            return cells[X][Y].getNrg();
        }
        else{
            if(X<0 || X>WORLD_X-1 || Y<0 || Y>WORLD_Y-1)
                return 0;
            else return cells[X][Y].getNrg();
        }
    }

    public static void turn (){
        for(int i=0; i<WORLD_X; i++)
            for(int j=0; j<WORLD_Y; j++)
                cells[i][j].turn();
    }

    public static long allNrg(){
        long result = 0;
        for(int i=0; i<WORLD_X; i++)
            for(int j=0; j<WORLD_Y; j++)
                result+=cells[i][j].getNrg();
        return result;
    }

    public static int allAnimals(){
        int result = 0;
        for(int i=0; i<WORLD_X; i++)
            for(int j=0; j<WORLD_Y; j++)
                if(cells[i][j].ifAnimal()) result++;
        return result;
    }

    public static int eat(int x, int y, int nrg){
        return cells[x][y].eat(nrg);
    }

    public static boolean ifAnimal (int x, int y){
        if (x<0 || x>=WORLD_X-1 || y<0 || y>=WORLD_Y-1)
            return true;
        else return cells[x][y].ifAnimal();
    }

    public static void animalComes (int x, int y){
        cells[x][y].animalComes();
    }

    public static void animalLeaves (int x, int y){
        cells[x][y].animalLeaves();
    }
}
