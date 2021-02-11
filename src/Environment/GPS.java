package Environment;

import Environment.Environment;

import java.awt.*;

public class GPS extends Environment {

    /*
        Constructor for GPS
        @param row row coordinate
        @param col col coordinate
        @param color for GPS
     */
    public GPS (int row, int col, Color color){
        this.row = row;
        this.col = col;
        this.color = color;
    }
    /*
        Method checking if the move we are trying to make is valid
     */
    public boolean isMoveValid(int moveRow, int moveCol){

        int rowCoefficient = Math.abs(moveRow - this.row);
        int colCoefficient = Math.abs(moveCol - this.col);

        return rowCoefficient == 1 || colCoefficient == 1;
    }
}
