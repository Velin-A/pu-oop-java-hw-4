package Environment;

import java.awt.*;

public class GPSCoordinates extends Environment {

    /*
        Constructor for GPSCoordinates(safeZone)
        @param row row coordinate
        @param col col coordinate
        @param color for CPSCoordinates
     */
    public GPSCoordinates (int row, int col, Color color){
        this.row = row;
        this.col = col;
        this.color = color;
    }
}
