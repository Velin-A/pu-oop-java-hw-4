package Environment;

import java.awt.*;

public class Unexplored extends Environment {
        /*
            Constructor fot UnexploredTile
            @param row row position
            @param col col position
            @param color tile color
         */
    public Unexplored(int row, int col, Color color){
        this.row   = row;
        this.col   = col;
        this.color = color;
    }
}
